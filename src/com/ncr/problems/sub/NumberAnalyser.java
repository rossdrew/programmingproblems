package com.ncr.problems.sub;

import java.math.BigInteger;
import java.util.Stack;

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
    public static boolean divisableBy(int number, int divisor)
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
     * The HCF of 1,2 and 3 is the HCF of hcf(1,2) and 3 i.e. hcf(1,2,3) == hcf( hcf(1,2) , 3)
     */
    static long highestCommonFactor(long[] numbers)
    {
        //Guard against < 2 numbers
        if (numbers.length < 2)
        {
            return numbers[0];
        }
        else if (numbers.length == 2)
        {
            return highestCommonFactor(numbers[0], numbers[1]);
        }

        long hcf = highestCommonFactor(numbers[0], numbers[1]);
        for (int i=2; i < numbers.length; i++)
        {
            hcf = highestCommonFactor(hcf, numbers[i]);
        }

        return hcf;
    }

    /**
     * Highest common factor calculator
     *
     * Euclidean algorithm:-
     *   - Replace larger number with it's difference from the smaller number
     *   - Repeat until one number reaches 0
     *   - The other number is now the GCD of both original numbers
     *
     * Optimised Euclidean algorithm (used here):-
     *   - <b>Replace larger number by it's remainder when divided by the smaller</b>
     *   - Repeat until one number reaches 0
     *   - The other number is now the GCD of both original numbers
     */
    private static long highestCommonFactor(long a, long b){
        if(a == 0) return b;
        if(b == 0) return a;

        if(a > b) {
            return highestCommonFactor(b, a % b);
        }

        return highestCommonFactor(a, b % a);
    }

    /**
     * LCM of 1,2,3 is
     */
    public static long lowestCommonMultiple(Long[] numbers)
    {
        //Guard against < 2 numbers
        if (numbers.length < 2)
        {
            return numbers[0];
        }
        else if (numbers.length == 2)
        {
            return highestCommonFactor(numbers[0], numbers[1]);
        }

        long result = numbers[0];
        for (int i = 1; i < numbers.length; i++)
        {
            result = lowestCommonMultiple(result, numbers[i]);
        }

        return result;
    }

    /**
     * Find the lowest common multiple of two numbers via reduction of the highest common factor
     */
    public static long lowestCommonMultiple(long a, long b)
    {
        return a * (b / highestCommonFactor(a, b));
    }
}
