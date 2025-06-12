package com.projetoraro4.consumirapi.service;

import com.projetoraro4.consumirapi.client.ProductClient;
import com.projetoraro4.consumirapi.dto.ProductRequestDTO;
import com.projetoraro4.consumirapi.dto.ProductResponseDTO;
import com.projetoraro4.consumirapi.exception.ProductNotFoundException;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductClient productClient;

    public ProductResponseDTO getProductByID(Long id) {
        try {
            ProductResponseDTO product = productClient.getProductById(id);
            return product;
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("Product search error", e);
        }
    }

    public List<ProductResponseDTO> getProductsByCategory(String category) {
        try {
            ProductClient.ProductListResponse response = productClient.getProductsByCategory(category);
            return response.getProducts();
        } catch (FeignException e) {
            throw new RuntimeException("Product search error", e);
        }
    }

    public List<ProductResponseDTO> getProduct(ProductRequestDTO request) {
        long startTime = System.currentTimeMillis();
        try {
            log.info("Searching products by category: {}", request.getCategory());
            ProductClient.ProductListResponse response = productClient.getProductsByCategory(request.getCategory());
            List<ProductResponseDTO> products = response.getProducts();
            if (products == null || products.isEmpty()) {
                throw new ProductNotFoundException(request.getCategory(), request.getStock(), request.getPrice());
            }

            List<ProductResponseDTO> filteredProducts = products.stream()
                    .filter(product -> product.getPrice() < request.getPrice())
                    .filter(product -> product.getStock() >= request.getStock())
                    .collect(Collectors.toList());

            if (filteredProducts.isEmpty()) {
                throw new ProductNotFoundException(request.getCategory(), request.getStock(), request.getPrice());
            }

            log.info("Encontrados {} produtos após filtros", filteredProducts.size());
            return filteredProducts;
        } catch (FeignException e) {
            log.error("Product search error", e);
            throw new RuntimeException("Product search error", e);
        } finally {
            long endTime = System.currentTimeMillis();
            log.info("Request time: {} ms", endTime - startTime);
        }
    }

}
