package com.wimbee.ioc.services;
import org.springframework.stereotype.Component;

@Component
public class Doubler {
    public long computeDouble(long value) {
    return value*2;
    }
    }