package com.shop.order.service;

import com.shop.order.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${exchange.order.name}")
    private String exchangeOrderName;

    private void saveOrder(Order order) {

    }

    @Override
    public void createOrder(Order order) {
        order.setUuid(UUID.randomUUID());
        order.setStatus("pendente");
        order.setTime(LocalDateTime.now());
        saveOrder(order);
        notifyOrderCreated(order);
    }

    private void notifyOrderCreated(Order order) {
        rabbitTemplate.convertAndSend(exchangeOrderName, "", order);
    }
}
