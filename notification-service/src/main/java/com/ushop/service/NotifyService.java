package com.ushop.service;

import com.ushop.entity.UserNotification;
import com.ushop.event.PaymentSuccededEvent;

import java.util.List;

public interface NotifyService {

    List<UserNotification> fetchAllNotifications();

    UserNotification processNotificationForPayment(PaymentSuccededEvent paymentSuccededEvent);

}
