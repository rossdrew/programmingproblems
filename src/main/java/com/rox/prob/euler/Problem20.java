package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;

import java.math.BigDecimal;

/**
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 *
 * [Answer: 648]
 */
public class Problem20 implements NumericalProblem<BigDecimal> {
    @Override
    public BigDecimal solution() {
        return solution(100);
    }

    public BigDecimal solution(int value){
        final BigDecimal multipliedValue = stepOneSolution(BigDecimal.valueOf(value));
        return stepTwoSolution(multipliedValue);
    }

    /**
     * Return the result of adding all digits of value together
     */
    public BigDecimal stepTwoSolution(BigDecimal value){
        final BigDecimal[] valueAndRemainder = value.divideAndRemainder(BigDecimal.TEN);

        if (valueAndRemainder[0].equals(BigDecimal.ZERO))
            return value;

        return stepTwoSolution(valueAndRemainder[0]).add(valueAndRemainder[1]);
    }

    /**
     * Return the value of (value - 1) x (value - 2) ... 1
     */
    public BigDecimal stepOneSolution(BigDecimal value){
        if (value.equals(BigDecimal.ZERO))
            return BigDecimal.ONE;

        return stepOneSolution(value.subtract(BigDecimal.ONE)).multiply(value);
    }
}
