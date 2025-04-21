# Shopping Cart Application

This repository contains a shopping cart application developed in Java using Maven. It provides the following features:

- Add products to the cart, including duplicate products.
- Calculate the total price, supporting decimal values.
- Validate products to prevent null entries.
- Calculate the average price of products in the cart.
- Find the most expensive product in the cart.
- Count products by category.
- Calculate discounts on the total purchase.

## Testing

The project implements two types of tests to verify functionality:

- **Unit tests**: Implemented with JUnit to test individual components in isolation.
- **Integration tests**: Verify the correct interaction between multiple system components:
  - Use real implementations of `ShoppingCart` and `Product`
  - Test complete operational flows
  - Verify correct interaction between `Product`, `ShoppingCart`, and `CartOperations`

The project follows object-oriented design principles for maintainability and scalability.