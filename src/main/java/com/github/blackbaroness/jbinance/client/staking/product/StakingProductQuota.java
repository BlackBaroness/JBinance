package com.github.blackbaroness.jbinance.client.staking.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@ToString
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StakingProductQuota {

    @JsonProperty("totalPersonalQuota")
    String totalPersonalQuota;

    @JsonProperty("minimum")
    String minimumOrder;
}
