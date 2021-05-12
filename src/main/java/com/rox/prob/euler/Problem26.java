package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;

import java.math.BigDecimal;

/**
 *
 * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with
 * denominators 2 to 10 are given:
 *
 * <sup>1</sup>/<sub>2</sub>= 0.5<br/>
 * <sup>1</sup>/<sub>3</sub>= 0.(3)<br/>
 * <sup>1</sup>/<sub>4</sub>= 0.25<br/>
 * <sup>1</sup>/<sub>5</sub>= 0.2<br/>
 * <sup>1</sup>/<sub>6</sub>= 0.1(6)<br/>
 * <sup>1</sup>/<sub>7</sub>= 0.(142857)<br/>
 * <sup>1</sup>/<sub>8</sub>= 0.125<br/>
 * <sup>1</sup>/<sub>9</sub>= 0.(1)<br/>
 * <sup>1</sup>/<sub>10</sub>= 0.1<br/>
 * 
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that <sup>1</sup>/<sub>7</sub>
 * has a 6-digit recurring cycle.
 * Find the value of <i>d</i> &lt; 1000 for which <sup>1</sup>/<sub><i>d</i></sub> contains the longest recurring
 * cycle in its decimal fraction part.
 *
 */
public class Problem26 implements NumericalProblem<BigDecimal> {
    @Override
    public BigDecimal solution() {
        return solution(1000);
    }


    public BigDecimal solution(int x){
        return BigDecimal.ZERO;
    }
}
