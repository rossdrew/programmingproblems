package com.rox.prob.interviews.companyX.auth;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;

/**
 * @Author rossdrew
 * @Created 12/07/16.
 */
public class TestMatch {
    @Test
    public void testMatch(){
        AuthRule rule = new Match("name", "John");
        assertFalse(rule.validates("{\"name\" : \"John Smith\", \"email\" : \"john.smith@example.com\", \"debit\" : 100, \"balance\" : -1}"));
    }

    @Test
    public void testNoMatch(){
        AuthRule rule = new Match("name", "XXX");
        assertFalse(rule.validates("{\"name\" : \"John Smith\", \"email\" : \"john.smith@example.com\", \"debit\" : 100, \"balance\" : -1}"));
    }
}
