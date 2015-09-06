package com.rox.prob.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for analysing numbers
 *
 * XXX Could be made into non-utility method by creating an instance
 *     for number in question then running queries on it
 */
public class NumberAnalyser
{
    /**
     * Is <code>number</code> divisable by <code>divisor</code>
     */
    public static boolean divisableBy(long number, long divisor)
    {
        return (number % divisor == 0);
    }

    /**
     * Return lowest factor of given number
     */
    public static long nextFactor(long n)
    {
        long factorSearchLimit = n / 2;

        for (long divisor = 2; divisor <= factorSearchLimit; divisor++)
        {
            //if n is divisible by divisor then divisor is a factor of n
            if (n % divisor == 0)
            {
                return divisor;
            }
        }

        return n;
    }

    /**
     * Count the number of values n is divisible by
     *
     * XXX Possible improvement with prime factorisation or coprime property
     */
    public static long factorCount(long n)
    {
        long count = 0;
        long ceiling = (long)Math.sqrt(n);

        for (int i = 1; i <= ceiling; i++)
        {
            if (n % i == 0)
            {
                //Count 1 divisor for each end of the squared root
                count+=2;
            }
        }

        //Perfect square includes last number so remove duplicate
        if (ceiling * ceiling == n)
            count--;

        return count;
    }

    public static boolean isPrime(long n)
    {
        long min = 2;
        double max = Math.sqrt((double)n);

        for (long i=min; i<=max; i++)
        {
            if (divisableBy(n, i))
            {
                return false;
            }
        }

        return true;
    }

    public static long[] getDigits(long number)
    {
        int NUMBER_BASE = 10;

        int length = getDigitCountInNumber(number);
        long[] digits = new long[length];

        long explodingNumber = number;
        long remainder;
        int i=digits.length-1;

        while (explodingNumber > 0)
        {
            remainder = explodingNumber % NUMBER_BASE;
            explodingNumber /= NUMBER_BASE;

            digits[i--] = remainder;
            if (explodingNumber < NUMBER_BASE)
            {
                digits[i--] = explodingNumber;
                explodingNumber = 0;
            }
        }

        return digits;
    }

    public static boolean isPallindrome(long number)
    {
        long[] d = getDigits(number);

        for (int i=0; i<d.length / 2; i++)
        {
            if (!(d[i] == d[d.length-i-1]))
            {
                return false;
            }
        }

        return true;
    }

    public static int getDigitCountInNumber(long number)
    {
        return (int)(Math.log10(number)+1);
    }
}
