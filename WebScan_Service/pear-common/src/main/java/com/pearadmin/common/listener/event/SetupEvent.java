package com.pearadmin.common.listener.event;

import org.springframework.context.ApplicationEvent;

import java.util.Map;

public class SetupEvent extends ApplicationEvent {

    private Map<String, String> mailConfig;

    public SetupEvent(Object source, Map<String, String> mailConfig) {
        super(source);
        this.mailConfig = mailConfig;
    }

    public Map<String, String> getMailConfig() {
        return mailConfig;
    }

}
