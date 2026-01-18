package com.ushop.service;


import com.ushop.event.OrderCreatedEvent;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import com.ushop.entity.UserOrder;
import com.ushop.entity.UserPayment;
import com.ushop.event.PaymentSuccededEvent;
import com.ushop.eventpub.PaymentEventPublisher;
import com.ushop.repository.UserPaymentRepository;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

    private final UserPaymentRepository repository;
    private final PaymentEventPublisher paymentEventPublisher;

    public PaymentServiceImpl(UserPaymentRepository repository, PaymentEventPublisher orderEventPublisher) {
        this.repository = repository;
        this.paymentEventPublisher = orderEventPublisher;
    }

    @Override
    public List<UserPayment> fetchPayments() {
        return repository.findAll();
    }

    /**
     * Creates a new order and publish to kafka
     * @param orderevent
     * @return
     */
    @Override
    @Transactional
    public UserPayment processPaymentForOrder(OrderCreatedEvent order) {
        String orderId = UUID.randomUUID().toString();
        UserPayment payment = new UserPayment();
        payment.setOrderId(order.getOrderId());
        payment.setStatus("SUCCESS");
        payment.setAmount(order.getAmount());
        payment.setId(orderId);

        UserPayment userPaymentSaved = repository.save(payment);
        PaymentSuccededEvent event = new PaymentSuccededEvent(userPaymentSaved.getId(), userPaymentSaved.getAmount());
        paymentEventPublisher.publish(event);

        log.info("Event created");

        return userPaymentSaved;
    }
}
