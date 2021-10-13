package de.quantumrange.woocommerce.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.jetbrains.annotations.NotNull;

import java.awt.Color;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

/**
 * Helps to read/write JSON.
 *
 * @see ObjectMapper
 * @see ObjectReader
 * @see JsonNode
 * @author QuantumRange
 * @since 3.0.0
 */
public class JSON {

	private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
			.appendOptional(DateTimeFormatter.ISO_DATE_TIME)
			.appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
			.appendOptional(DateTimeFormatter.ISO_INSTANT)
			.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
			.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
			.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
			.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
			.toFormatter()
			.withZone(ZoneOffset.UTC);

	private static LocalDateTime parseDateTimeString(String str) {
		return ZonedDateTime.from(JSON.DATE_TIME_FORMATTER.parse(str)).toLocalDateTime();
	}

	private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
			.appendOptional(DateTimeFormatter.ISO_TIME)
			.appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
			.parseDefaulting(ChronoField.YEAR, 2021)
			.parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
			.parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
			.toFormatter()
			.withZone(ZoneOffset.UTC);

	private static LocalTime parseTimeString(String str) {
		return ZonedDateTime.from(JSON.TIME_FORMATTER.parse(str)).toOffsetDateTime().toLocalTime();
	}

	/**
	 * The mapper is taken and all modules with the methods: {@link ObjectMapper#findAndRegisterModules()},
	 *                 {@link ObjectMapper#registerModule(Module)} and {@link ObjectMapper#configure(JsonParser.Feature, boolean)} are added.
	 * Then some own time modules are added.
	 *
	 * @param mapper the mapper to be modified.
	 */
	public static void registerTimeSupport(@NotNull ObjectMapper mapper) {
		mapper.findAndRegisterModules();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		SimpleModule module = new SimpleModule();
		module.addDeserializer(LocalDateTime.class, new JsonDeserializer<>() {
			@Override
			public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
				String value = jsonParser.getText();
				return JSON.parseDateTimeString(value);
			}
		});

		module.addSerializer(Color.class, new JsonSerializer<Color>() {
			@Override
			public void serialize(Color value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
				gen.writeNumber(value.getRGB());
			}
		});

		module.addDeserializer(Color.class, new JsonDeserializer<>() {
			@Override
			public Color deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
				return new Color(jsonParser.getNumberValue().intValue());
			}
		});

		mapper.registerModule(module);
	}

	/**
	 * Creates a mapper and applies the {@link #registerTimeSupport(ObjectMapper)} method to it.
	 *
	 * @return a new mapper with applied {@link #registerTimeSupport(ObjectMapper)}.
	 */
	@NotNull
	public static ObjectMapper createMapper() {
		ObjectMapper mapper = new ObjectMapper();
		registerTimeSupport(mapper);
		return mapper;
	}

}