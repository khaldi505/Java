package com.wimbee.ioc;

public class MyRunner{
    public static void main(String[] args) {
    new ComputerProcessor()
    .addComputer(new Doubler())
    .addComputer(new Squarer())
    .computeAll(8);
    }
    }
