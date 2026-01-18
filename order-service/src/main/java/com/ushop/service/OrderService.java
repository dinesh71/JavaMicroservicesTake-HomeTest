package com.ushop.service;

import com.ushop.entity.UserOrder;

import java.util.List;

public interface OrderService {

    List<UserOrder> fetchOrders();

    UserOrder createOrder(UserOrder order);

}
