package com.rox.prob.interviews.companyX;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @Author rossdrew
 * @Created 12/07/16.
 */
@SpringBootApplication
public class CompanyXAuthorisation {
    public static void main(String[] args) {
        System.out.println("Starting CompanyXAuthorisation via Spring Boot...");

        ApplicationContext ctx = SpringApplication.run(CompanyXAuthorisation.class, args);
    }
}
