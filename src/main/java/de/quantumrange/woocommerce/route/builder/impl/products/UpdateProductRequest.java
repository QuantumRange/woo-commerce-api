package de.quantumrange.woocommerce.route.builder.impl.products;

import com.fasterxml.jackson.databind.JsonNode;
import de.quantumrange.woocommerce.models.*;
import de.quantumrange.woocommerce.oauth.OAuthConfig;
import de.quantumrange.woocommerce.route.Routes;
import de.quantumrange.woocommerce.route.builder.PostRequestBuilder;
import de.quantumrange.woocommerce.util.JMap;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdateProductRequest extends PostRequestBuilder<Product> {

	public UpdateProductRequest(OAuthConfig config, long productID) {
		super(config, Routes.Products.UPDATE, productID);
	}

	/**
	 * Product name.
	 *
	 * @param name Product name.
	 * @return itself
	 */
	public UpdateProductRequest setName(String name)  {
		put("name",  name);
		return this;
	}

	/**
	 * Product slug.
	 *
	 * @param slug Product slug.
	 * @return itself
	 */
	public UpdateProductRequest setSlug(String slug)  {
		put("slug",  null);
		return this;
	}

	/**
	 * Product type. Options: simple, grouped, external and variable. Default is simple.
	 *
	 * @param type Product type. Options: simple, grouped, external and variable. Default is simple.
	 * @return itself
	 */
	public UpdateProductRequest setType(ProductType type)  {
		put("type", type.name().toLowerCase());
		return this;
	}

	/**
	 * Product status (post status). Options: draft, pending, private and publish. Default is publish.
	 *
	 * @param status Product status (post status). Options: draft, pending, private and publish. Default is publish.
	 * @return itself
	 */
	public UpdateProductRequest setStatus(Status status)  {
		put("status", status.name().toLowerCase());
		return this;
	}

	/**
	 * Featured product. Default is false.
	 *
	 * @param featured Featured product. Default is false.
	 * @return itself
	 */
	public UpdateProductRequest setFeatured(boolean featured)  {
		put("featured", Boolean.toString(featured));
		return this;
	}

	/**
	 * Catalog visibility. Options: visible, catalog, search and hidden. Default is visible.
	 *
	 * @param visibility Catalog visibility. Options: visible, catalog, search and hidden. Default is visible.
	 * @return itself
	 */
	public UpdateProductRequest setCatalogVisibility(CatalogVisibility visibility)  {
		put("catalog_visibility", visibility.name().toLowerCase());
		return this;
	}
	/**
	 * Product description.
	 *
	 * @param description Product description.
	 * @return itself
	 */
	public UpdateProductRequest setDescription(String description)  {
		put("description", description);
		return this;
	}

	/**
	 * Product short description.
	 *
	 * @param shortDescription Product short description.
	 * @return itself
	 */
	public UpdateProductRequest setShortDescription(String shortDescription)  {
		put("short_description", shortDescription);
		return this;
	}

	/**
	 * Unique identifier.
	 *
	 * @param sku Unique identifier.
	 * @return itself
	 */
	public UpdateProductRequest setSKU(String sku)  {
		put("sku",  null);
		return this;
	}

	/**
	 * Product regular price.
	 *
	 * @param regularPrice Product regular price.
	 * @return itself
	 */
	public UpdateProductRequest setRegularPrice(double regularPrice)  {
		put("regular_price", Double.toString(regularPrice));
		return this;
	}

	/**
	 * Product sale price.
	 *
	 * @param salePrice Product sale price.
	 * @return itself
	 */
	public UpdateProductRequest setSalePrice(double salePrice)  {
		put("sale_price", Double.toString(salePrice));
		return this;
	}

	/**
	 *
	 * @param from Start date of sale price, in the site's timezone.
	 * @param to End date of sale price, in the site's timezone.
	 * @param price Product sale price.
	 * @return itself
	 */
	public UpdateProductRequest setSale(LocalDateTime from, LocalDateTime to, double price) {
		setSaleDateFrom(from);
		setSaleDateTo(to);
		setSalePrice(price);
		return this;
	}

	/**
	 * Start date of sale price, in the site's timezone.
	 *
	 * @param from Start date of sale price, in the site's timezone.
	 * @return itself
	 */
	public UpdateProductRequest setSaleDateFrom(LocalDateTime from)  {
		put("date_on_sale_from", from.format(DateTimeFormatter.ISO_DATE_TIME));
		return this;
	}
	/**
	 * End date of sale price, in the site's timezone.
	 *
	 * @param to End date of sale price, in the site's timezone.
	 * @return itself
	 */
	public UpdateProductRequest setSaleDateTo(LocalDateTime to)  {
		put("date_on_sale_to", to.format(DateTimeFormatter.ISO_DATE_TIME));
		return this;
	}

	/**
	 * If the product is virtual. Default is false.
	 *
	 * @param virtual If the product is virtual. Default is false.
	 * @return itself
	 */
	public UpdateProductRequest setVirtual(boolean virtual)  {
		put("virtual", Boolean.toString(virtual));
		return this;
	}

	/**
	 * If the product is downloadable. Default is false.
	 *
	 * @param downloadable If the product is downloadable. Default is false.
	 * @return itself
	 */
	public UpdateProductRequest setDownloadable(boolean downloadable)  {
		put("downloadable", Boolean.toString(downloadable));
		return this;
	}

	/**
	 * List of downloadable files.
	 *
	 * @param downloads List of downloadable files.
	 * @return itself
	 */
	public UpdateProductRequest setDownloads(Download... downloads)  {
		put("downloads", JMap.pack(downloads));
		return this;
	}

	/**
	 * Number of times downloadable files can be downloaded after purchase. Default is -1.
	 *
	 * @param downloadLimit Number of times downloadable files can be downloaded after purchase. Default is -1.
	 * @return itself
	 */
	public UpdateProductRequest setDownloadLimit(int downloadLimit)  {
		put("download_limit", downloadLimit);
		return this;
	}

	/**
	 * Number of days until access to downloadable files expires. Default is -1.
	 *
	 * @param downloadExpiry Number of days until access to downloadable files expires. Default is -1.
	 * @return itself
	 */
	public UpdateProductRequest setDownloadExpiry(int downloadExpiry)  {
		put("download_expiry", downloadExpiry);
		return this;
	}
	/**
	 * Product external URL. Only for external products.
	 *
	 * @param externalUrl Product external URL. Only for external products.
	 * @return itself
	 */
	public UpdateProductRequest setExternalUrl(String externalUrl)  {
		put("external_url", externalUrl);
		return this;
	}

	/**
	 * Product external button text. Only for external products.
	 *
	 * @param buttonText Product external button text. Only for external products.
	 * @return itself
	 */
	public UpdateProductRequest setButtonText(String buttonText)  {
		put("button_text", buttonText);
		return this;
	}

	/**
	 * Tax status. Options: taxable, shipping and none. Default is taxable.
	 *
	 * @param taxStatus Tax status. Options: taxable, shipping and none. Default is taxable.
	 * @return itself
	 */
	public UpdateProductRequest setTaxStatus(TaxStatus taxStatus)  {
		put("tax_status", taxStatus.name().toLowerCase());
		return this;
	}

	/**
	 * Tax class.
	 *
	 * @param taxClass Tax class.
	 * @return itself
	 */
	public UpdateProductRequest setTaxClass(TaxClass taxClass)  {
		put("tax_class", taxClass);
		return this;
	}

	/**
	 * Stock management at product level. Default is false.
	 *
	 * @param manageStock Stock management at product level. Default is false.
	 * @return itself
	 */
	public UpdateProductRequest setManageStock(boolean manageStock)  {
		put("manage_stock", manageStock);
		return this;
	}

	/**
	 * Stock quantity.
	 *
	 * @param stockQuantity Stock quantity.
	 * @return itself
	 */
	public UpdateProductRequest setStockQuantity(int stockQuantity)  {
		put("stock_quantity", stockQuantity);
		return this;
	}

	/**
	 * Controls the stock status of the product. Options: instock, outofstock, onbackorder. Default is instock.
	 *
	 * @param status Controls the stock status of the product. Options: instock, outofstock, onbackorder. Default is instock.
	 * @return itself
	 */
	public UpdateProductRequest setStockStatus(StockStatus status)  {
		put("stock_status", status.name().toLowerCase().replace(" ", ""));
		return this;
	}

	/**
	 * If managing stock, this controls if backorders are allowed. Options: no, notify and yes. Default is no.
	 *
	 * @param status If managing stock, this controls if backorders are allowed. Options: no, notify and yes. Default is no.
	 * @return itself
	 */
	public UpdateProductRequest setBackOrders(BackorderStatus status)  {
		put("backorders", status.name().toLowerCase());
		return this;
	}

	/**
	 * Allow one item to be bought in a single order. Default is false.
	 *
	 * @param soldIndividually Allow one item to be bought in a single order. Default is false.
	 * @return itself
	 */
	public UpdateProductRequest setSoldIndividually(boolean soldIndividually)  {
		put("sold_individually", soldIndividually);
		return this;
	}

	/**
	 * Product weight.
	 *
	 * @param weight Product weight.
	 * @return itself
	 */
	public UpdateProductRequest setWeight(double weight)  {
		put("weight", weight);
		return this;
	}

	/**
	 * Product dimensions.
	 *
	 * @param dimension Product dimensions.
	 * @return itself
	 */
	public UpdateProductRequest setDimensions(Dimension dimension)  {
		put("dimensions", dimension.convert());
		return this;
	}

	/**
	 * Allow reviews. Default is true.
	 *
	 * @param reviewsAllowed Allow reviews. Default is true.
	 * @return itself
	 */
	public UpdateProductRequest setReviewsAllowed(boolean reviewsAllowed)  {
		put("reviews_allowed", reviewsAllowed);
		return this;
	}

	/**
	 * List of up-sell products IDs.
	 *
	 * @param ids List of up-sell products IDs.
	 * @return itself
	 */
	public UpdateProductRequest setUpSellIds(int... ids)  {
		put("upsell_ids", ids);
		return this;
	}

	/**
	 * List of cross-sell products IDs.
	 *
	 * @param ids List of cross-sell products IDs.
	 * @return itself
	 */
	public UpdateProductRequest setCrossSellIds(int... ids)  {
		put("cross_sell_ids", ids);
		return this;
	}

	/**
	 * Product parent ID.
	 *
	 * @param id Product parent ID.
	 * @return itself
	 */
	public UpdateProductRequest setParentId(int id)  {
		put("parent_id", id);
		return this;
	}

	/**
	 * Optional note to send the customer after purchase.
	 *
	 * @param purchaseNote Optional note to send the customer after purchase.
	 * @return itself
	 */
	public UpdateProductRequest setPurchaseNote(String purchaseNote)  {
		put("purchase_note", purchaseNote);
		return this;
	}

	/**
	 * List of categories.
	 *
	 * @param categories List of categories.
	 * @return itself
	 */
	public UpdateProductRequest setCategories(Categorie... categories)  {
		put("categories", JMap.pack(categories));
		return this;
	}

	/**
	 * List of tags.
	 *
	 * @param tags List of tags.
	 * @return itself
	 */
	public UpdateProductRequest setTags(Tag... tags)  {
		put("tags",  null);
		return this;
	}

	/**
	 * List of images.
	 *
	 * @param images List of images.
	 * @return itself
	 */
	public UpdateProductRequest setImages(Image... images)  {
		put("images", JMap.pack(images));
		return this;
	}

	/**
	 * List of attributes.
	 *
	 * @param attributes List of attributes.
	 * @return itself
	 */
	public UpdateProductRequest setAttributes(Attribute... attributes)  {
		put("attributes", JMap.pack(attributes));
		return this;
	}

	/**
	 * Defaults variation attributes.
	 *
	 * @param defaultAttributes Defaults variation attributes.
	 * @return itself
	 */
	public UpdateProductRequest setDefaultAttributes(DefaultAttribute... defaultAttributes)  {
		put("default_attributes", JMap.pack(defaultAttributes));
		return this;
	}

	/**
	 * List of grouped products ID.
	 *
	 * @param groupedProducts List of grouped products ID.
	 * @return itself
	 */
	public UpdateProductRequest setGroupProducts(int[] groupedProducts)  {
		put("grouped_products", groupedProducts);
		return this;
	}

	/**
	 * List of grouped products ID.
	 *
	 * @param menuOrder List of grouped products ID.
	 * @return itself
	 */
	public UpdateProductRequest setMenuOrder(int menuOrder)  {
		put("menu_order", menuOrder);
		return this;
	}

	/**
	 * Meta data.
	 *
	 * @param metadata Meta data.
	 * @return itself
	 */
	public UpdateProductRequest setMetaData(Metadata... metadata)  {
		put("meta_data", JMap.pack(metadata));
		return this;
	}

	@Override
	protected Product convert(JsonNode node) {
		return new Product(node);
	}

}
