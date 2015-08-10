package com.rox.problems;

import com.rox.problems.sub.NumberSet;

/**
 * The sum of the squares of the first ten natural numbers is,
 *
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 *
 * (1 + 2 + ... + 10)^2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 *
 * [Answer = 25164150]
 *
 ******
 * Optimisations?
 *
 *   - Sum of squares of natural numbers = n(n+1)(2n+1) / 6
 */
public class Problem6 implements Problem {

    @Override
    public long solution()
    {
        return solution(1, 100);
    }

    public long solution(long start, long end)
    {
        NumberSet range = NumberSet.createRangeSet(start, end);

        long squareOfSum = range.sum();
        squareOfSum *= squareOfSum;

        Long[] numbers = range.getNumbers();

        long sumOfSquares = 0;
        for (Long number : numbers)
        {
            sumOfSquares += (number * number);
        }

        return Math.abs(squareOfSum - sumOfSquares);
    }
}
