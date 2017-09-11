package com.rox.prob.interviews.companyX.auth.agg;

/**
 * @Author rossdrew
 * @Created 12/07/16.
 */
public class MajorityWinsBiasDeny implements AuthRuleAggregator {
    @Override
    public boolean validOverall(boolean[] decisions) {
        int denyCount = 0;

        for (boolean b : decisions){
            if (!b) {
                denyCount++;
                if (denyCount >= (decisions.length/2)){
                    return false;
                }
            }
        }

        return true;
    }
}
