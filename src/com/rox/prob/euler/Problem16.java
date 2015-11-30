package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;
import java.math.BigInteger;

/**
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 */
public class Problem16 implements NumericalProblem<BigInteger> {
    @Override
    public BigInteger solution() {
        return solution(2,1000);
    }

    public BigInteger solution(int base, int exponent) {
        return new BigInteger("-1");
    }
}
