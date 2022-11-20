package com.wingstako.mail.model.mail;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class GreetingTemplate extends FreeMarkerTemplate {

    private String username;

    @Override
    public String getTemplateName() {
        return "greeting.ftl";
    }

    @Override
    public String getPrefix() {
        return "greeting";
    }

    @Override
    public String getSubject() {
        return "[wingstako] Welcome!";
    }


}
