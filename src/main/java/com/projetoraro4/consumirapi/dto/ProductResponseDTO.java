package com.projetoraro4.consumirapi.dto;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private int id;
    private String title;
    private String description;
    private double price;
    private double rating;
    private int stock;
    private String brand;
    private String category;
}