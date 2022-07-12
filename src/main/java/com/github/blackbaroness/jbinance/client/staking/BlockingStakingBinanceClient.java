package com.github.blackbaroness.jbinance.client.staking;

import com.github.blackbaroness.jbinance.client.BinanceApiServiceGenerator;
import com.github.blackbaroness.jbinance.client.staking.data.StakingProduct;
import com.github.blackbaroness.jbinance.client.staking.data.StakingProductType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

import java.util.List;

public class BlockingStakingBinanceClient {

    private final StakingBinanceService stakingBinanceService;

    public BlockingStakingBinanceClient(String apiKey, String secret) {
        stakingBinanceService = BinanceApiServiceGenerator.createService(StakingBinanceService.class, apiKey, secret);
    }

    @Contract(value = "_ -> new", pure = true)
    public @NotNull List<StakingProduct> getProducts(@NotNull StakingProductType productType) {
        return execute(stakingBinanceService.getStakingProducts(productType, System.currentTimeMillis()));
    }

    @Contract(pure = true)
    private <T> T execute(@NotNull Call<T> call) {
        return BinanceApiServiceGenerator.executeSync(call);
    }
}
