package com.shop.order.listener;

import com.shop.order.model.Order;
import com.shop.order.service.IOrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @Autowired
    private IOrderService orderService;

    @RabbitListener(queues = "${queue.checkout.name}")
    public void receiveMessage(Order order) {
        System.out.println("Nome: " + order.getName());
        System.out.println("Email: " + order.getEmail());
        System.out.println("Telefone: " + order.getPhone());
        System.out.println("Product ID: " + order.getProductId());
        // Processar a mensagem conforme necessário
        orderService.createOrder(order);
    }
}
