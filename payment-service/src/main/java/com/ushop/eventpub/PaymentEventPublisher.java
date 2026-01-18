package com.ushop.eventpub;


import com.ushop.event.Event;

public interface PaymentEventPublisher {
    String PAYMENT_SUCCEEDED_TOPIC = "payment-succeeded-topic";
    void publish(Event event);
}
