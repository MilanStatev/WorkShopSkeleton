package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.Objects;

public class Product {

    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 10;
    private static final int BRAND_MIN_LENGTH = 2;
    private static final int BRAND_MAX_LENGTH = 10;
    private static final String INVALID_NAME = String.format("Name should be between %d and %d symbols.",NAME_MIN_LENGTH,NAME_MAX_LENGTH);
    private static final String INVALID_BRAND = String.format("Brand should be between %d and %d symbols.",BRAND_MIN_LENGTH,BRAND_MAX_LENGTH);
    private static final String INVALID_PRICE = "Price should be non negative.";


    // "Each product in the system has name, brand, price and gender."

    private String name;
    private String brand;
    private double price;
    private GenderType gender;

    public Product(String name, String brand, double price, GenderType gender) {
        // finish the constructor and validate data
        setName(name);
        setBrand(brand);
        setPrice(price);
        setGender(gender);
    }

    private void setName(String name) {
        ValidationHelpers.validateStringLength(name,NAME_MIN_LENGTH,NAME_MAX_LENGTH, INVALID_NAME);

        this.name = name;
    }

    private void setBrand(String brand) {
        ValidationHelpers.validateStringLength(brand,BRAND_MIN_LENGTH,BRAND_MAX_LENGTH, INVALID_BRAND);

        this.brand = brand;
    }

    private void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }

        this.price = price;
    }

    private void setGender(GenderType gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public GenderType getGender() {
        return gender;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(" #%s %s", getName(), getBrand())).append(System.lineSeparator());
        sb.append(String.format(" #Price: %.2f", getPrice())).append(System.lineSeparator());
        sb.append(String.format(" #Gender: %s", getGender())).append(System.lineSeparator());
        sb.append(" ===");

        return sb.toString();
    }

    @Override
    public boolean equals(Object p) {
        if (this == p) return true;
        if (p == null || getClass() != p.getClass()) return false;
        Product product = (Product) p;
        return Double.compare(this.getPrice(), product.getPrice()) == 0 &&
                Objects.equals(this.getName(), product.getName()) &&
                Objects.equals(this.getBrand(), product.getBrand()) &&
                this.getGender() == product.getGender();
    }
    
}
