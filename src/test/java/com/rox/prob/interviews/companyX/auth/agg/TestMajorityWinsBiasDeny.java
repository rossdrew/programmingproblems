package com.rox.prob.interviews.companyX.auth.agg;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @Author rossdrew
 * @Created 12/07/16.
 */
public class TestMajorityWinsBiasDeny {
    @Test
    public void testAllPermit(){
        AuthRuleAggregator aggregator = new MajorityWinsBiasDeny();
        assertTrue(aggregator.validOverall(new boolean[] {true, true, true, true}));
    }

    @Test
    public void testAllDeny(){
        AuthRuleAggregator aggregator = new MajorityWinsBiasDeny();
        assertFalse(aggregator.validOverall(new boolean[] {false, false, false, false}));
    }

    @Test
    public void testHalfAndHalf(){
        AuthRuleAggregator aggregator = new MajorityWinsBiasDeny();
        assertFalse(aggregator.validOverall(new boolean[] {true, false, true, false}));
    }
}
