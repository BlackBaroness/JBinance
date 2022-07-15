package com.github.blackbaroness.jbinance.client.staking;

import com.github.blackbaroness.jbinance.client.BinanceApiServiceGenerator;
import com.github.blackbaroness.jbinance.client.staking.data.StakingProduct;
import com.github.blackbaroness.jbinance.client.staking.data.StakingProductType;
import com.github.blackbaroness.jbinance.client.staking.request.GetStakingProductsBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class BlockingStakingBinanceClient {

    private final StakingBinanceService stakingBinanceService;

    public BlockingStakingBinanceClient(String apiKey, String secret) {
        stakingBinanceService = BinanceApiServiceGenerator.createService(StakingBinanceService.class, apiKey, secret);
    }

    @Contract(value = "_ -> new", pure = true)
    public @NotNull GetStakingProductsBuilder getProducts(@NotNull StakingProductType productType) {
        return new GetStakingProductsBuilder(stakingBinanceService, productType);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public @NotNull List<StakingProduct> getAllProducts(
            @NotNull StakingProductType productType,
            @NotNull Function<GetStakingProductsBuilder, GetStakingProductsBuilder> builderFunction
    ) {
        List<StakingProduct> result = new ArrayList<>(500);

        for (int page = 1; page < Integer.MAX_VALUE; page++) {
            List<StakingProduct> requestResult = builderFunction.apply(getProducts(productType))
                    .size(100)
                    .page(page)
                    .request();

            if (requestResult.isEmpty()) {
                break;
            }

            result.addAll(requestResult);
        }

        return result;
    }

    @Contract(value = "_ -> new", pure = true)
    public @NotNull List<StakingProduct> getAllProducts(@NotNull StakingProductType productType) {
        return getAllProducts(productType, builder -> builder);
    }

    @Contract(pure = true)
    private <T> T execute(@NotNull Call<T> call) {
        return BinanceApiServiceGenerator.executeSync(call);
    }
}
