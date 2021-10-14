package de.quantumrange.woocommerce.route;

import static de.quantumrange.woocommerce.util.HttpRequestType.GET;

public final class Routes {

	public static final class Products {

		/**
		 * <a href="https://woocommerce.github.io/woocommerce-rest-api-docs/#list-all-products">
		 * WooCommerce Documentation / List all Products
		 * </a>
		 */
		public static final Route LIST = new Route("wc/v3/products", GET);

	}

}
