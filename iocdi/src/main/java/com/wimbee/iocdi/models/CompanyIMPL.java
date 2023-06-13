package com.wimbee.iocdi.models;

public class CompanyIMPL implements Icompany {

    private String name;
    private String adress;



    // empty constructure
    public CompanyIMPL() {
    }


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAddress(String address) {
        this.adress = address;
    }


    
}