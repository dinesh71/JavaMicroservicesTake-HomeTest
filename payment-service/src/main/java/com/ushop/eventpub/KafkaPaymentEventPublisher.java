package com.ushop.eventpub;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.ushop.event.Event;
import com.ushop.event.PaymentSuccededEvent;

@Component
@ConditionalOnProperty(
        name = "messaging.type",
        havingValue = "kafka"
)
public class KafkaPaymentEventPublisher implements PaymentEventPublisher {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public KafkaPaymentEventPublisher(KafkaTemplate<String, Object> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void publish(Event event) {
//        try {
//            String jsonEvent = objectMapper.writeValueAsString(event);
//            kafkaTemplate.send(PAYMENT_SUCCEEDED_TOPIC,
//                    ((PaymentSuccededEvent) event).getPaymentId(),
//                    jsonEvent );
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }

        kafkaTemplate.send(PAYMENT_SUCCEEDED_TOPIC,
                ((PaymentSuccededEvent) event).getPaymentId(),
                event
        );
    }
}
