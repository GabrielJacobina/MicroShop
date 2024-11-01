package com.shop.product.service;

import com.shop.product.model.Product;
import com.shop.product.model.Products;

public interface ProductService {

    Products getProdutos();

    Product getProductById(int id);
}
