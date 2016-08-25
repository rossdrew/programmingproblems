package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;
import java.math.BigInteger;

/**
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 *
 * [Answer : 1366]
 */
public class Problem16 implements NumericalProblem<Long> {
    @Override
    public Long solution() {
        return solution(2,1000);
    }

    public Long solution(int base, int exponent) {
        BigInteger value = BigInteger.valueOf(base).pow(exponent);
        String valueString = value.toString();

        long sum = 0;
        for (int i=0; i<valueString.length(); i++) {
            int val = Character.getNumericValue(valueString.charAt(i));
            sum+=val;
        }

        return sum;
    }
}
