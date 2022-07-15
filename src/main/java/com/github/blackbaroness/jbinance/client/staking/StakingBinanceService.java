package com.github.blackbaroness.jbinance.client.staking;

import com.github.blackbaroness.jbinance.client.staking.position.StakingPosition;
import com.github.blackbaroness.jbinance.client.staking.product.StakingProduct;
import com.github.blackbaroness.jbinance.client.staking.product.StakingProductType;
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
            @Query("asset") String asset,
            @Query("current") long page,
            @Query("size") long size,
            @Query("recvWindow") long recvWindow,
            @Query("timestamp") long timestamp
    );

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/staking/position")
    Call<List<StakingPosition>> getStakingPositions(
            @Query("product") StakingProductType productType,
            @Query("productId") String productId,
            @Query("asset") String asset,
            @Query("current") long page,
            @Query("size") long size,
            @Query("recvWindow") long recvWindow,
            @Query("timestamp") long timestamp
    );
}
