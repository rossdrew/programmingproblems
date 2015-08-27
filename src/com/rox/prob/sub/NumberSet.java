package com.rox.prob.sub;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of a set of numbers and common operations on them
 */
public class NumberSet
{
    protected Long[] numbers;

    public Long[] getNumbers()
    {
        return numbers;
    }

    public NumberSet(Long[] numbers)
    {
        this.numbers = numbers;
    }

    /**
     * Create a NumberSet from a given range, inclusive
     */
    public static NumberSet createRangeSet(long start, long finish)
    {
        List<Long> numbers = new ArrayList<>();

        for (long i = start; i <= finish; i++)
        {
            numbers.add(i);
        }

        Long[] n = new Long[numbers.size()];
        n = numbers.toArray(n);

        return new NumberSet(n);
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
     *
     * The HCF of a, b and c is the HCF of hcf(a, b) and c i.e. hcf(a,b,c) == hcf( hcf(a,b) , c)
     */
    public long highestCommonFactor()
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
        for (long number : numbers)
        {
            hcf = highestCommonFactor(hcf, number);
        }

        return hcf;
    }

    private long highestCommonFactor(long a, long b){
        if(a == 0) return b;
        if(b == 0) return a;

        if(a > b) {
            return highestCommonFactor(b, a % b);
        }

        return highestCommonFactor(a, b % a);
    }

    /**
     * Find the lowest common multiple of two numbers via reduction of the highest common factor
     */
    public long lowestCommonMultiple()
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
        for (long number : numbers)
        {
            result = lowestCommonMultiple(result, number);
        }

        return result;
    }

    private long lowestCommonMultiple(long a, long b)
    {
        return a * (b / highestCommonFactor(a, b));
    }

    /**
     * XXX Optimization = Sum of Natural numbers = n(n-1) / 2
     */
    public long sum()
    {
        long sum = 0;
        for (Long number : numbers)
        {
            sum += number;
        }

        return sum;
    }
}
