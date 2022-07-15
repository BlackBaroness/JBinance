package com.github.blackbaroness.jbinance.client.general.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum RateLimitType {
    REQUEST_WEIGHT,
    ORDERS,
    RAW_REQUESTS
}
