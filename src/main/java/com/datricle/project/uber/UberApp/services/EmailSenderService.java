package com.datricle.project.uber.UberApp.services;

public interface EmailSenderService {
    void sendEmail(String toEmail,String subject,String body);

    void sentEmail(String[] toEmail,String subject,String body);
}
