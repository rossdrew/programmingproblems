package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;
import com.rox.prob.common.NumberAnalyser;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * [Answer = 906609]
 */
public class Problem4 implements NumericalProblem
{
    @Override
    public long solution() {
        return solution(3);
    }

    /**
     * Unrelated to problem
     * @Depricated
     */
    private long buildMaxNumberWithSpecifiedDigits(int digits)
    {
        long maxNumber = 0L;
        for (int i = 0, multiplier = 1; i<digits; i++, multiplier *= 10)
        {
            maxNumber += 9 * multiplier;
        }

        return maxNumber;
    }

    /**
     * Unrelated to problem
     * @Depricated
     */
    private long buildMinNumberWithSpecifiedDigits(int digits)
    {
        int multiplier = 1;
        for (int i=1; i<digits; i++)
        {
            multiplier*=10;
        }

        return (1L * multiplier);
    }

    private long solution(int digits)
    {
        long highestPallindrome = 0;

        long min = buildMinNumberWithSpecifiedDigits(3);
        long max = buildMaxNumberWithSpecifiedDigits(3);

        for (long a=min; a <= max; a++)
        {
            for (long b=min; b <= max; b++)
            {
                long v = a * b;
                if (NumberAnalyser.isPallindrome(v))
                {
                    highestPallindrome = Math.max(v, highestPallindrome);
                }
            }
        }

        return highestPallindrome;
    }
}
