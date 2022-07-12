package com.github.blackbaroness.jbinance.client.general.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RateLimit {

    RateLimitType rateLimitType;
    RateLimitInterval interval;
    int limit;
}
