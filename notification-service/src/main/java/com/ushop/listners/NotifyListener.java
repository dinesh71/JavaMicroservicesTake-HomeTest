package com.ushop.listners;

import com.ushop.event.PaymentSuccededEvent;
import com.ushop.service.NotifyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class NotifyListener {

    private final NotifyService notifyService;

    public NotifyListener(NotifyService paymentService) {
        this.notifyService = paymentService;
    }

    @KafkaListener(topics = "payment-succeeded-topic", groupId = "notification-service")
    public void handlePaySuccess(PaymentSuccededEvent event) {
        log.info("Processing payment for order {}" , event.getPaymentId());
        notifyService.processNotificationForPayment(event);
    }
}

