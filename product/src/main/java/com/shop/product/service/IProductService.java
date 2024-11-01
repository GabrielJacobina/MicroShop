package com.shop.product.service;

import com.shop.product.model.Product;
import com.shop.product.model.Products;

public interface IProductService {

    Products getProdutos();

    Product getProductById(String uuid);
}
