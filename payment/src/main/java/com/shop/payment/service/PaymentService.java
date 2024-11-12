package com.shop.payment.service;

import com.shop.payment.model.Order;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService {

    private final RabbitTemplate rabbitTemplate;

    private final MeterRegistry meterRegistry;

    @Value("${exchange.payment.name}")
    private String exchangePaymentName;

    @Override
    public void acceptOrder(Order order) {
        order.setStatus("aprovado");
        rabbitTemplate.convertAndSend(exchangePaymentName, "", order);
        incrementMetric();
    }

    private void incrementMetric() {
        meterRegistry.counter("payment_increment").increment();
    }
}
