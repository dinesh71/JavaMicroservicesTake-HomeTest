package com.ushop.service;

import com.ushop.entity.UserOrder;
import com.ushop.entity.UserPayment;
import com.ushop.event.OrderCreatedEvent;

import java.util.List;

public interface PaymentService {

    List<UserPayment> fetchPayments();

    UserPayment processPaymentForOrder(OrderCreatedEvent order);

}
