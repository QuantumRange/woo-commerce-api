package de.quantumrange.woocommerce.models;

import de.quantumrange.woocommerce.route.builder.Convertable;
import de.quantumrange.woocommerce.util.JMap;

import java.util.Objects;

public class DefaultAttribute implements Convertable {

	private int id;
	private String name, option;

	public DefaultAttribute(int id, String name, String option) {
		this.id = id;
		this.name = name;
		this.option = option;
	}

	public DefaultAttribute(String name, String option) {
		this(-1, name, option);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DefaultAttribute that = (DefaultAttribute) o;
		return getId() == that.getId() && Objects.equals(getName(), that.getName()) && Objects.equals(getOption(), that.getOption());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getOption());
	}

	@Override
	public String toString() {
		return "DefaultAttribute{" +
				"id=" + id +
				", name='" + name + '\'' +
				", option='" + option + '\'' +
				'}';
	}

	@Override
	public Object convert() {
		return new JMap()
				.put("name", name)
				.put("option", option)
				.build();
	}
}
