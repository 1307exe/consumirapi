package com.projetoraro4.consumirapi.service;

import com.projetoraro4.consumirapi.client.DummyJsonClient;
import com.projetoraro4.consumirapi.dto.ProductResponseDTO;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private DummyJsonClient dummyJsonClient;

    public ProductResponseDTO getProductByID (Long id) {
        try {
            ProductResponseDTO product = dummyJsonClient.getProductById(id);
            return product;
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("Product search error", e);
        }
    }

    public List<ProductResponseDTO> getProductsByCategory (String category) {
        try {
            List<ProductResponseDTO> response = dummyJsonClient.getProductsByCategory(category);
            return response;
        } catch (FeignException e) {
            throw new RuntimeException("Product search error", e);
        }
    }

}
