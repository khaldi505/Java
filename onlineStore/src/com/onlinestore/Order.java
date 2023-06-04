package com.onlinestore;

import java.util.ArrayList;

public class Order implements Cart {


    public ArrayList<Product> products;
    public Order() {
        products = new ArrayList<>();
    }

    @Override
    public void addProduct(Product product) {
        products.add(product); 
        }

    @Override
    public void removeProduct(Product product) {
        products.remove(product);
        String productType = product.getClass().getSimpleName().replaceAll("\\b(Product)", " $1");
    }

    @Override
    public double total() {
        double totalAmount = 0;
        for (Product product : products) {
            totalAmount += product.getPrice();
        }
        return totalAmount;
    }
}