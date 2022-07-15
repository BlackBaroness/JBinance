package com.github.blackbaroness.jbinance.client.staking.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.blackbaroness.jbinance.wrapper.DoubleWrapper;
import com.github.blackbaroness.jbinance.wrapper.DoubleWrapperSerializer;
import org.jetbrains.annotations.NotNull;

@JsonDeserialize(using = WrappedApy.WrappedApyDeserializer.class)
public class WrappedApy extends DoubleWrapper {

    private WrappedApy(double value) {
        super(value);
    }

    @Override
    protected int defaultDecimalPlaces() {
        return 2;
    }

    public static class WrappedApyDeserializer extends DoubleWrapperSerializer<WrappedApy> {

        public WrappedApyDeserializer() {
            super(WrappedApy.class);
        }

        @Override
        protected @NotNull WrappedApy createObject(double value) {
            return new WrappedApy(value);
        }
    }
}
