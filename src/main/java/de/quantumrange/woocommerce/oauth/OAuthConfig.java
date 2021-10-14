package de.quantumrange.woocommerce.oauth;

import de.quantumrange.woocommerce.route.APIVersion;

import java.util.Objects;

import static de.quantumrange.woocommerce.route.APIVersion.V3;

public class OAuthConfig {

	private final String host;
	private final String consumerKey, consumerSecret;
	private final APIVersion version;

	/**
	 *
	 * @param host is the WordPress Website url/host, for example: <a href="">https://woocommerce.com</a>.
	 * @param consumerKey is starts with 'ck_' and you get one by go into WooCommerce/Settings/REST-API.
	 * @param consumerSecret is starts with 'cs_' and you get one by go into WooCommerce/Settings/REST-API.
	 * @param version is the current {@link APIVersion} of the host.
	 */
	public OAuthConfig(String host, String consumerKey, String consumerSecret, APIVersion version) {
		if (host.endsWith("/")) host = host.substring(0, host.length() - 1);
		this.host = host;
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
		this.version = version;
	}

	/**
	 * The {@link APIVersion} is automatic the newest supported Version.
	 *
	 * @param host is the WordPress Website url/host, for example: <a href="">https://woocommerce.com</a>.
	 * @param consumerKey is starts with 'ck_' and you get one by go into WooCommerce/Settings/REST-API.
	 * @param consumerSecret is starts with 'cs_' and you get one by go into WooCommerce/Settings/REST-API.
	 */
	public OAuthConfig(String host, String consumerKey, String consumerSecret) {
		this(host, consumerKey, consumerSecret, V3);
	}

	public String getHost() {
		return host;
	}

	public String getConsumerKey() {
		return consumerKey;
	}

	public String getConsumerSecret() {
		return consumerSecret;
	}

	public APIVersion getVersion() {
		return version;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OAuthConfig that = (OAuthConfig) o;
		return Objects.equals(getHost(), that.getHost()) && Objects.equals(getConsumerKey(), that.getConsumerKey()) && Objects.equals(getConsumerSecret(), that.getConsumerSecret()) && getVersion() == that.getVersion();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getHost(), getConsumerKey(), getConsumerSecret(), getVersion());
	}

	@Override
	public String toString() {
		return "OAuthConfig{" +
				"host='" + host + '\'' +
				", consumerKey='" + consumerKey + '\'' +
				", consumerSecret='" + consumerSecret + '\'' +
				", version=" + version +
				'}';
	}
}
