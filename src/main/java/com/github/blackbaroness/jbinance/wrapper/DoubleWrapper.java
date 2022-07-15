package com.github.blackbaroness.jbinance.wrapper;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;

import java.text.DecimalFormat;
import java.text.NumberFormat;

@RequiredArgsConstructor
public abstract class DoubleWrapper {

    protected final double value;

    @Contract(pure = true)
    public double getDoubleValue() {
        return value;
    }

    @Contract(pure = true)
    public String getRawStringValue() {
        return String.valueOf(value);
    }

    @Contract(pure = true)
    public String getStringValue(int decimalPlaces) {
        StringBuilder format = new StringBuilder("#0");
        if (decimalPlaces > 0) {
            format.append(".").append("0".repeat(decimalPlaces));
        }

        NumberFormat formatter = new DecimalFormat(format.toString());
        return formatter.format(value);
    }

    @Override
    public String toString() {
        return getStringValue(defaultDecimalPlaces());
    }

    @Contract(pure = true)
    protected abstract int defaultDecimalPlaces();
}
