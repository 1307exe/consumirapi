package com.projetoraro4.consumirapi.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductRequestDTO {
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @DecimalMax(value = "2000.00", message = "Price must be less than 2000")
    private double price;

    @NotBlank(message = "Category is mandatory")
    private String category;

    @Min(value = 1, message = "Stock must be greater than 0")
    private int stock;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}