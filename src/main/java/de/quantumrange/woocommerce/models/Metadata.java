package de.quantumrange.woocommerce.models;

import de.quantumrange.woocommerce.route.builder.Convertable;
import de.quantumrange.woocommerce.util.JMap;

import java.util.Objects;

public class Metadata implements Convertable {

	private final int id;
	private String key, value;

	public Metadata(int id, String key, String value) {
		this.id = id;
		this.key = key;
		this.value = value;
	}

	public Metadata(String key, String value) {
		this(-1, key, value);
	}

	public int getId() {
		return id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Metadata metadata = (Metadata) o;
		return getId() == metadata.getId() && Objects.equals(getKey(), metadata.getKey()) && Objects.equals(getValue(), metadata.getValue());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getKey(), getValue());
	}

	@Override
	public String toString() {
		return "Metadata{" +
				"id=" + id +
				", key='" + key + '\'' +
				", value='" + value + '\'' +
				'}';
	}

	@Override
	public Object convert() {
		return new JMap()
				.put("key", key)
				.put("value", value)
				.build();
	}
}
