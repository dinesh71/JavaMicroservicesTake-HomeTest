package com.ushop.eventpub;

import com.ushop.event.Event;
import com.ushop.event.OrderCreatedEvent;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
        name = "messaging.type",
        havingValue = "kafka"
)
public class KafkaOrderEventPublisher implements OrderEventPublisher {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaOrderEventPublisher(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(Event event) {
        kafkaTemplate.send(ORDER_CREATED_TOPIC,
                ((OrderCreatedEvent) event).getOrderId(),
                event
        );
    }
}
