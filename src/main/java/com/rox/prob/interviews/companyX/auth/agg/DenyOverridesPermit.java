package com.rox.prob.interviews.companyX.auth.agg;

/**
 * @Author rossdrew
 * @Created 12/07/16.
 */
public class DenyOverridesPermit implements AuthRuleAggregator {
    @Override
    public boolean validOverall(boolean[] decisions) {
        for (boolean b : decisions){
            if (!b)
                return false;
        }

        return true;
    }
}
