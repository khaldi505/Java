package com.wimbee.ioc.services;

import org.springframework.stereotype.Component;

@Component
public class Squarer {
    public long computeSquare(long value) {
    return value*value;
    }
    }
