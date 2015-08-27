package com.rox.prob.euler;

import com.rox.prob.common.NumberAnalyser;
import com.rox.prob.NumericalProblem;

import java.util.HashSet;

/**
 * Multiples of 3 and 5
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * Definitions:
 *
 *  Natural Number = Whole, non negative.
 *
 *  [Answer = 233168]
 */
public class Problem1 implements NumericalProblem
{
    /**
     * Get next number divisable by <code>divisor</code> on or after given <code>number</code>
     */
    private int nextDivisableNumber(int number, int divisor)
    {
        int i = number;

        while (!NumberAnalyser.divisableBy(number, divisor)){}
        return i;
    }

    /**
     * Get all multiples of <code>multiplier</code> between <code>minRange</code> and <code>maxRange</code>
     */
    private HashSet<Integer> getMultiplesInRange(int minRange, int maxRange, int multiplier) {
        HashSet<Integer> values = new HashSet<Integer>();

        for (int i = nextDivisableNumber(minRange, multiplier); i < maxRange; i += multiplier) {
            values.add(i);
        }

        return values;
    }

    public long solution(int minRange, int maxRange)
    {
        long solution = (0);
        HashSet<Integer> values = new HashSet<Integer>();

        values.addAll(getMultiplesInRange(minRange, maxRange, 3)); //Remove duplicates
        values.addAll(getMultiplesInRange(minRange, maxRange, 5));

        for (Integer i : values)
        {
            solution += i.intValue();
        }

        return solution;
    }

    @Override
    public long solution()
    {
        return solution(0,1000);
    }
}
