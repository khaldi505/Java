package com.example.onlinestorerestapi.web.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductForm {
    private int id;
    private String code;
    private String name;
    private double price;
    private int quantity;
    private String image;  
}