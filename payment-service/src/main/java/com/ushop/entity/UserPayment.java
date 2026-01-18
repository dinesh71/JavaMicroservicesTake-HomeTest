package com.ushop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserPayment {

    @Id
    private String id;
    private double amount;
    private String status;
    private String orderId;



}

