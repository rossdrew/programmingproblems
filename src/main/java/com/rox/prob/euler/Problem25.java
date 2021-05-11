package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;

import java.math.BigDecimal;

/**
 * The Fibonacci sequence is defined by the recurrence relation:
 *
 * F<sub>n</sub> = F<sub>n-1</sub> + F<sub>n-2</sub>, where F<sub>1</sub> = 1 and F<sub>2</sub> = 1.
 * Hence the first 12 terms will be:
 *
 * F<sub>1</sub> = 1 <br/>
 * F<sub>2</sub> = 1 <br/>
 * F<sub>3</sub> = 2 <br/>
 * F<sub>4</sub> = 3 <br/>
 * F<sub>5</sub> = 5 <br/>
 * F<sub>6</sub> = 8 <br/>
 * F<sub>7</sub> = 13 <br/>
 * F<sub>8</sub> = 21 <br/>
 * F<sub>9</sub> = 34 <br/>
 * F<sub>10</sub> = 55 <br/>
 * F<sub>11</sub> = 89 <br/>
 * F<sub>12</sub> = 144 <br/>
 * The 12th term, F<sub>12</sub>, is the first term to contain three digits.
 *
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 *
 * [Answer: 4782]
 */
public class Problem25 implements NumericalProblem<BigDecimal> {
    @Override
    public BigDecimal solution() {
        return solution(1000);
    }

    private class FibonacciState {
        BigDecimal x;
        BigDecimal y;
        Long index = 2L;

        FibonacciState(){
            this(BigDecimal.ONE, BigDecimal.ONE);
        }

        FibonacciState(BigDecimal x, BigDecimal y){
            this.x = x;
            this.y = y;
        }

        FibonacciState next(){
            FibonacciState fibonacciState = new FibonacciState(y, x.add(y));
            fibonacciState.index = index + 1;
            return fibonacciState;
        }
    }

    public BigDecimal solution(int digits){
        FibonacciState f = new FibonacciState();
        while(f.y.toString().length()<digits){
            f = f.next();
        }

        return new BigDecimal(f.index);
    }

    public static void main(String[] args){
        new Problem25().solution();
    }
}
