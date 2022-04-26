package com.myfin.base;

import java.util.stream.Stream;

public interface ValueEnum <T>{
    /**
     * <p>
     * get enum from value
     * </p>
     *
     * @param enumType enum type
     * @param value    enum value
     * @param <V>      value type
     * @param <E>      enum fan type
     * @return response enum
     */
    static <V, E extends ValueEnum<V>> E valueToEnum(Class<E> enumType, V value) {
        return Stream.of(enumType.getEnumConstants())
                .filter(item -> item.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown database value: " + value));
    }

    /**
     * Gets enum value.
     *
     * @return enum value
     */
    T getValue();
}