package com.github.blackbaroness.jbinance.client.general.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.blackbaroness.jbinance.client.OrderType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SymbolInfo {

    String symbol;
    SymbolStatus status;
    String baseAsset;
    Integer baseAssetPrecision;
    String quoteAsset;
    Integer quotePrecision;
    List<OrderType> orderTypes;
    boolean icebergAllowed;
    boolean ocoAllowed;
    boolean quoteOrderQtyMarketAllowed;
    boolean isSpotTradingAllowed;
    boolean isMarginTradingAllowed;
    List<SymbolFilter> filters;
}
