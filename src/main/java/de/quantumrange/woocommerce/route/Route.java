package de.quantumrange.woocommerce.route;

import de.quantumrange.woocommerce.oauth.OAuthConfig;
import de.quantumrange.woocommerce.util.HttpRequestType;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public record Route(String url, HttpRequestType type) {

	public CompiledRoute compile(OAuthConfig config, Map<String, String> params, Map<String, Objects> data) {
		return new CompiledRoute(config, this, params, data);
	}

	public CompiledRoute compile(OAuthConfig config, Map<String, String> params) {
		return compile(config, params, Collections.emptyMap());
	}

}
