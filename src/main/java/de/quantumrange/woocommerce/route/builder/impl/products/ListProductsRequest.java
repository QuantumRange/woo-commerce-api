package de.quantumrange.woocommerce.route.builder.impl.products;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import de.quantumrange.woocommerce.models.*;
import de.quantumrange.woocommerce.oauth.OAuthConfig;
import de.quantumrange.woocommerce.route.Routes;
import de.quantumrange.woocommerce.route.builder.GetRequestBuilder;
import de.quantumrange.woocommerce.util.Json;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * A builder for the {@link Routes.Products#LIST} Route.
 *
 * @author QuantumRange
 */
public class ListProductsRequest extends GetRequestBuilder<List<Product>> {

	public ListProductsRequest(OAuthConfig config) {
		super(config, Routes.Products.LIST);
	}

	/**
	 * Scope under which the request is made; determines fields present in response.
	 * Options: view and edit. Default is view.
	 *
	 * @param context is by default view.
	 * @return builder
	 */
	public ListProductsRequest setContext(ContextType context) {
		put("context", context.name().toLowerCase());
		return this;
	}

	/**
	 * Current page of the collection. Default is 1.
	 *
	 * @param page is by default 1.
	 * @return builder
	 */
	public ListProductsRequest setPage(int page) {
		put("page", String.valueOf(page));
		return this;
	}

	/**
	 * Limit results to those matching a string.
	 *
	 * @param search is by default 10.
	 * @return builder
	 */
	public ListProductsRequest setPerPage(String search) {
		put("search", search);
		return this;
	}

	/**
	 * Maximum number of items to be returned in result set. Default is 10.
	 *
	 * @param per_page is by default 10.
	 * @return builder
	 */
	public ListProductsRequest setPerPage(int per_page) {
		put("per_page", String.valueOf(per_page));
		return this;
	}

	/**
	 * Limit response to resources published after a given ISO8601 compliant date.
	 *
	 * @param after Limit response to resources published after a given ISO8601 compliant date.
	 * @return builder
	 */
	public ListProductsRequest setAfter(LocalDateTime after) {
		put("after", after.format(DateTimeFormatter.ISO_DATE_TIME));
		return this;
	}

	/**
	 * Limit response to resources published before a given ISO8601 compliant date.
	 *
	 * @param before Limit response to resources published before a given ISO8601 compliant date.
	 * @return builder
	 */
	public ListProductsRequest setBefore(LocalDateTime before) {
		put("before", before.format(DateTimeFormatter.ISO_DATE_TIME));
		return this;
	}

	/**
	 * Ensure result set excludes specific IDs.
	 *
	 * @param ids Ensure result set excludes specific IDs.
	 * @return builder
	 */
	public ListProductsRequest setExclude(int... ids) {
		put("exclude", Arrays.stream(ids)
				.mapToObj(Integer::toString)
				.collect(Collectors.joining(",")));
		return this;
	}

	/**
	 * Limit result set to specific ids.
	 *
	 * @param ids Limit result set to specific ids.
	 * @return builder
	 */
	public ListProductsRequest setInclude(int... ids) {
		put("include", Arrays.stream(ids)
				.mapToObj(Integer::toString)
				.collect(Collectors.joining(",")));
		return this;
	}

	/**
	 * Offset the result set by a specific number of items.
	 *
	 * @param offset Offset the result set by a specific number of items.
	 * @return builder
	 */
	public ListProductsRequest setOffset(int offset) {
		put("offset", String.valueOf(offset));
		return this;
	}

	/**
	 * Order sort attribute ascending or descending. Options: asc and desc. Default is desc.
	 *
	 * @param order sort attribute ascending or descending. Options: asc and desc. Default is desc.
	 * @return builder
	 */
	public ListProductsRequest setOrder(Order order) {
		put("order", order.getKey());
		return this;
	}

	/**
	 * Sort collection by object attribute. Options: date, id, include, title, slug, price, popularity and rating. Default is date.
	 *
	 * @param orderType Sort collection by object attribute. Options: date, id, include, title, slug, price,
	 *                     popularity and rating. Default is date.
	 * @return builder
	 */
	public ListProductsRequest setOrderBy(OrderType orderType) {
		// The default is date
		if (orderType != OrderType.DATE) {
			put("orderby", orderType.name().toLowerCase(Locale.ROOT));
		}
		return this;
	}

	/**
	 * Limit result set to those of particular parent IDs.
	 *
	 * @param parents Limit result set to those of particular parent IDs.
	 * @return builder
	 */
	public ListProductsRequest setParent(int[] parents) {
		put("parent", Arrays.stream(parents)
				.mapToObj(Integer::toString)
				.collect(Collectors.joining(",")));
		return this;
	}

	/**
	 * Limit result set to all items except those of a particular parent ID.
	 *
	 * @param parentsExclude Limit result set to all items except those of a particular parent ID.
	 * @return builder
	 */
	public ListProductsRequest setParentExclude(int[] parentsExclude) {
		put("parent_exclude", Arrays.stream(parentsExclude)
				.mapToObj(Integer::toString)
				.collect(Collectors.joining(",")));
		return this;
	}

	/**
	 * Limit result set to products with a specific slug.
	 *
	 * @param slug Limit result set to products with a specific slug.
	 * @return builder
	 */
	public ListProductsRequest setSlug(String slug) {
		put("slug", slug);
		return this;
	}

	/**
	 * Limit result set to products assigned a specific status. Options: any, draft, pending, private and publish. Default is any.
	 *
	 * @param status Limit result set to products assigned a specific status. Options: any, draft, pending, private and publish. Default is any.
	 * @return builder
	 */
	public ListProductsRequest setStatus(Status status) {
		put("status", status.name().toLowerCase());
		return this;
	}

	/**
	 * Limit result set to products assigned a specific type. Options: simple, grouped, external and variable.
	 *
	 * @param type Limit result set to products assigned a specific type. Options: simple, grouped, external and variable.
	 * @return builder
	 */
	public ListProductsRequest setType(ProductType type) {
		put("type", type.name().toLowerCase());
		return this;
	}

	/**
	 * Limit result set to products with a specific SKU.
	 *
	 * @param sku Limit result set to products with a specific SKU.
	 * @return builder
	 */
	public ListProductsRequest setSKU(String sku) {
		put("sku", sku);
		return this;
	}

	/**
	 * Limit result set to featured products.
	 *
	 * @param featured Limit result set to featured products.
	 * @return builder
	 */
	public ListProductsRequest setFeatured(boolean featured) {
		put("featured", Boolean.toString(featured));
		return this;
	}

	/**
	 * Limit result set to products assigned a specific category ID.
	 *
	 * @param categoryID Limit result set to products assigned a specific category ID.
	 * @return builder
	 */
	public ListProductsRequest setCategory(int categoryID) {
		put("category", Integer.toString(categoryID));
		return this;
	}

	/**
	 * Limit result set to products assigned a specific tag ID.
	 *
	 * @param tag Limit result set to products assigned a specific tag ID.
	 * @return builder
	 */
	public ListProductsRequest setTag(String tag) {
		put("tag", tag);
		return this;
	}

	/**
	 * Limit result set to products assigned a specific shipping class ID.
	 *
	 * @param shippingClassID Limit result set to products assigned a specific shipping class ID.
	 * @return builder
	 */
	public ListProductsRequest setShippingClass(int shippingClassID) {
		put("shipping_class", Integer.toString(shippingClassID));
		return this;
	}


	/**
	 * Limit result set to products with a specific attribute.
	 *
	 * @param attribute Limit result set to products with a specific attribute.
	 * @return builder
	 */
	public ListProductsRequest setAttribute(String attribute) {
		put("attribute", attribute);
		return this;
	}

	/**
	 * Limit result set to products with a specific attribute term ID (required an assigned attribute).
	 *
	 * @param attributeTerm Limit result set to products with a specific attribute term ID (required an assigned attribute).
	 * @return builder
	 */
	public ListProductsRequest setAttributeTerm(String attributeTerm) {
		put("attribute_term", attributeTerm);
		return this;
	}

	/**
	 * Limit result set to products with a specific tax class. Default options: standard, reduced-rate and zero-rate.
	 *
	 * @param taxClass Limit result set to products with a specific tax class. Default options: standard, reduced-rate and zero-rate.
	 * @return builder
	 */
	public ListProductsRequest setTaxClass(TaxClass taxClass) {
		put("tax_class", taxClass.getKey());
		return this;
	}

	/**
	 * Limit result set to products on sale.
	 *
	 * @param isSale Limit result set to products on sale.
	 * @return builder
	 */
	public ListProductsRequest setOnSale(boolean isSale) {
		put("on_sale", Boolean.toString(isSale));
		return this;
	}

	/**
	 * Limit result set to products based on a minimum price.
	 *
	 * @param minPrice Limit result set to products based on a minimum price.
	 * @return builder
	 */
	public ListProductsRequest setMinPrice(double minPrice) {
		put("min_price", Double.toString(minPrice));
		return this;
	}

	/**
	 * Limit result set to products based on a maximum price.
	 *
	 * @param maxPrice Limit result set to products based on a maximum price.
	 * @return builder
	 */
	public ListProductsRequest setMaxPrice(double maxPrice) {
		put("max_price", Double.toString(maxPrice));
		return this;
	}

	/**
	 * Limit result set to products with specified stock status. Options: instock, outofstock and onbackorder.
	 *
	 * @param status Limit result set to products with specified stock status. Options: instock, outofstock and onbackorder.
	 * @return builder
	 */
	public ListProductsRequest setStockStatus(StockStatus status) {
		put("stock_status", status.name().toLowerCase().replace("_", ""));
		return this;
	}

	@Override
	protected List<Product> convert(JsonNode node) {
		List<Product> products = new ArrayList<>();

		for (int i = 0; i < node.size(); i++) {
			products.add(new Product(node.get(i)));
		}

		return products;
	}

	public enum ContextType {
		VIEW, EDIT
	}

	public enum Order {

		DESCENDING("DESC"),
		ASCENDING("ASC");

		private final String key;

		Order(String key) {
			this.key = key;
		}

		public String getKey() {
			return key;
		}

	}

	public enum OrderType {
		ID,
		INCLUDE,
		TITLE,
		SLUG,
		PRICE,
		POPULARITY,
		RATING,
		DATE
	}

}
