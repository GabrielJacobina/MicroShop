package com.shop.payment.listener;


import com.shop.payment.model.Order;
import com.shop.payment.service.IPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageListener {

    private final IPaymentService paymentService;

    @RabbitListener(queues = "${queue.order.name}")
    public void receiveMessage(Order order) {
        System.out.println("Nome: " + order.getName());
        System.out.println("Email: " + order.getEmail());
        System.out.println("Telefone: " + order.getPhone());
        System.out.println("Product ID: " + order.getProductId());
        // Processar a mensagem conforme necessário
        paymentService.acceptOrder(order);
    }
}
