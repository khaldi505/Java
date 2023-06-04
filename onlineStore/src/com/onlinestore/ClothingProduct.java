package com.onlinestore;

public class ClothingProduct extends Product {



    private String size;

    public ClothingProduct(String name, double price, String reference, String size) {
        super(name, price, reference);
        this.size = size;
    }

    
    @Override
    public String getDescription() {
        String productName = getName();
        double price =  getPrice();
        String ref = getReference();
        return (String.format("Clothing product: %s, Price: %.1f, Refrence: %s, Size: %s", productName, price, ref, this.size));
    }


    
    
}