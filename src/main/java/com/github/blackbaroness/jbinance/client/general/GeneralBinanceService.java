package com.github.blackbaroness.jbinance.client.general;

import com.github.blackbaroness.jbinance.client.general.data.Asset;
import com.github.blackbaroness.jbinance.client.general.data.ExchangeInfo;
import com.github.blackbaroness.jbinance.client.general.data.ServerTime;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

import java.util.List;

public interface GeneralBinanceService {

    @GET("/api/v1/ping")
    Call<Void> ping();

    @GET("/api/v1/time")
    Call<ServerTime> getServerTime();

    @GET("/api/v3/exchangeInfo")
    Call<ExchangeInfo> getExchangeInfo();

    @GET
    Call<List<Asset>> getAllAssets(@Url String url);
}
