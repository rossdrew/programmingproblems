package com.rox.prob.interviews.companyX.auth;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @Author rossdrew
 * @Created 12/07/16.
 */
public class TestExists {
    @Test
    public void testExistingExists(){
        AuthRule rule = new Exists("name");
        assertTrue(rule.validates("{\"name\" : \"John Smith\", \"email\" : \"john.smith@example.com\", \"debit\" : 100, \"balance\" : -1}"));
    }

    @Test
    public void testNonExistingDoesntExist(){
        AuthRule rule = new Exists("foo");
        assertFalse(rule.validates("{\"name\" : \"John Smith\", \"email\" : \"john.smith@example.com\", \"debit\" : 100, \"balance\" : -1}"));
    }
}
