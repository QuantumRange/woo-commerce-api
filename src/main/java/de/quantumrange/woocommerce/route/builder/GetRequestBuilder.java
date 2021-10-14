package de.quantumrange.woocommerce.route.builder;

import de.quantumrange.woocommerce.oauth.OAuthConfig;
import de.quantumrange.woocommerce.route.Route;

import java.util.HashMap;
import java.util.Map;

public abstract class GetRequestBuilder<T> extends RequestBuilder<T> {

	private final Map<String, String> query;

	public GetRequestBuilder(OAuthConfig config, Route route, Object... args) {
		super(config, route, args);
		this.query = new HashMap<>();
	}

	public void put(String key, String value) {
		query.put(key, value);
	}

	@Override
	public T call() throws Exception {
		return convert(route.compileGet(config, query, args).call());
	}

}
