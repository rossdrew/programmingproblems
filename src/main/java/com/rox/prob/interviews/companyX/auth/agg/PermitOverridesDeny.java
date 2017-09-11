package com.rox.prob.interviews.companyX.auth.agg;

/**
 * @Author rossdrew
 * @Created 12/07/16.
 */
public class PermitOverridesDeny implements AuthRuleAggregator {
    @Override
    public boolean validOverall(boolean[] decisions) {
        for (boolean b : decisions){
            if (b)
                return true;
        }

        return false;
    }
}
