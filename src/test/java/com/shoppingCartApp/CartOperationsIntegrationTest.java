package com.shoppingCartApp;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.*;

public class CartOperationsIntegrationTest {

    private ShoppingCart shoppingCart;
    private CartOperations cartOperations;

    @Before
    public void setUp() {
        // Use actual implementation instead of mock
        shoppingCart = new ShoppingCart();
        cartOperations = new CartOperations(shoppingCart);
    }

    @Test
    public void calculateAveragePrice_emptyCart_returnsZero() {
        // Act with empty cart
        double result = cartOperations.calculateAveragePrice();

        // Assert
        assertEquals("Average price of an empty cart should be 0", 0.0, result, 0.001);
    }

    @Test
    public void calculateAveragePrice_withProducts_returnsCorrectAverage() {
        // Arrange with real products
        shoppingCart.addProduct(new Product("Product 1", 10.0, "Category 1"));
        shoppingCart.addProduct(new Product("Product 2", 20.0, "Category 2"));

        // Act
        double result = cartOperations.calculateAveragePrice();

        // Assert
        assertEquals("Average price should be 15.0", 15.0, result, 0.001);
    }

    @Test
    public void findMostExpensiveProduct_emptyCart_returnsNull() {
        // Act
        Product result = cartOperations.findMostExpensiveProduct();

        // Assert
        assertNull("Most expensive product in an empty cart should be null", result);
    }

    @Test
    public void findMostExpensiveProduct_withProducts_returnsMostExpensive() {
        // Arrange
        Product product1 = new Product("Product 1", 10.0, "Category 1");
        Product product2 = new Product("Product 2", 30.0, "Category 2");
        Product product3 = new Product("Product 3", 20.0, "Category 1");

        shoppingCart.addProduct(product1);
        shoppingCart.addProduct(product2);
        shoppingCart.addProduct(product3);

        // Act
        Product result = cartOperations.findMostExpensiveProduct();

        // Assert
        assertEquals("Most expensive product should be Product 2", product2, result);
    }

    @Test
    public void countProductsByCategory_emptyCart_returnsEmptyMap() {
        // Act
        Map<String, Long> result = cartOperations.countProductsByCategory();

        // Assert
        assertTrue("Product count map for empty cart should be empty", result.isEmpty());
    }

    @Test
    public void countProductsByCategory_withProducts_returnsCorrectCounts() {
        // Arrange
        shoppingCart.addProduct(new Product("Product 1", 10.0, "Category 1"));
        shoppingCart.addProduct(new Product("Product 2", 20.0, "Category 2"));
        shoppingCart.addProduct(new Product("Product 3", 30.0, "Category 1"));

        // Act
        Map<String, Long> result = cartOperations.countProductsByCategory();

        // Assert
        assertEquals("Map should contain 2 categories", 2, result.size());
        assertEquals("Category 1 should contain 2 products", Long.valueOf(2), result.get("Category 1"));
        assertEquals("Category 2 should contain 1 product", Long.valueOf(1), result.get("Category 2"));
    }

    @Test
    public void calculateTotalDiscount_validPercentage_returnsCorrectDiscount() {
        // Arrange
        shoppingCart.addProduct(new Product("Product 1", 80.0, "Category 1"));
        shoppingCart.addProduct(new Product("Product 2", 20.0, "Category 2"));

        // Act
        double result = cartOperations.calculateTotalDiscount(20);

        // Assert
        assertEquals("20% discount on $100 should be $20", 20.0, result, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateTotalDiscount_negativePercentage_throwsException() {
        // Act - should throw exception
        cartOperations.calculateTotalDiscount(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateTotalDiscount_percentageOver100_throwsException() {
        // Act - should throw exception
        cartOperations.calculateTotalDiscount(110);
    }
}