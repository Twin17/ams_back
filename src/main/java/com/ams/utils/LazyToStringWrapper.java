package com.ams.utils;

import java.util.function.Supplier;

public class LazyToStringWrapper {

    private final Supplier<String> lazyFunction;

    public LazyToStringWrapper(Supplier<String> lazyFunction) {
        this.lazyFunction = lazyFunction;
    }

    @Override
    public String toString() {
        return lazyFunction.get();
    }
}
