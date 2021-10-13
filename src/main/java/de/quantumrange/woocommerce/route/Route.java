package de.quantumrange.woocommerce.route;

import de.quantumrange.woocommerce.util.HTTPRequestType;

public record Route(String url, HTTPRequestType type) {

}
