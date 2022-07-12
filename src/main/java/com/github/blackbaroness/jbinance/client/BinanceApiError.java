package com.github.blackbaroness.jbinance.client;

import lombok.Data;

@Data
public class BinanceApiError {

    private int code;
    private String message;
}
