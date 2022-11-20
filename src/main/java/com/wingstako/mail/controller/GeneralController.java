package com.wingstako.mail.controller;

import com.wingstako.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController {

    @Autowired
    private MailService mailService;

    @PostMapping(value = "/register")
    public void register() {

    }

}
