package com.projetoraro4.consumirapi.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String category, int stock, double price) {
        super(String.format("Produtos da categoria %s com estoque maior ou igual a %d e valor menor que %.2f não encontrados",
                category, stock, price));
    }
}