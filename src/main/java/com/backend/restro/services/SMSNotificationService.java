package com.backend.restro.services;

import org.springframework.stereotype.Service;

@Service
public class SMSNotificationService implements NotificationService{

    @Override
    public String sendNotification() {
        return "SMS notification sent";
    }
}
