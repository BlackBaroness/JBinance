package com.github.blackbaroness.jbinance.wrapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public abstract class DoubleWrapperSerializer<T> extends StdDeserializer<T> {

    protected DoubleWrapperSerializer(Class<T> vc) {
        super(vc);
    }

    @Override
    public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return createObject(Double.parseDouble(String.valueOf(p.getValueAsDouble(Double.NaN))));
    }

    @Contract(value = "_ -> new", pure = true)
    protected abstract @NotNull T createObject(double value);
}
