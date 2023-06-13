package com.example.onlinestorerestapi.web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinestorerestapi.web.models.Product;
import com.example.onlinestorerestapi.web.requests.ProductForm;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/products")
public class productController {
    private static List<Product> products = new ArrayList<Product>();
    private static int idCount = 0;

    static {
        products.add(new Product(idCount++, "z", "product name", 19, 1, null));
        products.add(new Product(idCount++, "a", "product name", 3, 1, null));
        products.add(new Product(idCount++, "d", "product name", 5, 1, null));
        products.add(new Product(idCount++, "ff", "product name", 1, 1, null));
        products.add(new Product(idCount++, "ee", "product name", 2, 1, null));

    }



    @GetMapping
    public ResponseEntity<Object> getProducts() {
        return new ResponseEntity<Object>(products, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Object> addProduct(@RequestBody ProductForm productForm) {
        Product product = new Product(idCount++,productForm.getCode(), productForm.getName(), productForm.getPrice(), productForm.getQuantity(), productForm.getImage());
        products.add(product);
        return new ResponseEntity<Object>(products, HttpStatus.CREATED);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") int id){        
        for (Product product: products){
            if (product.getId() == id){
                return new ResponseEntity<Object>(products.get(id), HttpStatus.FOUND); 
            }
        }
        return new ResponseEntity<Object>("product not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("code/{code}")
    public ResponseEntity<Object> getProductByCode(@PathVariable("code") String code){
        for (Product product: products){
            if (product.getCode().equals(code)){
                return new ResponseEntity<Object>(product, HttpStatus.FOUND); 
            }
        }
        return new ResponseEntity<Object>("product not found", HttpStatus.NOT_FOUND);
    }


    @GetMapping(value="/sorted")
    public ResponseEntity<Object> getSorted() {


        List<Product> copyList = new ArrayList<>(products);
        Collections.sort(copyList, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });

        return new ResponseEntity<Object>(copyList, HttpStatus.OK);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable int id, @RequestBody ProductForm productForm) {
        //TODO: process PUT request
        Product product = products.get(id);
        product.setPrice(productForm.getPrice());
        return new ResponseEntity<Object>("Product Updated succusfully", HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable int id) {
        Product product = products.get(id);
        products.remove(product);
        return new ResponseEntity<Object>("Product deleted succusfully", HttpStatus.OK);
    }
    


}