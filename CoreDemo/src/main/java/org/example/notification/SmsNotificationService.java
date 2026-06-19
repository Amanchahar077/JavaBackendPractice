package org.example.notification;

public class SmsNotificationService implements NotificationService {

    @Override
    public void SendNotification(){
        System.out.println("Sms Sent!!");
    }
}
