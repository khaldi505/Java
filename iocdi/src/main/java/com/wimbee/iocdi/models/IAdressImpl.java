package com.wimbee.iocdi.models;

public class IAdressImpl implements Iadress {


    private int number;
    private String street;
    private String district;

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "IAdressImpl [number=" + number + ", street=" + street + ", district=" + district + "]";
    }


    
}
