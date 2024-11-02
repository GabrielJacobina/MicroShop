package com.shop.order.service;

import com.shop.order.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${exchange.order.name}")
    private String exchangeCheckoutName;

    @Override
    public void saveOrder(Order order) {
        rabbitTemplate.convertAndSend(exchangeCheckoutName, "", order);
    }
}
