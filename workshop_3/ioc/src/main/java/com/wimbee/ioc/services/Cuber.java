package com.wimbee.ioc.services;

import org.springframework.stereotype.Component;


@Component
public class Cuber {
    long value;
    public Cuber(long value) {
        this.value = value;
    }

    public long computeCube() {
        return value * value * value;
    }
}