package com.shop.checkout.service;

import com.shop.checkout.model.Order;
import com.shop.checkout.model.Product;

public interface IOrderService {

    Product getProductById(String uuid);

    void saveOrder(Order order);
}
