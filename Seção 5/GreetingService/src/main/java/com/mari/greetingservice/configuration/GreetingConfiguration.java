package com.mari.greetingservice.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@ConfigurationProperties("greeting-service") // -> CLASSE QUE FAZ O BIND COM YML E JAVA
public class GreetingConfiguration {

    private String greeting;
    private String defaultValue;

    public GreetingConfiguration() {}


    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
