package org.example.notification;

public class PopNotification implements SendNotification {

    @Override
    public void SendNotification(){
        System.out.println("PopUp Sent!!");
    }
}
