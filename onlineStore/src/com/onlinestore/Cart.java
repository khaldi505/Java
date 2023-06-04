package com.onlinestore;


public interface Cart {

    public void addProduct(Product product);
    public void removeProduct(Product product);
    public double total();
}