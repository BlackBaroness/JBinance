package com.github.blackbaroness.jbinance.client.general;

import com.github.blackbaroness.jbinance.BinanceApiConfiguration;
import com.github.blackbaroness.jbinance.client.BinanceApiServiceGenerator;
import com.github.blackbaroness.jbinance.client.general.data.Asset;
import com.github.blackbaroness.jbinance.client.general.data.ExchangeInfo;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

import java.util.List;

public class BlockingGeneralBinanceClient {

    private final GeneralBinanceService generalBinanceService;

    public BlockingGeneralBinanceClient(String apiKey, String secret) {
        generalBinanceService = BinanceApiServiceGenerator.createService(GeneralBinanceService.class, apiKey, secret);
    }

    public void ping() {
        execute(generalBinanceService.ping());
    }

    public long getServerTime() {
        return execute(generalBinanceService.getServerTime()).getServerTime();
    }

    public ExchangeInfo getExchangeInfo() {
        return execute(generalBinanceService.getExchangeInfo());
    }

    public List<Asset> getAllAssets() {
        return execute(generalBinanceService.getAllAssets(
                BinanceApiConfiguration.getAssetInfoApiBaseUrl() + "assetWithdraw/getAllAsset.html")
        );
    }

    private <T> T execute(@NotNull Call<T> call) {
        return BinanceApiServiceGenerator.executeSync(call);
    }
}
