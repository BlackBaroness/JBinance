package com.github.blackbaroness.jbinance.client.staking.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum StakingProductType {
    STAKING,
    F_DEFI,
    L_DEFI
}
