package com.onlinestore;

public class BookProduct extends Product{

    private String author;


    public BookProduct(String name, double price, String reference, String author) {
        super(name, price, reference);
        this.author = author;
    }

    @Override
    public
    String getDescription() {
        String productName = getName();
        double price =  getPrice();
        String ref = getReference();
        return (String.format("Book Product: %s, Price: %.1f, Reference: %s, Book author: %s", productName, price, ref, this.author));
      }

    /**
     * @return String return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

}