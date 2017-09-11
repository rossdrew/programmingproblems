package com.rox.prob.interviews.companyX.auth.agg;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @Author rossdrew
 * @Created 12/07/16.
 */
public class TestDenyOverridesPermit {
    @Test
    public void testAllPermit(){
        AuthRuleAggregator aggregator = new DenyOverridesPermit();
        assertTrue(aggregator.validOverall(new boolean[] {true, true, true, true}));
    }

    @Test
    public void testAllDeny(){
        AuthRuleAggregator aggregator = new DenyOverridesPermit();
        assertFalse(aggregator.validOverall(new boolean[] {false, false, false, false}));
    }

    @Test
    public void testOneDeny(){
        AuthRuleAggregator aggregator = new DenyOverridesPermit();
        assertFalse(aggregator.validOverall(new boolean[] {true, false, true, true}));
    }

}
