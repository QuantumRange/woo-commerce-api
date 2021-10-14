package de.quantumrange.woocommerce.models;

public enum TaxClass {

	STANDARD	(0.19, "standard"),
	REDUCED_RATE(0.07, "reduced-rate"),
	ZERO_RATE	(0.0 , "zero-rate");

	private final double tax;
	private final String key;

	TaxClass(double tax, String str) {
		this.tax = tax;
		this.key = str;
	}

	public double getTax() {
		return tax;
	}

	public String getKey() {
		return key;
	}
}
