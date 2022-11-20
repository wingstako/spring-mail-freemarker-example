package com.wingstako.mail.service;

public interface MailService {


    void sendPlainTextEmail(String subject, String content, String... recipientEmailAddresses);
}
