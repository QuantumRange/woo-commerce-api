# WooCommerce API (In Progress)
This WooCommerce REST API Implementation is only for the V3.
All should have this version, because all other versions are no longer supported by WooCommerce.

## Usage
### OAuth

#### Config
```java
// https://woocommerce.com is an example for a host.

// With automatic newest supported version.
OAuthConfig config1 = new OAuthConfig("https://woocommerce.com", "ck_...", "ck_...");

// Without automatic newest supported version.
OAuthConfig config2 = new OAuthConfig("https://woocommerce.com", "ck_...", "ck_...", APIVersion.V3);
```

#### API