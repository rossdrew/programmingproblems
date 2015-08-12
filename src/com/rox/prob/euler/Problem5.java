package com.rox.prob.euler;

import com.rox.prob.euler.sub.NumberSet;
import com.rox.prob.NumericalProblem;

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
public class Problem5 implements NumericalProblem {
    @Override
    public long solution() {
        return solution(1, 20);
    }

    private long solution(long start, long finish)
    {
        NumberSet numberSet = NumberSet.createRangeSet(start, finish);

        return numberSet.lowestCommonMultiple();
    }
}
