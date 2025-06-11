package com.projetoraro4.consumirapi.controller;

import com.projetoraro4.consumirapi.dto.ProductRequestDTO;
import com.projetoraro4.consumirapi.dto.ProductResponseDTO;
import com.projetoraro4.consumirapi.service.ProductService;
import feign.Response;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping ("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById (
            @PathVariable ("id")
            @Positive (message = "ID must be a positive number")
            Long id
            ) {
        ProductResponseDTO product = productService.getProductByID(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping ("/category/{category}")
    public ResponseEntity<List<ProductResponseDTO>> getProductsByCategory (
            @PathVariable ("category")
            @NotBlank (message = "Category cannot be empty")
            String category
            ) {
        List<ProductResponseDTO> products = productService.getProductsByCategory(category);
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<List<ProductResponseDTO>> getProducts(@Valid @RequestBody ProductRequestDTO request) {
        List<ProductResponseDTO> products = productService.getProductsByCategory(request.);
        return ResponseEntity.ok(products);
    }
}