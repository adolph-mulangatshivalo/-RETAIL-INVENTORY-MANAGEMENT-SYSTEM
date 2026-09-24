package com.mycompany.com2224algorithmsanddatastructuresassingment1;

public class Product {
    private String productId;
    private String name;
    private String category;
    private double price;
    private int stockQuantity;

    public Product(String productId, String name, String category, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return String.format("%-10.10s | %-20.20s | %-15.15s | R%-10.2f | %-5d", 
                productId, name, category, price, stockQuantity);
    }
}
