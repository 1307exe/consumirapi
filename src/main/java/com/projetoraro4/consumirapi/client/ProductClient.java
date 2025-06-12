package com.projetoraro4.consumirapi.client;

import com.projetoraro4.consumirapi.config.FeignConfig;
import com.projetoraro4.consumirapi.dto.ProductResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "dummyJsonClient", url = "https://dummyjson.com", configuration = FeignConfig.class)
public interface ProductClient {

    @GetMapping("/products/category/{category}")
    ProductListResponse getProductsByCategory(@PathVariable String category);

    @GetMapping("/products/{id}")
    ProductResponseDTO getProductById(@PathVariable Long id);

    class ProductListResponse {
        private List<ProductResponseDTO> products;
        private int total;
        private int skip;
        private int limit;

        public List<ProductResponseDTO> getProducts() {
            return products;
        }

        public void setProducts(List<ProductResponseDTO> products) {
            this.products = products;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getSkip() {
            return skip;
        }

        public void setSkip(int skip) {
            this.skip = skip;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }
    }

}