package de.quantumrange.woocommerce.route;

import de.quantumrange.woocommerce.util.HttpRequestType;

import static de.quantumrange.woocommerce.util.HttpRequestType.*;

public final class Routes {

	public static final class Products {

		/**
		 * <a href="https://woocommerce.github.io/woocommerce-rest-api-docs/#list-all-products">
		 * WooCommerce Documentation / List all Products
		 * </a>
		 */
		public static final Route LIST = new Route("wc/v3/products", GET);

		/**
		 * <a href="https://woocommerce.github.io/woocommerce-rest-api-docs/#delete-a-product">
		 *     WooCommerce Documentation / List all Products
		 * </a>
		 */
		public static final Route DELETE = new Route("wc/v3/products/%d", HttpRequestType.DELETE);

		/**
		 * <a href="https://woocommerce.github.io/woocommerce-rest-api-docs/#create-a-product">
		 *     WooCommerce Documentation / Create
		 * </a>
		 */
		public static final Route CREATE = new Route("wc/v3/products", POST);

		/**
		 * <a href="https://woocommerce.github.io/woocommerce-rest-api-docs/#update-a-product">
		 *     WooCommerce Documentation / Update
		 * </a>
		 */
		public static final Route UPDATE = new Route("wc/v3/products/%d", PUT);

	}

	public static final class Variations {

		/**
		 * <a href="https://woocommerce.github.io/woocommerce-rest-api-docs/#create-a-product-variation">
		 *     WooCommerce Documentation / Create Variation
		 * </a>
		 */
		public static final Route CREATE = new Route("wc/v3/products/%d/variations", POST);

	}

}
