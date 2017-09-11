package com.rox.prob.interviews.companyX.auth.agg;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @Author rossdrew
 * @Created 12/07/16.
 */
public class TestPermitOverridesDeny {
    @Test
    public void testAllPermit(){
        AuthRuleAggregator aggregator = new PermitOverridesDeny();
        assertTrue(aggregator.validOverall(new boolean[] {true, true, true, true}));
    }

    @Test
    public void testAllDeny(){
        AuthRuleAggregator aggregator = new PermitOverridesDeny();
        assertFalse(aggregator.validOverall(new boolean[] {false, false, false, false}));
    }

    @Test
    public void testOneDeny(){
        AuthRuleAggregator aggregator = new PermitOverridesDeny();
        assertTrue(aggregator.validOverall(new boolean[] {true, false, true, true}));
    }

    @Test
    public void testOnePermit(){
        AuthRuleAggregator aggregator = new PermitOverridesDeny();
        assertTrue(aggregator.validOverall(new boolean[] {false, false, true, false}));
    }
}
