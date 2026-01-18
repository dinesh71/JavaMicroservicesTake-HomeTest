package com.ushop.controller;

import com.ushop.entity.UserNotification;
import com.ushop.service.NotifyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("api/orders")
@Log4j2
@Tag(name = "Orders", description = "Order APIs")
public class NotifyOrderController {


    private final NotifyService notifyService;

    public NotifyOrderController(NotifyService orderService) {
        this.notifyService = orderService;
    }


    @GetMapping
    public List<UserNotification> fetchNotifications() {
        return notifyService.fetchAllNotifications();
    }
}

