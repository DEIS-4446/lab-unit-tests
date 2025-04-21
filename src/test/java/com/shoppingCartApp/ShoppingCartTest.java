package com.shoppingCartApp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @Before
    public void setUp() {
        cart = new ShoppingCart();
    }

    /* Test cases for adding products to the cart */
    @Test
    public void addProductWithValidData() {
        Product product = new Product("Test Product", 10.0, "Test Category");
        cart.addProduct(product);
        assertTrue("Product should be in the cart", cart.getProducts().contains(product));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addProductWithNullProduct() {
        cart.addProduct(null);
    }

    @Test
    public void addDuplicateProducts() {
        Product product = new Product("Test Product", 10.0, "Test Category");
        cart.addProduct(product);
        cart.addProduct(product);
        assertEquals("Cart should contain two instances of the same product", 2, cart.getProducts().size());
    }

    @Test
    public void addMultipleProducts() {
        Product product1 = new Product("Product 1", 10.0, "Category 1");
        Product product2 = new Product("Product 2", 20.0, "Category 2");
        cart.addProduct(product1);
        cart.addProduct(product2);
        assertEquals("Cart should contain two products", 2, cart.getProducts().size());
        assertTrue("Cart should contain Product 1", cart.getProducts().contains(product1));
        assertTrue("Cart should contain Product 2", cart.getProducts().contains(product2));
    }

    /* Test cases for getting total price from the cart */
    @Test
    public void getTotalPriceWithEmptyCart() {
        assertEquals("Total price of an empty cart should be 0.0", 0.0, cart.getTotalPrice(), 0.0);
    }

    @Test
    public void getTotalPriceWithSingleProduct() {
        Product product = new Product("Test Product", 10.0, "Test Category");
        cart.addProduct(product);
        assertEquals("Total price should equal the product's price", 10.0, cart.getTotalPrice(), 0.0);
    }

    @Test
    public void getTotalPriceWithMultipleProducts() {
        cart.addProduct(new Product("Product 1", 10.0, "Category 1"));
        cart.addProduct(new Product("Product 2", 20.0, "Category 2"));
        assertEquals("Total price should be the sum of all product prices", 30.0, cart.getTotalPrice(), 0.0);
    }

    @Test
    public void getTotalPriceWithDecimalPrices() {
        cart.addProduct(new Product("Product 1", 10.99, "Category 1"));
        cart.addProduct(new Product("Product 2", 20.49, "Category 2"));
        assertEquals("Total price should be accurate with decimal prices", 31.48, cart.getTotalPrice(), 0.0);
    }

    @Test
    public void getTotalPriceWithDuplicateProducts() {
        Product product = new Product("Test Product", 15.0, "Test Category");
        cart.addProduct(product);
        cart.addProduct(product);
        assertEquals("Total price should include duplicate products", 30.0, cart.getTotalPrice(), 0.0);
    }
}