package com.github.blackbaroness.jbinance.client.general.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * An asset Binance supports.
 */
@ToString
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Asset {

    @JsonProperty("id")
    String id;

    @JsonProperty("assetCode")
    String assetCode;

    @JsonProperty("assetName")
    String assetName;

    @JsonProperty("unit")
    String unit;

    @JsonProperty("transactionFee")
    String transactionFee;

    @JsonProperty("commissionRate")
    String commissionRate;

    @JsonProperty("freeAuditWithdrawAmt")
    String freeAuditWithdrawAmount;

    @JsonProperty("freeUserChargeAmount")
    String freeUserChargeAmount;

    @JsonProperty("minProductWithdraw")
    String minProductWithdraw;

    @JsonProperty("withdrawIntegerMultiple")
    String withdrawIntegerMultiple;

    @JsonProperty("confirmTimes")
    long confirmTimes;

    @JsonProperty("enableWithdraw")
    boolean enableWithdraw;

    @JsonProperty("isLegalMoney")
    boolean isLegalMoney;
}
