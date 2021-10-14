package de.quantumrange.woocommerce.route.builder.impl.products;

import com.fasterxml.jackson.databind.JsonNode;
import de.quantumrange.woocommerce.models.Product;
import de.quantumrange.woocommerce.oauth.OAuthConfig;
import de.quantumrange.woocommerce.route.Route;
import de.quantumrange.woocommerce.route.Routes;
import de.quantumrange.woocommerce.route.builder.GetRequestBuilder;

public class DeleteProductRequest extends GetRequestBuilder<Product> {

	public DeleteProductRequest(OAuthConfig config, int id) {
		super(config, Routes.Products.DELETE, id);
	}

	/**
	 * Use true whether to permanently delete the product, Default is false
	 *
	 * @param force Use true whether to permanently delete the product, Default is false.
	 * @return itself
	 */
	public DeleteProductRequest setDeletePermanently(boolean force) {
		put("force", "true");
		return this;
	}

	@Override
	protected Product convert(JsonNode node) {
		return new Product(node);
	}
}
