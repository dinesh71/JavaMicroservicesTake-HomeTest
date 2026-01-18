package com.ushop.service;

import com.ushop.entity.UserOrder;
import com.ushop.event.OrderCreatedEvent;
import com.ushop.eventpub.OrderEventPublisher;
import com.ushop.repository.UserOrderRepository;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{

    private final UserOrderRepository repository;
    private OrderEventPublisher orderEventPublisher;

    public OrderServiceImpl(UserOrderRepository repository, OrderEventPublisher orderEventPublisher) {
        this.repository = repository;
        this.orderEventPublisher = orderEventPublisher;
    }

    @Override
    public List<UserOrder> fetchOrders() {
        return repository.findAll();
    }

    /**
     * Creates a new order and publish to kafka
     * @param order
     * @return
     */
    @Override
    @Transactional
    public UserOrder createOrder(UserOrder order) {
        String orderId = UUID.randomUUID().toString();
        order.setId(orderId);
        order.setStatus("CREATED");

        UserOrder savedOrder = repository.save(order);
        OrderCreatedEvent event = new OrderCreatedEvent(orderId, order.getAmount());
        orderEventPublisher.publish(event);

        log.info("Event created");

        return savedOrder;
    }
}
