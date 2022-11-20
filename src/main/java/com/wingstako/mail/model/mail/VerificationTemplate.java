package com.wingstako.mail.model.mail;

public class VerificationTemplate extends FreeMarkerTemplate {

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
