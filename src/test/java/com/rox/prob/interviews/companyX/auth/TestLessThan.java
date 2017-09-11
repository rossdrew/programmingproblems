package com.rox.prob.interviews.companyX.auth;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @Author rossdrew
 * @Created 12/07/16.
 */
public class TestLessThan {
    @Test
    public void testLessThan(){
        AuthRule rule = new LessThan("debit", 101);
        assertTrue(rule.validates("{\"name\" : \"John Smith\", \"email\" : \"john.smith@example.com\", \"debit\" : 100, \"balance\" : -1}"));
    }

    @Test
    public void testGreaterThan(){
        AuthRule rule = new LessThan("debit", 99);
        assertFalse(rule.validates("{\"name\" : \"John Smith\", \"email\" : \"john.smith@example.com\", \"debit\" : 100, \"balance\" : -1}"));
    }
}
