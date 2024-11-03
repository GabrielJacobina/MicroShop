package com.shop.payment.listener;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.payment.model.Order;
import com.shop.payment.service.IPaymentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(MessageListener.class);

    private final IPaymentService paymentService;

    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "${queue.order.name}")
    public void receiveMessage(Order order) throws JsonProcessingException {
        logger.info("Received order for payment: {}", objectMapper.writerWithView(Order.class).writeValueAsString(order));
        paymentService.acceptOrder(order);
    }
}
