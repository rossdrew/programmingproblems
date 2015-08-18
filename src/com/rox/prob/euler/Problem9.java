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
 *
 * XXX This could be done much fast eith Euclids Formula but it runs at an acceptable speed as is
 *
 * [Answer : 31875000]
 */
public class Problem9 implements NumericalProblem {
    @Override
    public long solution() {
        return solution(1000L);
    }

    public long solution(long result)
    {
        for (int a=1; a<result; a++)
        {
            for (int b=2; b<result; b++)
            {
                for (int c=3; c<result; c++)
                {
                    if (a+b+c==result && (a*a) + (b*b) == (c*c))
                    {
                        return a*b*c;
                    }
                }
            }
        }

        return 0;
    }
}
