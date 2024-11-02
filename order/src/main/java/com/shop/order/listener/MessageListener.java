package com.shop.order.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class MessageListener {

    @RabbitListener(queues = "{queue.checkout.name}")
    public void receiveMessage(String message) {
        System.out.println("Mensagem recebida: " + message);
        // Processar a mensagem conforme necessário
    }
}
