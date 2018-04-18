package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;
import com.rox.prob.common.NumberAnalyser;

import java.util.HashSet;
import java.util.Set;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which
 * divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each
 * of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55
 * and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and
 * 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class Problem21 implements NumericalProblem<Long> {
    @Override
    public Long solution() {
        return solution(10000);
    }

    public Long solution(final int limit){
        Set<Long> found = new HashSet<>();

        for (Long a = 0L; a <= limit; a++){
            final Long da = sumOfDivisors(a);
            final Long db = sumOfDivisors(da);

            //amicable?
            if (a.equals(db) && !a.equals(da)){
                found.add(da);
                found.add(db);
            }
        }

        Long sum = 0L;
        for (Long f : found) {
            sum += f;
        }

        return sum;
    }

    public Long sumOfDivisors(final Long n){
        final Long n2 = n/2;
        Long sum = 1L;
        for (Long i=n2; i > 1; i--){
            if (NumberAnalyser.divisableBy(n, i)){
                sum += i;
            }
        }
        return sum;
    }
}
