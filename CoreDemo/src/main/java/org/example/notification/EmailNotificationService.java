package org.example.notification;

public class EmailNotificationService implements NotificationService {

    @Override
    public void SendNotification(){
        System.out.println("Email is Sent!!");
    }
}
