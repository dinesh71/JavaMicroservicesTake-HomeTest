package com.ushop.eventpub;

import com.ushop.event.Event;

public interface OrderEventPublisher {
    String ORDER_CREATED_TOPIC = "order-created-topic";
    void publish(Event event);
}
