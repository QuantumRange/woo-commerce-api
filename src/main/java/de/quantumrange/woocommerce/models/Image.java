package de.quantumrange.woocommerce.models;

import de.quantumrange.woocommerce.route.builder.Convertable;
import de.quantumrange.woocommerce.util.JMap;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class Image implements Convertable {

	private int id;
	private final LocalDateTime dateCreated, dateModified;
	private String src, name, alt;

	public Image(int id, LocalDateTime dateCreated, LocalDateTime dateModified, String src, String name, String alt) {
		this.id = id;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
		this.src = src;
		this.name = name;
		this.alt = alt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public LocalDateTime getDateModified() {
		return dateModified;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Image image = (Image) o;
		return getId() == image.getId() && Objects.equals(getDateCreated(), image.getDateCreated()) && Objects.equals(getDateModified(), image.getDateModified()) && Objects.equals(getSrc(), image.getSrc()) && Objects.equals(getName(), image.getName()) && Objects.equals(getAlt(), image.getAlt());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getDateCreated(), getDateModified(), getSrc(), getName(), getAlt());
	}

	@Override
	public String toString() {
		return "Image{" +
				"id=" + id +
				", dateCreated=" + dateCreated +
				", dateModified=" + dateModified +
				", src='" + src + '\'' +
				", name='" + name + '\'' +
				", alt='" + alt + '\'' +
				'}';
	}

	@Override
	public Object convert() {
		JMap map = new JMap();

		map.put("src", src);
		map.put("name", name);
		map.put("alt", alt);

		return map.build();
	}
}
