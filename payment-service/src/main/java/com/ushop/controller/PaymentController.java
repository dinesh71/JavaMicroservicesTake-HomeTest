package com.ushop.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import com.ushop.entity.UserPayment;
import com.ushop.service.PaymentService;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("api/payments")
@Log4j2
@Tag(name = "Payments", description = "Payment APIs")
public class PaymentController {


    private final PaymentService paymentService;

    public PaymentController(PaymentService orderService) {
        this.paymentService = orderService;
    }

    @GetMapping
    public List<UserPayment> fetchOrders() {
        return paymentService.fetchPayments();
    }
}

