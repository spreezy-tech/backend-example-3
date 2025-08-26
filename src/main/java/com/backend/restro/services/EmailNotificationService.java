package com.backend.restro.services;

import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService{

    @Override
    public String sendNotification() {
        return "Email notification sent";
    }
}
