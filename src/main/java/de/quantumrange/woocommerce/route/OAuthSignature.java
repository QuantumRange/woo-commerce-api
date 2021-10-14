package de.quantumrange.woocommerce.route;

import de.quantumrange.woocommerce.oauth.OAuthConfig;
import de.quantumrange.woocommerce.util.HttpRequestType;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * This code is inspired by Oleksadr Madryk Code.
 *
 * <a href="https://github.com/calatonsystems/wc-api-java/blob/master/src/main/java/com/icoderman/woocommerce/oauth/OAuthSignature.java">
 *     OAuthSignature.java
 * </a>
 *
 * @author Oleksandr Mandryk
 * @author QuantumRange
 */
public class OAuthSignature {

	private static final String UTF_8 = "UTF-8";
	private static final String HMAC_SHA256 = "HmacSHA256";
	private static final String SIGNATURE_METHOD_HMAC_SHA256 = "HMAC-SHA256";
	private static final String BASE_SIGNATURE_FORMAT = "%s&%s&%s";
	private static final String DELETE_PARAM_FORCE = "force";

	private static final String API_URL_FORMAT = "%s/wp-json/%s";

	private enum OAuthHeader {

		OAUTH_CONSUMER_KEY,
		OAUTH_TIMESTAMP,
		OAUTH_NONCE,
		OAUTH_SIGNATURE_METHOD,
		OAUTH_SIGNATURE;

		public String getKey() {
			return name().toLowerCase(Locale.ROOT);
		}

	}

	public static Map<String, String> getMap(OAuthConfig config, CompiledRoute route, Map<String, String> params) {
		Map<String, String> authParams = new HashMap<>();

		authParams.put(OAuthHeader.OAUTH_CONSUMER_KEY.getKey(), config.getConsumerKey());
		authParams.put(OAuthHeader.OAUTH_TIMESTAMP.getKey(), String.valueOf(System.currentTimeMillis() / 1000L));
		authParams.put(OAuthHeader.OAUTH_NONCE.getKey(), UUID.randomUUID().toString());
		authParams.put(OAuthHeader.OAUTH_SIGNATURE_METHOD.getKey(), SIGNATURE_METHOD_HMAC_SHA256);
		authParams.putAll(params);

		if (route.route().type() == HttpRequestType.DELETE) {
			authParams.put(DELETE_PARAM_FORCE, "true");
		}

		authParams.put(OAuthHeader.OAUTH_SIGNATURE.getKey(), generateOAuthSignature(config, route, authParams));

		return authParams;
	}

	public static String getAsQueryString(OAuthConfig config, CompiledRoute route, Map<String, String> params) {
		Map<String, String> oauthParameters = getMap(config, route, params);
		String encodedSignature = oauthParameters.get(OAuthHeader.OAUTH_SIGNATURE.getKey())
				.replace("+", "%2B");
		oauthParameters.put(OAuthHeader.OAUTH_SIGNATURE.getKey(), encodedSignature);
		return mapToString(oauthParameters, "=", "&");
	}

	private static String generateOAuthSignature(OAuthConfig config, CompiledRoute route, Map<String, String> params) {
		String signatureBaseString = getSignatureBaseString(formatUrl(config, route), route.route().type(), params);
		// v1, v2
		String secret = config.getConsumerSecret() + "&";
		return signBaseString(secret, signatureBaseString);
	}

	private static String signBaseString(String secret, String signatureBaseString) {
		try {
			Mac macInstance = Mac.getInstance(HMAC_SHA256);
			SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), HMAC_SHA256);
			macInstance.init(secretKey);
			return Base64.getEncoder().encodeToString(macInstance.doFinal(signatureBaseString.getBytes(StandardCharsets.UTF_8)));
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
			throw new RuntimeException(e);
		}
	}

	public static String formatUrl(OAuthConfig config, CompiledRoute route) {
		return API_URL_FORMAT.formatted(config.getHost(), route.endpoint());
	}

	private static String getSignatureBaseString(String url, HttpRequestType method, Map<String, String> params) {
		String requestURL = urlEncode(url);

		Map<String, String> encodedParams = percentEncodeParameter(params);

		encodedParams = new TreeMap<>(encodedParams);
		String paramsString = mapToString(encodedParams, "%3D", "%26");

		return String.format(BASE_SIGNATURE_FORMAT, method.name(), requestURL, paramsString);
	}

	private static String mapToString(Map<String, String> paramsMap, String keyValueDelimiter, String paramsDelimiter) {
		return paramsMap.entrySet().stream()
				.map(entry -> entry.getKey() + keyValueDelimiter + entry.getValue())
				.collect(Collectors.joining(paramsDelimiter));
	}

	private static String urlEncode(String s) {
		return URLEncoder.encode(s, StandardCharsets.UTF_8);
	}

	private static Map<String, String> percentEncodeParameter(Map<String, String> params) {
		Map<String, String> encodedParamsMap = new HashMap<>();

		for (Map.Entry<String, String> p : params.entrySet()) {
			encodedParamsMap.put(percentEncode(p.getKey()), percentEncode(p.getValue()));
		}

		return encodedParamsMap;
	}

	private static String percentEncode(String s) {
		return URLEncoder.encode(s, StandardCharsets.UTF_8)
				// OAuth encodes some characters differently:
				.replace("+", "%2B")
				.replace("*", "%2A")
				.replace("~", "%7E");
	}

}
