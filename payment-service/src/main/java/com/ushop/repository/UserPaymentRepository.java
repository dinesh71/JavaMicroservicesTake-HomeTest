package com.ushop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ushop.entity.UserPayment;

public interface UserPaymentRepository extends JpaRepository<UserPayment, String> {}

