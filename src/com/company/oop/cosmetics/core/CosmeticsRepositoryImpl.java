package com.company.oop.cosmetics.core;

import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.Category;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.Product;
import com.company.oop.cosmetics.models.ShoppingCart;

import java.util.ArrayList;

public class CosmeticsRepositoryImpl implements CosmeticsRepository {
    private static final String NO_VALID_PRODUCT = "Product %s does not exist!";
    private static final String NO_VALID_CATEGORY = "Category %s does not exist!";

    private final ArrayList<Product> products;
    private final ArrayList<Category> categories;
    private final ShoppingCart shoppingCart;

    public CosmeticsRepositoryImpl() {
        products = new ArrayList<>();
        categories = new ArrayList<>();
        shoppingCart = new ShoppingCart();
    }

    @Override
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public ArrayList<Category> getCategories() {
        return new ArrayList<>(categories);
    }

    @Override
    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public Product findProductByName(String productName) {
        /**
         * Hint: You have to go through every product and see if one has name equal to productName.
         *       If not, "throw new IllegalArgumentException("Product %s does not exist!");"
         */

        if (productExist(productName)) {
            for (Product product : products) {
                if (productName.equals(product.getName())){
                    return product;
                }
            }
        }

        throw new IllegalArgumentException(String.format(NO_VALID_PRODUCT, productName));
    }

    @Override
    public Category findCategoryByName(String categoryName) {
        /**
         * Hint: You have to go through every category and see if one has name equal to categoryName.
         *       If not, "throw new IllegalArgumentException("Category %s does not exist!");"
         */
        if (categoryExist(categoryName)) {
            for (Category category : categories) {
                if (categoryName.equals(category.getName())){
                    return category;
                }
            }
        }

        throw new IllegalArgumentException(String.format(NO_VALID_CATEGORY, categoryName));
    }

    @Override
    public void createCategory(String categoryName) {
        categories.add(new Category(categoryName));
    }

    @Override
    public void createProduct(String name, String brand, double price, GenderType gender) {
        products.add(new Product(name,brand,price,gender));
    }

    @Override
    public boolean categoryExist(String categoryName) {
        /**
         * Hint: You have to go through every category and see if one has name equal to categoryName.
         *       If there is one, return true. If not, return false.
         */
        for (Category category : categories) {
            if (categoryName.equals(category.getName())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean productExist(String productName) {
        /**
         * Hint: You have to go through every product and see if one has name equal to productName.
         *       If there is one, return true. If not, return false.
         */
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }
}
