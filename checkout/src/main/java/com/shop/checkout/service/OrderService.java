package com.shop.checkout.service;

import com.shop.checkout.client.ProductClient;
import com.shop.checkout.model.Order;
import com.shop.checkout.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final ProductClient productClient;

    private final RabbitTemplate rabbitTemplate;

    @Value("${exchange.checkout.name}")
    private String exchangeCheckoutName;

    private Product loadProduct(String uuid) {
        return productClient.getProductById(uuid);
    }

    @Override
    public Product getProductById(String uuid) {
        return this.loadProduct(uuid);
    }

    @Override
    public void saveOrder(Order order) {
        rabbitTemplate.convertAndSend(exchangeCheckoutName, "", order);
    }
}
