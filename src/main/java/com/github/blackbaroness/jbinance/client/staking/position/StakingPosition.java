package com.github.blackbaroness.jbinance.client.staking.position;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.blackbaroness.jbinance.client.staking.common.WrappedAmount;
import com.github.blackbaroness.jbinance.client.staking.common.WrappedApy;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@ToString
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StakingPosition {

    @JsonProperty("positionId")
    String positionId;

    @JsonProperty("projectId")
    String productId;

    @JsonProperty("asset")
    String asset;

    @JsonProperty("amount")
    WrappedAmount lockedAmount;

    @JsonProperty("purchaseTime")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    Date subscriptionDate;

    @JsonProperty("duration")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    int lockPeriod;

    @JsonProperty("accrualDays")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    int accruePeriod;

    @JsonProperty("rewardAsset")
    String rewardAsset;

    @JsonProperty("APY")
    WrappedApy apy;

    @JsonProperty("rewardAmt")
    WrappedAmount earnedAmount;

    @JsonProperty("extraRewardAsset")
    String extraRewardAsset;

    @JsonProperty("extraRewardAPY")
    WrappedApy extraRewardApy;

    @JsonProperty("estExtraRewardAmt")
    WrappedAmount extraRewardsAmount;

    @JsonProperty("nextInterestPay")
    WrappedAmount nextInterestPayment;

    @JsonProperty("nextInterestPayDate")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    Date nextInterestPaymentDate;

    @JsonProperty("payInterestPeriod")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    int payInterestPeriod;

    @JsonProperty("redeemAmountEarly")
    WrappedAmount earlyRedemptionAmount;

    @JsonProperty("interestEndDate")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    Date interestEndDate;

    @JsonProperty("deliverDate")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    Date deliverDate;

    @JsonProperty("redeemPeriod")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    int redeemPeriod;

    @JsonProperty("redeemingAmt")
    WrappedAmount redemptionAmount;

    @JsonProperty("partialAmtDeliverDate")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    Date partialAmountDeliverDate;

    @JsonProperty("canRedeemEarly")
    boolean canRedeemEarly;

    @JsonProperty("renewable")
    boolean renewable;

    @JsonProperty("type")
    StakingPositionType type;

    @JsonProperty("status")
    String status;
}
