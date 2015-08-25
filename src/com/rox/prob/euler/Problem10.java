package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;
import com.rox.prob.euler.sub.NumberAnalyser;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 * [Answer : 142913828922]
 */
public class Problem10 implements NumericalProblem {
    @Override
    public long solution() {
        return solution(2000000L);
    }

    public long solution(long limit)
    {
        long sum = 0;

        for (long i=2; i<limit; i++)
        {
            if (NumberAnalyser.isPrime(i))
            {
                sum+=i;
            }
        }

        return sum;
    }
}
