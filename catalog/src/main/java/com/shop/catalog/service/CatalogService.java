package com.shop.catalog.service;

import com.shop.catalog.client.ProductClient;
import com.shop.catalog.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogService implements ICatalogService {

    private final ProductClient productClient;

    private List<Product> loadProducts() {
       return productClient.getProducts();
    }

    private Product loadProduct(String uuid) {
        return productClient.getProductById(uuid);
    }

    @Override
    public List<Product> getProdutos() {
        return this.loadProducts();
    }

    @Override
    public Product getProductById(String uuid) {
        return this.loadProduct(uuid);
    }
}
