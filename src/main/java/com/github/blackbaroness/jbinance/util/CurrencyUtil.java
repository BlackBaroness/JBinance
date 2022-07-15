package com.github.blackbaroness.jbinance.util;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@UtilityClass
public class CurrencyUtil {

    public final String BTC_TICKER = "BTC";
    public final List<String> FIAT_CURRENCIES = List.of(
            "USDT", "BUSD", "PAX", "TUSD", "USDC", "NGN", "RUB", "USDS", "TRY"
    );

    @Contract(pure = true)
    public boolean isFiat(@NotNull String symbol) {
        return FIAT_CURRENCIES.contains(symbol);
    }
}
