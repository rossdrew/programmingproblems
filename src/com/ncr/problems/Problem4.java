package com.ncr.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * [Answer = 906609]
 */
public class Problem4 implements Problem
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
                if (isPallindrome(v))
                {
                    highestPallindrome = Math.max(v, highestPallindrome);
                }
            }
        }

        return highestPallindrome;
    }

    private List<Long> explodeDigits(long number)
    {
        int NUMBER_BASE = 10;

        ArrayList<Long> explodedNumbers = new ArrayList<>();

        long explodingNumber = number;
        long remainder = 0;
        while (explodingNumber > 0)
        {
            remainder = explodingNumber % NUMBER_BASE;
            explodingNumber /= NUMBER_BASE;

            explodedNumbers.add(remainder);
            if (explodingNumber < NUMBER_BASE)
            {
                explodedNumbers.add(explodingNumber);
                explodingNumber = 0;
            }
        }

        return explodedNumbers;
    }

    private boolean isPallindrome(long number)
    {
        List<Long> digits = explodeDigits(number);

        for (int i=0; i<digits.size() / 2; i++)
        {
            if (!digits.get(i).equals(digits.get(digits.size()-i-1)))
            {
                return false;
            }
        }

        return true;
    }
}
