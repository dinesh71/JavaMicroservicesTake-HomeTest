package com.ushop.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentSuccededEvent implements Event {
    private String paymentId;
    private double amount;
}


