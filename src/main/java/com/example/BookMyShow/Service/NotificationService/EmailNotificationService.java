package com.example.BookMyShow.Service.NotificationService;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmailNotificationService implements NotificationService{
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendNotification(String destination, String msg) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(destination);
        message.setSubject("BookMyShow - Important Notification"); // Set your desired subject
        message.setText(msg);

        javaMailSender.send(message);

    }
}
