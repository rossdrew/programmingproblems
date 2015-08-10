package com.rox.problems;

import com.rox.problems.sub.NumberAnalyser;

import java.util.ArrayList;
import java.util.List;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * Definitions:
 *
 *  GCD (Greatest Common Divisor)
 *  HCF (Highest Common Factor) = The highest factor common to all given numbers
 *                              > multiply ALL COMMON factors together from two numbers
 *  LCM (Lowest Common Multiple) = The lowest number which is a multiple of all given numbers
 *                               > multiply ALL factors together from two numbers
 *
 *  [Answer = 232792560]
 */
public class Problem5 implements Problem {
    @Override
    public long solution() {
        return solution(1, 20);
    }

    private long solution(long start, long finish)
    {
        List<Long> numbers = new ArrayList<>();

        for (long i = start; i <= finish; i++)
        {
            numbers.add(i);
        }

        Long[] n = new Long[numbers.size()];
        n = numbers.toArray(n);
        return NumberAnalyser.lowestCommonMultiple(n);
    }
}
