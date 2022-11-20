package com.wingstako.mail.scheduler;

import com.wingstako.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MarketingMailCronjob {

    @Autowired
    private MailService mailService;

    @Scheduled(cron = "0 0 18 * * ?", zone = "Asia/Hong_Kong")
    public void sendMarketingEmail() {

    }

}
