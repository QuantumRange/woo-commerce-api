package de.quantumrange.woocommerce.models;

import de.quantumrange.woocommerce.route.builder.Convertable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Download implements Convertable {

	private String id, name, fileURL;

	/**
	 *
	 * @param id File ID
	 * @param name File name.
	 * @param fileURL File URL.
	 */
	public Download(String id, String name, String fileURL) {
		this.id = id;
		this.name = name;
		this.fileURL = fileURL;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileURL() {
		return fileURL;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Download download = (Download) o;
		return Objects.equals(getId(), download.getId()) && Objects.equals(getName(), download.getName()) && Objects.equals(getFileURL(), download.getFileURL());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getFileURL());
	}

	@Override
	public String toString() {
		return "Download{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", fileURL='" + fileURL + '\'' +
				'}';
	}

	@Override
	public Object convert() {
		Map<String, Object> map = new HashMap<>();

		map.put("id", id);
		map.put("name", name);
		map.put("file", fileURL);

		return map;
	}
}
