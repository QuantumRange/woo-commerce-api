package de.quantumrange.woocommerce.route;

import de.quantumrange.woocommerce.util.HttpRequestType;

public record Route(String url, HttpRequestType type) {

}
