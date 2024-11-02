package com.shop.order.service;

import com.shop.order.model.Order;
import com.shop.order.repository.OrderRepository;
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

    private final OrderRepository orderRepository;

    @Value("${exchange.order.name}")
    private String exchangeOrderName;

    private Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void createOrder(Order order) {
        order.setUuid(UUID.randomUUID());
        order.setStatus("pendente");
        order.setTime(LocalDateTime.now());
        saveOrder(order);
        notifyOrderCreated(order);
    }

    @Override
    public void updateOrder(Order order) {
        saveOrder(order);
    }

    private void notifyOrderCreated(Order order) {
        rabbitTemplate.convertAndSend(exchangeOrderName, "", order);
    }
}
