package com.rox.prob.interviews.symphonic.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @Author rossdrew
 * @Created 12/07/16.
 */
@org.springframework.context.annotation.Configuration
@ConfigurationProperties
public class Configuration {
    public class Rule{
        private Map<String, String> rules;

        public void setExists(Map<String, String> conditions){
         //   conditions.put("EXISTS", conditions);
        }
    }

    private Map<String, Rule> rules;

    public void setRules(Map<String, Rule> rules) {
        System.out.println("############### Rules set");
        this.rules = rules;
    }

    public void setTestProperty(String testValue){
        System.out.println("################## " + testValue);
    }
}
