package com.shop.order.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.order.model.Order;
import com.shop.order.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;


@RequiredArgsConstructor
@Component
public class MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(MessageListener.class);

    private final ObjectMapper objectMapper;

    private final IOrderService orderService;

    @RabbitListener(queues = "${queue.checkout.name}")
    public void receiveMessageCheckout(Order order) throws JsonProcessingException {
        logger.info("Received order of checkout: {}", objectMapper.writerWithView(Order.class).writeValueAsString(order));
        orderService.createOrder(order);
    }

    @RabbitListener(queues = "${queue.payment.name}")
    public void receiveMessagePayment(Order order) throws JsonProcessingException {
        logger.info("Received order of payment: {}", objectMapper.writerWithView(Order.class).writeValueAsString(order));
        orderService.updateOrder(order);
    }
}
