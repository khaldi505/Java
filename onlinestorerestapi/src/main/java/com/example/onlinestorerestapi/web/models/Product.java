package com.example.onlinestorerestapi.web.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    private int id;
    private String code;
    private String name;
    private double price;
    private int quantity;
    private String image;    

}