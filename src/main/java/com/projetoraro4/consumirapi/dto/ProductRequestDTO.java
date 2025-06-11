package com.projetoraro4.consumirapi.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductRequestDTO {
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @DecimalMax(value = "2000.00", message = "Price must be less than 2000")
    private double price;

    @Min(value = 1, message = "Stock must be greater than 0")
    private int stock;

    @NotBlank(message = "Category is mandatory")
    private String category;
}