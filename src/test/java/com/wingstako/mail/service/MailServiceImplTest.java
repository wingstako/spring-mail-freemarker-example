package com.wingstako.mail.service;

import com.wingstako.mail.model.mail.VerificationTemplate;
import com.wingstako.mail.service.impl.MailServiceImpl;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootTest
public class MailServiceImplTest {

    @Autowired
    private MailServiceImpl mailService;

    @Autowired
    private Configuration configuration;

    @Test
    public void testSendPlainTextEmail() {

        String subject = "[Test] Plain Text";
        String content = "This is a plain text email";
        String recipient = "test-receiver-3029@email.com";

        mailService.sendPlainTextEmail(subject, content, recipient);
    }

    @Test
    public void testSendHtmlEmail() throws MessagingException {

        String subject = "[Test] HTML";
        String content = "<h1>This is a HTML email</h1>";
        String recipient = "test-receiver-3029@email.com";

        mailService.sendHtmlEmail(subject, content, recipient);
    }

    @Test
    public void testSendTemplatedVerificationEmail() throws MessagingException, TemplateException, IOException {

        String subject = "[Test] Templated";
        String code = "123456";
        String recipient = "test-receiver-3029@email.com";

        this.mailService.sendVerificationEmail(subject, code, recipient);
    }

}
