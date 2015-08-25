package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;
import com.rox.prob.euler.sub.NumberAnalyser;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 * [Answer : 142913828922]
 *
 * XXX
 * This could be improved by using The sieve of Eratosthenes
 *
 * 1. Make a list of all numbers from 2 to N.
 * 2. Find the next number p not yet crossed out. This is a prime. If it is greater than the squared root of N, go to 5.
 * 3. Cross out all multiples of p which are not yet crossed out.
 * 4. Go to 2.
 * 5. The numbers not crossed out are the primes not exceeding N.
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
