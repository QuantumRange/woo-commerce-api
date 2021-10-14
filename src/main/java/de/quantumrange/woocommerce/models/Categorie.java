package de.quantumrange.woocommerce.models;

import de.quantumrange.woocommerce.route.builder.Convertable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Categorie implements Convertable {

	private int id;
	private final String name, slug;

	public Categorie(int id, String name, String slug) {
		this.id = id;
		this.name = name;
		this.slug = slug;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getSlug() {
		return slug;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Categorie that = (Categorie) o;
		return getId() == that.getId() && Objects.equals(getName(), that.getName()) && Objects.equals(getSlug(), that.getSlug());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getSlug());
	}

	@Override
	public String toString() {
		return "Categories{" +
				"id=" + id +
				", name='" + name + '\'' +
				", slug='" + slug + '\'' +
				'}';
	}

	@Override
	public Object convert() {
		Map<String, Object> map = new HashMap<>();

		map.put("id", id);
		map.put("name", name);
		map.put("slug", slug);

		return map;
	}
}
