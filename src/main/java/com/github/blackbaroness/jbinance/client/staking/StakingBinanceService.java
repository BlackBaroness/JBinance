package com.github.blackbaroness.jbinance.client.staking;

import com.github.blackbaroness.jbinance.client.staking.data.StakingProduct;
import com.github.blackbaroness.jbinance.client.staking.data.StakingProductType;
import com.github.blackbaroness.jbinance.util.BinanceApiConstants;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import java.util.List;

public interface StakingBinanceService {

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/staking/productList")
    Call<List<StakingProduct>> getStakingProducts(
            @Query("product") StakingProductType productType,
            @Query("timestamp") Long timestamp
    );
}
