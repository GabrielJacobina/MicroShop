package com.shop.payment.service;

import com.shop.payment.model.Order;

public interface IPaymentService {

    void acceptOrder(Order order);
}
