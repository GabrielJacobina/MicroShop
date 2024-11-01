package com.shop.product.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.product.model.Product;
import com.shop.product.model.Products;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class ProductService implements IProductService {
    private Products products;

    public ProductService() {
        loadProducts();
    }

    private void loadProducts() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getResourceAsStream("/products.json")) {
            this.products = objectMapper.readValue(inputStream, new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Products getProdutos() {
        return products;
    }

    @Override
    public Product getProductById(String uuid) {
        return products.products().stream()
                .filter(product -> product.uuid().equals(uuid))
                .findFirst()
                .orElse(null);
    }
}
