package com.wingstako.mail.model.mail;


import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@Builder
public class VerificationTemplate extends FreeMarkerTemplate {

    private String code;

    @Override
    public String getTemplateName() {
        return "verification.ftl";
    }

    @Override
    public String getPrefix() {
        return "verification";
    }

    @Override
    public String getSubject() {
        return "[wingstako] Verification Code";
    }


}
