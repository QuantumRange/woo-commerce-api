package de.quantumrange.woocommerce.route;

import de.quantumrange.woocommerce.oauth.OAuthConfig;
import de.quantumrange.woocommerce.util.HttpRequestType;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public record Route(String url, HttpRequestType type) {

	public CompiledRoute compileGet(OAuthConfig config, Map<String, String> params, Object... args) {
		return new CompiledRoute(config, url.formatted(args), this, params, Collections.emptyMap());
	}

	public CompiledRoute compile(OAuthConfig config, Map<String, Object> data, Object... args) {
		return new CompiledRoute(config, url.formatted(args), this, Collections.emptyMap(), data);
	}

}
