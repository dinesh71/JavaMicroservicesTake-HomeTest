package com.ushop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserNotification {

    @Id
    private String id;
    private String paymentId;
    private String status;



}

