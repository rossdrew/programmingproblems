package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Problem9 implements NumericalProblem {
    @Override
    public long solution() {
        return solution(1000L);
    }

    public long solution(long result)
    {

        return -1;
    }
}
