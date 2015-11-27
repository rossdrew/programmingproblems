package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;

/**
 * Starting in the top left corner of a 2×2 grid, and only being able
 * to move to the right and down, there are exactly 6 routes to the
 * bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 *
 */
public class Problem15 implements NumericalProblem<Integer>{
    @Override
    public Integer solution() {
        return solution(20);
    }

    public Integer solution(int squareSize){
        
        return -1;
    }
}
