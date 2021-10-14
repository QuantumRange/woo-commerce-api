package de.quantumrange.woocommerce.route.builder;

import com.fasterxml.jackson.databind.JsonNode;
import de.quantumrange.woocommerce.oauth.OAuthConfig;
import de.quantumrange.woocommerce.route.Route;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public abstract class RequestBuilder<T> implements Callable<T> {

	protected final OAuthConfig config;
	protected final Route route;
	protected final Object[] args;

	public RequestBuilder(OAuthConfig config, Route route, Object... args) {
		this.config = config;
		this.route = route;
		this.args = args;
	}

	protected abstract T convert(JsonNode node);

}
