package com.rox.prob.euler;

import java.util.Stack;
import com.rox.prob.common.NumberAnalyser;
import com.rox.prob.NumericalProblem;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 *
 *  * Definitions:
 *
 *  Prime = Number only divisible by itself and 1
 *  Factor = A divisor of a given number
 *
 *  [Answer = 6857]
 */
public class Problem3 implements NumericalProblem {
    @Override
    public long solution()
    {
        return solution(600851475143L);
    }

    private long solution(long n)
    {
        Stack<Long> primeFactors = new Stack<>();

        long factor = 0L;
        //n : 600851475143L = 71x839x1471x6857, 1245 = 3x5x83, 30 = 2x3x5

        //Prime Factorisation
        while (n != factor && n > 1)
        {
            factor = NumberAnalyser.nextFactor(n);

            n = n / factor;

            primeFactors.push(factor);
        }

        return primeFactors.pop();
    }
}
