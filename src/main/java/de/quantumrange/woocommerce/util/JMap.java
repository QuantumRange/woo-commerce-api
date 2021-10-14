package de.quantumrange.woocommerce.util;

import de.quantumrange.woocommerce.route.builder.Convertable;

import java.util.HashMap;
import java.util.Map;

public class JMap {

	private final Map<String, Object> map;

	public JMap() {
		this.map = new HashMap<>();
	}

	public JMap put(String key, Object value) {
		map.put(key, value);
		return this;
	}

	public Map<String, Object> build() {
		return map;
	}

	public static Object pack(Convertable... convertibles) {
		Object[] objs = new Object[convertibles.length];

		for (int i = 0; i < objs.length; i++) {
			objs[i] = convertibles[i].convert();
		}

		return objs;
	}

}
