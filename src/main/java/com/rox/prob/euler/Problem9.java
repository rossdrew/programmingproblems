package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Problem9 implements NumericalProblem<Long> {
    @Override
    public Long solution() {
        return solution(1000L);
    }

    public long solution(long result)
    {
        return bruteForce(result);
    }

    private long bruteForce(long result)
    {
        long c = 1;
        for (int a=1; a<result; a++)
        {
            for (int b=2; b<result; b++)
            {
                //If a and b are known, c must be what's left of the target number
                c = result-a-b;

                if (a+b+c==result && (a*a) + (b*b) == (c*c))
                {
                    return a*b*c;
                }
            }
        }

        return -1;
    }

    /**
     * Euclids Formula
     *
     * With 2 positive integers m and n, with m < n then
     *
     *        (n^2 - m^2), (2mn) and (n^2 + m^2)
     *
     * is a primitive triple
     */
    private long euclidsFormula(long result)
    {
        //XXX This could be done much faster with Euclids Formula but it runs at an acceptable speed as is
        return -1;
    }
}
