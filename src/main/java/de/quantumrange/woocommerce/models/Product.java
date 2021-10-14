package de.quantumrange.woocommerce.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import de.quantumrange.woocommerce.route.builder.impl.products.CreateProductRequest;
import de.quantumrange.woocommerce.util.Json;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class Product {

	private int id;
	private Map<String, Object> data;

	public Product(int id, Map<String, Object> data) {
		this.id = id;
		this.data = data;
	}

	public Product(JsonNode node) {
		this.id = node.get("id").intValue();
		try {
			this.data = Json.createMapper().treeToValue(node, Map.class);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
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
		Product product = (Product) o;
		return id == product.id && Objects.equals(data, product.data);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, data);
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", data=" + data +
				'}';
	}
}
