package com.github.blackbaroness.jbinance.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class StringUtil {

    @Contract(value = "_ -> new", pure = true)
    public @NotNull String toPrettyString(@NotNull Object obj) {
        return ToStringBuilder.reflectionToString(obj, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
