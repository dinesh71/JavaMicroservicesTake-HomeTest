package com.ushop.repository;


import com.ushop.entity.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNotifyRepository extends JpaRepository<UserNotification, String> {}

