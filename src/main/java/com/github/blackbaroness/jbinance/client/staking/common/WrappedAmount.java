package com.github.blackbaroness.jbinance.client.staking.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.blackbaroness.jbinance.wrapper.DoubleWrapper;
import com.github.blackbaroness.jbinance.wrapper.DoubleWrapperSerializer;
import org.jetbrains.annotations.NotNull;

@JsonDeserialize(using = WrappedAmount.WrappedAmountDeserializer.class)
public class WrappedAmount extends DoubleWrapper {

    private WrappedAmount(double value) {
        super(value);
    }

    @Override
    protected int defaultDecimalPlaces() {
        return 8;
    }

    public static class WrappedAmountDeserializer extends DoubleWrapperSerializer<WrappedAmount> {

        public WrappedAmountDeserializer() {
            super(WrappedAmount.class);
        }

        @Override
        protected @NotNull WrappedAmount createObject(double value) {
            return new WrappedAmount(value);
        }
    }
}
