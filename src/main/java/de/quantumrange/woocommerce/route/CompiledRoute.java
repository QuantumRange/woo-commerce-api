package de.quantumrange.woocommerce.route;

import com.fasterxml.jackson.databind.JsonNode;
import de.quantumrange.woocommerce.oauth.OAuthConfig;
import de.quantumrange.woocommerce.util.Json;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.Callable;

/**
 * A {@link CompiledRoute} is the {@link Route} with extra information required for requesting the url.
 * The {@link #data()} get encoded into json and attached to the request.
 */
public record CompiledRoute(OAuthConfig config,
							Route route,
							Map<String, String> query,
							Map<String, Objects> data) implements Callable<JsonNode> {

	private static final String CONTENT_TYPE = "Content-Type";
	private static final String APPLICATION_JSON = "application/json";

	@Override
	public JsonNode call() throws Exception {
		return switch (route.type()) {
			case GET -> get();
			case POST -> post();
			case PUT -> put();
			case DELETE -> delete();
			default -> throw new IllegalStateException("Unexpected value: " + route.type());
		};
	}

	private JsonNode post() throws URISyntaxException, IOException {
		HttpPost httpPost = new HttpPost(buildURI(buildURL()));

		httpPost.setHeader(CONTENT_TYPE, APPLICATION_JSON);

		return execute(httpPost);
	}

	private JsonNode get() throws URISyntaxException, IOException {
		HttpGet httpGet = new HttpGet(buildURI(buildURL()));

		System.out.println("> " + httpGet.getURI());

		return execute(httpGet);
	}

	private JsonNode put() throws URISyntaxException, IOException {
		HttpPut httpPut = new HttpPut(buildURI(buildURL()));

		httpPut.setHeader(CONTENT_TYPE, APPLICATION_JSON);

		return execute(httpPut);
	}

	private JsonNode delete() throws URISyntaxException, IOException {
		HttpDelete httpDelete = new HttpDelete(buildURI(buildURL()));

		httpDelete.setHeader(CONTENT_TYPE, APPLICATION_JSON);

		return execute(httpDelete);
	}

	private JsonNode execute(HttpRequestBase httpRequest) throws IOException {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpResponse httpResponse = httpClient.execute(httpRequest);
		HttpEntity httpEntity = httpResponse.getEntity();

		if (httpEntity == null) throw new RuntimeException("Error retrieving results from http request");

		JsonNode tree = Json.createMapper()
				.reader()
				.readTree(httpEntity.getContent());

		httpRequest.releaseConnection();

		return tree;
	}

	private String buildURL() {
		return OAuthSignature.formatUrl(config, route);
	}

	private URI buildURI(String url) throws URISyntaxException {
		return buildURI(url, new HashMap<>());
	}

	private URI buildURI(String url, Map<String, String> params) throws URISyntaxException {
		URIBuilder uriBuilder = new URIBuilder(url);
		uriBuilder.addParameters(getParametersAsList(OAuthSignature.getMap(config, route, params)));
		return uriBuilder.build();
	}

	private List<NameValuePair> getParametersAsList(Map<String, String> params) {
		List<NameValuePair> postParameters = new ArrayList<>();
		for (String key : params.keySet()) {
			postParameters.add(new BasicNameValuePair(key, params.get(key)));
		}
		return postParameters;
	}

}
