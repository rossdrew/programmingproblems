package com.rox.prob.interviews.companyX.auth.agg;

/**
 * @Author rossdrew
 * @Created 12/07/16.
 */
public class MajorityWinsBiasPermit implements AuthRuleAggregator {
    @Override
    public boolean validOverall(boolean[] decisions) {
        int permitCount = 0;

        for (boolean b : decisions){
            if (b) {
                permitCount++;
                if (permitCount >= (decisions.length/2)){
                    return true;
                }
            }
        }

        return false;
    }
}
