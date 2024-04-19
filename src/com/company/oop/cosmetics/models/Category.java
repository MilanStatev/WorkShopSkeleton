package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.ArrayList;

public class Category {
    private static final int NAME_MIN_LENGTH = 2;
    private static final int NAME_MAX_LENGTH = 15;
    private static final String INVALID_NAME_INPUT = String.format("Name should be between %d and %d symbols.",NAME_MIN_LENGTH,NAME_MAX_LENGTH);
    private static final String NO_SUCH_PRODUCT_FOUND = "Product not found in category";

    private String name;
    private final ArrayList<Product> products;


    public Category(String name) {
        setName(name);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        ValidationHelpers.validateStringLength(name,NAME_MIN_LENGTH,NAME_MAX_LENGTH,INVALID_NAME_INPUT);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        boolean isRemoved = products.remove(product);

        if (!isRemoved){
            throw new IllegalArgumentException(NO_SUCH_PRODUCT_FOUND);
        }
    }
    
    public String print() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("#Category: %s",getName())).append(System.lineSeparator());
        if (products.size() == 0) {
            sb.append(" #No product in this category");
        } else {
            products.forEach(product -> sb.append(product.print()));
        }

        return sb.toString().trim();
    }
    
}
