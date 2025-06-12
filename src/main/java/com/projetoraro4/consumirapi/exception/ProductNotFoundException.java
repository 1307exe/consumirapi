package com.projetoraro4.consumirapi.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String category, int stock, double price) {
        super(String.format("Products from {category} with stock higher or equal to {stock} and value less than {price} not found",
                            category, stock, price));
    }
}