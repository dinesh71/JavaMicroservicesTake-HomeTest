package com.ushop.listners;

import com.ushop.event.OrderCreatedEvent;
import com.ushop.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class PaymentListener {

    private final PaymentService paymentService;

    public PaymentListener(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @KafkaListener(topics = "order-created-topic", groupId = "payment-service")
    public void consumeOrderCreated(OrderCreatedEvent event) {
        log.info("Processing payment for order {}" , event.getOrderId());
        paymentService.processPaymentForOrder(event);
    }
}

