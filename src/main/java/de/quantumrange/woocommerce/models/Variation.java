package de.quantumrange.woocommerce.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import de.quantumrange.woocommerce.util.Json;

import java.util.Map;
import java.util.Objects;

public class Variation {

	private int id;
	private Map<String, Object> data;

	public Variation(int id, Map<String, Object> data) {
		this.id = id;
		this.data = data;
	}

	public Variation(JsonNode node) {
		this.id = node.get("id").asInt();
		try {
			this.data = Json.createMapper().treeToValue(node, Map.class);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public int getId() {
		return id;
	}

	public <T> T get(String key) {
		return (T) getObject(key);
	}
	public Object getObject(String key) {
		return data.get(key);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Variation variation = (Variation) o;
		return getId() == variation.getId() && Objects.equals(data, variation.data);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), data);
	}

	@Override
	public String toString() {
		return "Variation{" +
				"id=" + id +
				", data=" + data +
				'}';
	}
}
