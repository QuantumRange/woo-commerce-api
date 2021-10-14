package de.quantumrange.woocommerce.testing;

import com.fasterxml.jackson.databind.JsonNode;
import de.quantumrange.woocommerce.oauth.OAuthConfig;
import de.quantumrange.woocommerce.route.APIVersion;
import de.quantumrange.woocommerce.route.Routes;

import java.util.HashMap;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {
		OAuthConfig config = new OAuthConfig("https://schubkarren-kiel.de/",
				"ck_6871146a8c133280e46b43d38f5d4734789d83b8",
				"cs_8c53b67f9b4a7aedcb1871ddce83ec77fe785101");

		JsonNode call = Routes.Products.LIST.compile(config, new HashMap<>()).call();

		System.out.println(call);


	}

}
