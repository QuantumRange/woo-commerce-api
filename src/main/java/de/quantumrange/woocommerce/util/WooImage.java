package de.quantumrange.woocommerce.util;

import java.util.HashMap;
import java.util.Map;

public class WooImage {

	public static Object getImage(String src, String name, String alt) {
		Map<String, Object> objs = new HashMap<>();

		objs.put("src", src);
		objs.put("name", name);
		objs.put("alt", alt);

		return objs;
	}

	public static Object getImage(long id) {
		Map<String, Object> objs = new HashMap<>();

		objs.put("id", id);

		return objs;
	}

}
