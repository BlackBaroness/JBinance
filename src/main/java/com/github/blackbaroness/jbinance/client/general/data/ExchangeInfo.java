package com.github.blackbaroness.jbinance.client.general.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.blackbaroness.jbinance.exception.BinanceApiException;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;


/**
 * Current exchange trading rules and symbol information.
 * <a href="https://github.com/binance-exchange/binance-official-api-docs/blob/master/rest-api.md">...</a>
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeInfo {

    String timezone;
    Long serverTime;
    List<RateLimit> rateLimits;
    List<SymbolInfo> symbols;

    /**
     * @param symbol the symbol to obtain information for (e.g. ETHBTC)
     * @return symbol exchange information
     */
    public SymbolInfo getSymbolInfo(String symbol) {
        return symbols.stream()
                .filter(symbolInfo -> symbolInfo.getSymbol().equals(symbol))
                .findFirst()
                .orElseThrow(() -> new BinanceApiException("Unable to obtain information for symbol " + symbol));
    }
}
