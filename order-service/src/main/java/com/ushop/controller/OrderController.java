package com.ushop.controller;

import com.ushop.entity.UserOrder;
import com.ushop.repository.UserOrderRepository;
import com.ushop.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 *
 */
@RestController
@RequestMapping("api/orders")
@Log4j2
@Tag(name = "Orders", description = "Order APIs")
public class OrderController {


    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public UserOrder createOrder(@RequestBody UserOrder order) {
        return orderService.createOrder(order);
    }

    @GetMapping
    public List<UserOrder> fetchOrders() {
        return orderService.fetchOrders();
    }
}

