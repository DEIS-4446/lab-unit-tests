package com.shoppingCartApp;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CartOperations {
    private final ShoppingCart shoppingCart;

    public CartOperations(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /**
     * Calculates the average price of products in the cart
     * @return average price or 0 if the cart is empty
     */
    public double calculateAveragePrice() {
        List<Product> products = shoppingCart.getProducts();
        if (products.isEmpty()) {
            return 0;
        }
        return shoppingCart.getTotalPrice() / products.size();
    }

    /**
     * Finds the most expensive product in the cart
     * @return the most expensive product or null if the cart is empty
     */
    public Product findMostExpensiveProduct() {
        return shoppingCart.getProducts().stream()
                .max((p1, p2) -> Double.compare(p1.price(), p2.price()))
                .orElse(null);
    }

    /**
     * Groups products by category and counts how many are in each category
     * @return map with categories and product counts
     */
    public Map<String, Long> countProductsByCategory() {
        return shoppingCart.getProducts().stream()
                .collect(Collectors.groupingBy(
                        Product::category,
                        Collectors.counting()));
    }

    /**
     * Calculates the total discount applying a percentage
     * @param discountPercentage value between 0 and 100
     * @return discount amount to apply
     */
    public double calculateTotalDiscount(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Percentage must be between 0 and 100");
        }
        return shoppingCart.getTotalPrice() * (discountPercentage / 100);
    }
}