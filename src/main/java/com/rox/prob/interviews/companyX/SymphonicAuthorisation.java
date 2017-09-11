package com.rox.prob.interviews.symphonic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @Author rossdrew
 * @Created 12/07/16.
 */
@SpringBootApplication
public class SymphonicAuthorisation {
    public static void main(String[] args) {
        System.out.println("Starting SymphonicAuthorisation via Spring Boot...");

        ApplicationContext ctx = SpringApplication.run(SymphonicAuthorisation.class, args);
    }
}
