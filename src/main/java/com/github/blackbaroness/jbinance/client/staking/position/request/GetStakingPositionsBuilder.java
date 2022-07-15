package com.github.blackbaroness.jbinance.client.staking.position.request;

import com.github.blackbaroness.jbinance.client.BinanceApiServiceGenerator;
import com.github.blackbaroness.jbinance.client.staking.StakingBinanceService;
import com.github.blackbaroness.jbinance.client.staking.position.StakingPosition;
import com.github.blackbaroness.jbinance.client.staking.product.StakingProductType;
import com.github.blackbaroness.jbinance.util.BinanceApiConstants;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.index.qual.Positive;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.util.List;

@RequiredArgsConstructor
public class GetStakingPositionsBuilder {

    private final StakingBinanceService stakingBinanceService;
    private final StakingProductType productType;

    private String productId = null;
    private String asset = null;
    private long page = 1;
    private long size = 10;
    private long recvWindow = BinanceApiConstants.DEFAULT_RECEIVING_WINDOW;

    @Contract(value = "_ -> this", pure = true)
    public @NotNull GetStakingPositionsBuilder productId(@NotNull String productId) {
        this.productId = productId;
        return this;
    }

    @Contract(value = "_ -> this", pure = true)
    public @NotNull GetStakingPositionsBuilder asset(@NotNull String asset) {
        this.asset = asset;
        return this;
    }

    @Contract(value = "_ -> this", pure = true)
    public @NotNull GetStakingPositionsBuilder page(@Positive long page) {
        this.page = page;
        return this;
    }

    @Contract(value = "_ -> this", pure = true)
    public @NotNull GetStakingPositionsBuilder size(@Range(from = 10, to = 100) long size) {
        this.size = size;
        return this;
    }

    @Contract(value = "_ -> this", pure = true)
    public @NotNull GetStakingPositionsBuilder recvWindow(@Positive long recvWindow) {
        this.recvWindow = recvWindow;
        return this;
    }

    @Contract(value = "-> new", pure = true)
    public @NotNull List<StakingPosition> request() {
        return BinanceApiServiceGenerator.executeSync(stakingBinanceService.getStakingPositions(
                productType,
                productId,
                asset,
                page,
                size,
                recvWindow,
                System.currentTimeMillis()
        ));
    }
}
