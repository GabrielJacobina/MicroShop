package com.shop.checkout.service;

import com.shop.checkout.model.Product;

public interface IOrderService {

    Product getProductById(String uuid);
}
