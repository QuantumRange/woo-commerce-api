package de.quantumrange.woocommerce.route.builder.impl.variations;

import com.fasterxml.jackson.databind.JsonNode;
import de.quantumrange.woocommerce.models.*;
import de.quantumrange.woocommerce.oauth.OAuthConfig;
import de.quantumrange.woocommerce.route.Route;
import de.quantumrange.woocommerce.route.Routes;
import de.quantumrange.woocommerce.route.builder.PostRequestBuilder;
import de.quantumrange.woocommerce.route.builder.impl.products.CreateProductRequest;
import de.quantumrange.woocommerce.util.JMap;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateVariationRequest extends PostRequestBuilder<Variation> {

	public CreateVariationRequest(OAuthConfig config, int id) {
		super(config, Routes.Variations.CREATE, id);
	}

	/**
	 * Product name.
	 *
	 * @param name Product name.
	 * @return itself
	 */
	public CreateVariationRequest setName(String name)  {
		put("name",  name);
		return this;
	}

	/**
	 * Product description.
	 *
	 * @param description Product description.
	 * @return itself
	 */
	public CreateVariationRequest setDescription(String description)  {
		put("description", description);
		return this;
	}

	/**
	 * Unique identifier.
	 *
	 * @param sku Unique identifier.
	 * @return itself
	 */
	public CreateVariationRequest setSKU(String sku)  {
		put("sku",  null);
		return this;
	}

	/**
	 * Product regular price.
	 *
	 * @param regularPrice Product regular price.
	 * @return itself
	 */
	public CreateVariationRequest setRegularPrice(double regularPrice)  {
		put("regular_price", Double.toString(regularPrice));
		return this;
	}

	/**
	 * Product sale price.
	 *
	 * @param salePrice Product sale price.
	 * @return itself
	 */
	public CreateVariationRequest setSalePrice(double salePrice)  {
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
	public CreateVariationRequest setSale(LocalDateTime from, LocalDateTime to, double price) {
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
	public CreateVariationRequest setSaleDateFrom(LocalDateTime from)  {
		put("date_on_sale_from", from.format(DateTimeFormatter.ISO_DATE_TIME));
		return this;
	}
	/**
	 * End date of sale price, in the site's timezone.
	 *
	 * @param to End date of sale price, in the site's timezone.
	 * @return itself
	 */
	public CreateVariationRequest setSaleDateTo(LocalDateTime to)  {
		put("date_on_sale_to", to.format(DateTimeFormatter.ISO_DATE_TIME));
		return this;
	}

	/**
	 * If the product is virtual. Default is false.
	 *
	 * @param virtual If the product is virtual. Default is false.
	 * @return itself
	 */
	public CreateVariationRequest setVirtual(boolean virtual)  {
		put("virtual", Boolean.toString(virtual));
		return this;
	}

	/**
	 * If the product is downloadable. Default is false.
	 *
	 * @param downloadable If the product is downloadable. Default is false.
	 * @return itself
	 */
	public CreateVariationRequest setDownloadable(boolean downloadable)  {
		put("downloadable", Boolean.toString(downloadable));
		return this;
	}

	/**
	 * List of downloadable files.
	 *
	 * @param downloads List of downloadable files.
	 * @return itself
	 */
	public CreateVariationRequest setDownloads(Download... downloads)  {
		put("downloads", JMap.pack(downloads));
		return this;
	}

	/**
	 * Number of times downloadable files can be downloaded after purchase. Default is -1.
	 *
	 * @param downloadLimit Number of times downloadable files can be downloaded after purchase. Default is -1.
	 * @return itself
	 */
	public CreateVariationRequest setDownloadLimit(int downloadLimit)  {
		put("download_limit", downloadLimit);
		return this;
	}

	/**
	 * Number of days until access to downloadable files expires. Default is -1.
	 *
	 * @param downloadExpiry Number of days until access to downloadable files expires. Default is -1.
	 * @return itself
	 */
	public CreateVariationRequest setDownloadExpiry(int downloadExpiry)  {
		put("download_expiry", downloadExpiry);
		return this;
	}

	/**
	 * Tax status. Options: taxable, shipping and none. Default is taxable.
	 *
	 * @param taxStatus Tax status. Options: taxable, shipping and none. Default is taxable.
	 * @return itself
	 */
	public CreateVariationRequest setTaxStatus(TaxStatus taxStatus)  {
		put("tax_status", taxStatus.name().toLowerCase());
		return this;
	}

	/**
	 * Tax class.
	 *
	 * @param taxClass Tax class.
	 * @return itself
	 */
	public CreateVariationRequest setTaxClass(TaxClass taxClass)  {
		put("tax_class", taxClass);
		return this;
	}

	/**
	 * Stock management at product level. Default is false.
	 *
	 * @param manageStock Stock management at product level. Default is false.
	 * @return itself
	 */
	public CreateVariationRequest setManageStock(boolean manageStock)  {
		put("manage_stock", manageStock);
		return this;
	}

	/**
	 * Stock quantity.
	 *
	 * @param stockQuantity Stock quantity.
	 * @return itself
	 */
	public CreateVariationRequest setStockQuantity(int stockQuantity)  {
		put("stock_quantity", stockQuantity);
		return this;
	}

	/**
	 * Controls the stock status of the product. Options: instock, outofstock, onbackorder. Default is instock.
	 *
	 * @param status Controls the stock status of the product. Options: instock, outofstock, onbackorder. Default is instock.
	 * @return itself
	 */
	public CreateVariationRequest setStockStatus(StockStatus status)  {
		put("stock_status", status.name().toLowerCase().replace(" ", ""));
		return this;
	}

	/**
	 * If managing stock, this controls if backorders are allowed. Options: no, notify and yes. Default is no.
	 *
	 * @param status If managing stock, this controls if backorders are allowed. Options: no, notify and yes. Default is no.
	 * @return itself
	 */
	public CreateVariationRequest setBackOrders(BackorderStatus status)  {
		put("backorders", status.name().toLowerCase());
		return this;
	}

	/**
	 * Product weight.
	 *
	 * @param weight Product weight.
	 * @return itself
	 */
	public CreateVariationRequest setWeight(double weight)  {
		put("weight", weight);
		return this;
	}

	/**
	 * Product dimensions.
	 *
	 * @param dimension Product dimensions.
	 * @return itself
	 */
	public CreateVariationRequest setDimensions(Dimension dimension)  {
		put("dimensions", dimension.convert());
		return this;
	}

	/**
	 * List of images.
	 *
	 * @param images List of images.
	 * @return itself
	 */
	public CreateVariationRequest setImages(Image... images)  {
		put("images", JMap.pack(images));
		return this;
	}

	/**
	 * List of attributes.
	 *
	 * @param attributes List of attributes.
	 * @return itself
	 */
	public CreateVariationRequest setAttributes(Attribute... attributes)  {
		put("attributes", JMap.pack(attributes));
		return this;
	}

	/**
	 * List of grouped variations ID.
	 *
	 * @param menuOrder List of grouped variations ID.
	 * @return itself
	 */
	public CreateVariationRequest setMenuOrder(int menuOrder)  {
		put("menu_order", menuOrder);
		return this;
	}

	/**
	 * Meta data.
	 *
	 * @param metadata Meta data.
	 * @return itself
	 */
	public CreateVariationRequest setMetaData(Metadata... metadata)  {
		put("meta_data", JMap.pack(metadata));
		return this;
	}

	@Override
	protected Variation convert(JsonNode node) {
		return new Variation(node);
	}
}
