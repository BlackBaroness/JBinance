package com.github.blackbaroness.jbinance.client.staking.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum StakingProductType {
    STAKING,
    F_DEFI,
    L_DEFI
}
