package com.rox.prob.euler;

import com.rox.prob.sub.NumberAnalyser;
import com.rox.prob.NumericalProblem;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10,001st prime number?
 *
 * [Answer = 104743]
 */
public class Problem7 implements NumericalProblem {
    @Override
    public long solution() {
        return solution(10001L);
    }

    public long solution(long n)
    {
        long i=1;
        long f=0;

        while (f < n)
        {
            i++;
            if (NumberAnalyser.nextFactor(i) == i)
            {
                f++;
            }
        }

        return i;
    }
}
