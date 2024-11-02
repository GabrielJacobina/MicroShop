package com.shop.catalog.service;

import com.shop.catalog.model.Product;
import com.shop.catalog.model.Products;

public interface ICatalogService {

    Products getProdutos();

    Product getProductById(String uuid);
}
