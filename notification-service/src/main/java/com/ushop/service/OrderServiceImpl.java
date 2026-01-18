package com.ushop.service;

import com.ushop.entity.UserNotification;
import com.ushop.event.PaymentSuccededEvent;
import com.ushop.repository.UserNotifyRepository;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class OrderServiceImpl implements NotifyService {

    private final UserNotifyRepository repository;

    public OrderServiceImpl(UserNotifyRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<UserNotification> fetchAllNotifications() {
        return repository.findAll();
    }

    /**
     * Creates a new order and publish to kafka
     * @param order
     * @return
     */
    @Override
    @Transactional
    public UserNotification processNotificationForPayment(PaymentSuccededEvent paymentSuccededEvent) {
        String orderId = UUID.randomUUID().toString();
        UserNotification userNotification = new UserNotification();
        userNotification.setId(orderId);
        userNotification.setStatus("SUCCESS");
        userNotification.setPaymentId(paymentSuccededEvent.getPaymentId());

        UserNotification saved = repository.save(userNotification);


        return saved;
    }
}
