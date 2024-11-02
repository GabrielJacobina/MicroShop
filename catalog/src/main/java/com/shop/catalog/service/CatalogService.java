package com.shop.catalog.service;

import com.shop.catalog.client.ProductClient;
import com.shop.catalog.model.Product;
import com.shop.catalog.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogService implements ICatalogService {
    private Products products;

    @Autowired
    private ProductClient productClient;

    private void loadProducts() {
       this.products = productClient.getProducts();
    }

    @Override
    public Products getProdutos() {
        this.loadProducts();
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
