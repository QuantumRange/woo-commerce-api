package de.quantumrange.woocommerce.route.builder;

import com.fasterxml.jackson.databind.JsonNode;
import de.quantumrange.woocommerce.oauth.OAuthConfig;
import de.quantumrange.woocommerce.route.Route;

import java.util.HashMap;
import java.util.Map;

public abstract class PostRequestBuilder<T> extends RequestBuilder<T> {

	private final Map<String, Object> data;

	public PostRequestBuilder(OAuthConfig config, Route route, Object... args) {
		super(config, route, args);
		this.data = new HashMap<>();
	}

	public void put(String key, Object value) {
		data.put(key, value);
	}

	@Override
	public T call() throws Exception {
		JsonNode node = route.compile(config, data, args).call();

		try {
			return convert(node);
		} catch (Exception e) {
			System.out.println(node);
			throw new RuntimeException(e);
		}
	}
}
