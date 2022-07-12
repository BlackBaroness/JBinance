package com.github.blackbaroness.jbinance.client.staking.request;

import com.github.blackbaroness.jbinance.client.BinanceApiServiceGenerator;
import com.github.blackbaroness.jbinance.client.staking.StakingBinanceService;
import com.github.blackbaroness.jbinance.client.staking.data.StakingProduct;
import com.github.blackbaroness.jbinance.client.staking.data.StakingProductType;
import com.github.blackbaroness.jbinance.util.BinanceApiConstants;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.index.qual.Positive;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.util.List;

@RequiredArgsConstructor
public class GetStakingProductsBuilder {

    private final StakingBinanceService stakingBinanceService;
    private final StakingProductType productType;

    private String asset = null;
    private long page = 1;
    private long size = 10;
    private long recvWindow = BinanceApiConstants.DEFAULT_RECEIVING_WINDOW;

    @Contract(value = "_ -> this", pure = true)
    public @NotNull GetStakingProductsBuilder asset(@NotNull String asset) {
        this.asset = asset;
        return this;
    }

    @Contract(value = "_ -> this", pure = true)
    public @NotNull GetStakingProductsBuilder page(@Positive long page) {
        this.page = page;
        return this;
    }

    @Contract(value = "_ -> this", pure = true)
    public @NotNull GetStakingProductsBuilder size(@Range(from = 10, to = 100) long size) {
        this.size = size;
        return this;
    }

    @Contract(value = "_ -> this", pure = true)
    public @NotNull GetStakingProductsBuilder recvWindow(@Positive long recvWindow) {
        this.recvWindow = recvWindow;
        return this;
    }

    @Contract(value = "-> new", pure = true)
    public @NotNull List<StakingProduct> request() {
        return BinanceApiServiceGenerator.executeSync(stakingBinanceService.getStakingProducts(
                productType,
                asset,
                page,
                size,
                recvWindow,
                System.currentTimeMillis()
        ));
    }
}
