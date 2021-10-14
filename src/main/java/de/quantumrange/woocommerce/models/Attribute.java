package de.quantumrange.woocommerce.models;

import de.quantumrange.woocommerce.route.builder.Convertable;
import de.quantumrange.woocommerce.util.JMap;

import java.util.List;
import java.util.Objects;

public class Attribute implements Convertable {

	private int id;
	private String name;
	private int position;
	private boolean visible, variation;
	private List<String> options;

	public Attribute(int id, String name, int position, boolean visible, boolean variation, List<String> options) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.visible = visible;
		this.variation = variation;
		this.options = options;
	}

	public Attribute(String name, int position, boolean visible, boolean variation, List<String> options) {
		this(-1, name, position, visible, variation, options);
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

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isVariation() {
		return variation;
	}

	public void setVariation(boolean variation) {
		this.variation = variation;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Attribute attribute = (Attribute) o;
		return getId() == attribute.getId() && getPosition() == attribute.getPosition() && isVisible() == attribute.isVisible() && isVariation() == attribute.isVariation() && Objects.equals(getName(), attribute.getName()) && Objects.equals(getOptions(), attribute.getOptions());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getPosition(), isVisible(), isVariation(), getOptions());
	}

	@Override
	public String toString() {
		return "Attribute{" +
				"id=" + id +
				", name='" + name + '\'' +
				", position=" + position +
				", visible=" + visible +
				", variation=" + variation +
				", options=" + options +
				'}';
	}

	@Override
	public Object convert() {
		JMap map = new JMap();

		map.put("name", name);
		map.put("position", position);
		map.put("visible", visible);
		map.put("variation", variation);
		map.put("options", options);

		return map.build();
	}
}
