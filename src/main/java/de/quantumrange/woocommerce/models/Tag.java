package de.quantumrange.woocommerce.models;

import de.quantumrange.woocommerce.route.builder.Convertable;
import de.quantumrange.woocommerce.util.JMap;

import java.util.Objects;

public class Tag implements Convertable {

	private int id;
	private final String name, slug;

	public Tag(int id, String name, String slug) {
		this.id = id;
		this.name = name;
		this.slug = slug;
	}

	public Tag(String name, String slug) {
		this(-1, name, slug);
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
		Tag tag = (Tag) o;
		return getId() == tag.getId() && Objects.equals(getName(), tag.getName()) && Objects.equals(getSlug(), tag.getSlug());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getSlug());
	}

	@Override
	public String toString() {
		return "Tag{" +
				"id=" + id +
				", name='" + name + '\'' +
				", slug='" + slug + '\'' +
				'}';
	}

	@Override
	public Object convert() {
		return new JMap()
				.put("name", name)
				.put("slug", slug)
				.build();
	}
}
