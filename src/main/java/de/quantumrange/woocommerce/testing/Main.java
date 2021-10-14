package de.quantumrange.woocommerce.testing;

import com.fasterxml.jackson.databind.JsonNode;
import de.quantumrange.woocommerce.oauth.OAuthConfig;
import de.quantumrange.woocommerce.route.APIVersion;
import de.quantumrange.woocommerce.route.Routes;
import de.quantumrange.woocommerce.util.WooImage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {
		OAuthConfig config = new OAuthConfig("https://schubkarren-kiel.de/",
				"ck_6871146a8c133280e46b43d38f5d4734789d83b8",
				"cs_8c53b67f9b4a7aedcb1871ddce83ec77fe785101");

		Map<String, Object> maps = new HashMap<>();

		maps.put("name", "Ich bin ein Name");
		maps.put("type", "variable");
		maps.put("status", "publish");
		maps.put("featured", "true");
		maps.put("description", "Test");
		maps.put("sku", "108");
		maps.put("regular_price", "50");
		maps.put("images", new Object[] {
				WooImage.getImage("https://cdn.discordapp.com/attachments/611950474513612830/898102572307607582" +
						"/Screen_Shot_2021-10-14_at_08.png", "Test", "Irgendein Bild")
		});

		JsonNode call = Routes.Products.CREATE.compile(config, maps).call();

		System.out.println(call);
	}

}
