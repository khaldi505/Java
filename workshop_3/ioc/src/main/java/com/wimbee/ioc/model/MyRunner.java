package com.wimbee.ioc.model;
import org.springframework.stereotype.Service;

import com.wimbee.ioc.services.Doubler;
import com.wimbee.ioc.services.Squarer;

@Service
public class MyRunner{

    public static void main(String[] args) {
    new ComputerProcessor()
    .addComputer(new Doubler())
    .addComputer(new Squarer())
    .computeAll(8);
    }
    }
