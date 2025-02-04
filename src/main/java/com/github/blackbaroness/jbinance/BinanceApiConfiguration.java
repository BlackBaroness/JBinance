package com.github.blackbaroness.jbinance;

/**
 * Configuration used for Binance operations.
 */
public class BinanceApiConfiguration {

    /**
     * Spot Test Network URL.
     */
    private static final String TESTNET_DOMAIN = "testnet.binance.vision";
    /**
     * Binance Spot Test Network option:
     * true if endpoint is spot test network URL; false if endpoint is production spot API URL.
     */
    public static boolean useTestnet;
    /**
     * Binance Spot Test Network option:
     * true for websocket streaming; false for no streaming.
     */
    public static boolean useTestnetStreaming;
    /**
     * Base domain for URLs.
     */
    private static String BASE_DOMAIN = "binance.com";

    /**
     * Get the URL base domain name (e.g., binance.com).
     *
     * @return The base domain for URLs
     */
    public static String getBaseDomain() {
        return BASE_DOMAIN;
    }

    /**
     * Set the URL base domain name (e.g., binance.com).
     *
     * @param baseDomain Base domain name
     */
    public static void setBaseDomain(final String baseDomain) {
        BASE_DOMAIN = baseDomain;
    }

    /**
     * REST API base URL.
     */
    public static String getApiBaseUrl() {
        return String.format("https://api.%s", getBaseDomain());
    }

    /**
     * Streaming API base URL.
     */
    public static String getStreamApiBaseUrl() {
        return String.format("wss://stream.%s:9443/ws", getBaseDomain());
    }

    /**
     * Asset info base URL.
     */
    public static String getAssetInfoApiBaseUrl() {
        return String.format("https://%s/", getBaseDomain());
    }

    /**
     * Spot Test Network API base URL.
     */
    public static String getTestNetBaseUrl() {
        return String.format("https://%s", TESTNET_DOMAIN);
    }

    /**
     * Streaming Spot Test Network base URL.
     */
    public static String getStreamTestNetBaseUrl() {
        return String.format("wss://%s/ws", TESTNET_DOMAIN);
    }
}
