package de.quantumrange.woocommerce.models;

import de.quantumrange.woocommerce.route.builder.Convertable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Dimension implements Convertable {

	private double length, width, height;

	/**
	 *
	 * @param length Product length.
	 * @param width Product width.
	 * @param height Product height.
	 */
	public Dimension(double length, double width, double height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Dimension that = (Dimension) o;
		return Double.compare(that.getLength(), getLength()) == 0 && Double.compare(that.getWidth(), getWidth()) == 0 && Double.compare(that.getHeight(), getHeight()) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getLength(), getWidth(), getHeight());
	}

	@Override
	public String toString() {
		return "Dimensions{" +
				"length=" + length +
				", width=" + width +
				", height=" + height +
				'}';
	}

	@Override
	public Object convert() {
		Map<String, Object> map = new HashMap<>();

		map.put("length", length);
		map.put("width", width);
		map.put("height", height);

		return map;
	}
}
