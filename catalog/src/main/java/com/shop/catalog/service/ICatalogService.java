package com.shop.catalog.service;

import com.shop.catalog.model.Product;

import java.util.List;

public interface ICatalogService {

    List<Product> getProdutos();

    Product getProductById(String uuid);
}
