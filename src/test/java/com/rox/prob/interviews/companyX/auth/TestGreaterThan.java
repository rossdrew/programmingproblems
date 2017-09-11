package com.rox.prob.interviews.companyX.auth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author rossdrew
 * @Created 12/07/16.
 */
public class TestGreaterThan  {
    @Test
    public void testLessThan(){
        AuthRule rule = new GreaterThan("debit", 101);
        assertFalse(rule.validates("{\"name\" : \"John Smith\", \"email\" : \"john.smith@example.com\", \"debit\" : 100, \"balance\" : -1}"));
    }

    @Test
    public void testGreaterThan(){
        AuthRule rule = new GreaterThan("debit", 99);
        assertTrue(rule.validates("{\"name\" : \"John Smith\", \"email\" : \"john.smith@example.com\", \"debit\" : 100, \"balance\" : -1}"));
    }
}
