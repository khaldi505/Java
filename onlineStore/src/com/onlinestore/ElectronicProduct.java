package com.onlinestore;


public class ElectronicProduct extends Product {
    
    
    private double power;


    public ElectronicProduct(String name, double price, String reference, double power) {
        super(name, price, reference);
        this.power = power;
    }

    /**
     * @return double return the power
     */
    public double getPower() {
        return power;
    }

    /**
     * @param power the power to set
     */
    public void setPower(double power) {
        this.power = power;
    }

    
    @Override
    public
    String getDescription() {
        String productName = getName();
        double price =  getPrice();
        String ref = getReference();
        return (String.format("Electronic Product: %s, Price: %.1f, Refrence: %s, Power: %.1f", productName, price, ref, this.power));
    }



}