package com.wingstako.mail.service.impl;

import com.wingstako.mail.model.mail.FreeMarkerTemplate;
import com.wingstako.mail.model.mail.VerificationTemplate;
import com.wingstako.mail.service.MailService;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Configuration configuration;

    private static final String SENDER_ADDRESS = "test-sender-3029@email.com";

    @PostConstruct
    public void testSend() throws MessagingException, IOException, TemplateException {
        this.sendPlainTextEmail("This is subject", "Hello World", "test-receiver-3029@email.com");
    }

    @Override
    public void sendPlainTextEmail(String subject, String content, String... recipientEmailAddresses) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(subject);
        message.setFrom(SENDER_ADDRESS);
        message.setTo(recipientEmailAddresses);
        message.setText(content);

        this.mailSender.send(message);
    }

    public void sendHtmlEmail(String subject, String htmlContent, String... recipientEmailAddresses) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject(subject);
        helper.setFrom(SENDER_ADDRESS);
        helper.setTo(recipientEmailAddresses);
        helper.setText(htmlContent, true);
        mailSender.send(mimeMessage);
    }

    public void sendVerificationEmail(String subject, String code, String... recipientEmailAddresses)
            throws IOException, TemplateException, MessagingException {

        VerificationTemplate verificationTemplate = VerificationTemplate.builder()
                .code(code)
                .build();

        StringWriter stringWriter = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("verification", verificationTemplate);
        configuration.getTemplate("verification.ftl").process(model, stringWriter);

        String templatedContent = stringWriter.getBuffer().toString();

        this.sendHtmlEmail(subject, templatedContent, recipientEmailAddresses);
    }

    public void sendTemplateEmail(FreeMarkerTemplate template, String... recipientEmailAddresses) throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        helper.setFrom(SENDER_ADDRESS);
        helper.setTo(recipientEmailAddresses);

        StringWriter stringWriter = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        helper.setSubject(template.getSubject());
        model.put(template.getPrefix(), template);
        configuration.getTemplate(template.getTemplateName()).process(model, stringWriter);

        helper.setText(stringWriter.getBuffer().toString(), true);
        mailSender.send(mimeMessage);
    }


}
