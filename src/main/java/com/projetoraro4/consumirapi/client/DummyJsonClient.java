package com.projetoraro4.consumirapi.client;

import com.projetoraro4.consumirapi.config.FeignConfig;
import com.projetoraro4.consumirapi.dto.ProductResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "dummyJsonClient", url = "https://dummyjson.com", configuration = FeignConfig.class)
public interface DummyJsonClient {

    @GetMapping("/products/category/{category}")
    List<ProductResponseDTO> getProductsByCategory(@PathVariable String category);

    @GetMapping("/products/{id}")
    ProductResponseDTO getProductById(@PathVariable Long id);
}