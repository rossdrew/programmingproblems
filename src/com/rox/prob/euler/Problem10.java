package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 */
public class Problem10 implements NumericalProblem {
    @Override
    public long solution() {
        return solution(10L);
    }

    public long solution(long limit)
    {
        return -1;
    }
}
