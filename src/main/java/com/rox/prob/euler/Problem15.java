package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;
import com.rox.prob.common.struct.Graph;
import com.rox.prob.common.struct.Vertice;

/**
 * Starting in the top left corner of a 2×2 grid, and only being able
 * to move to the right and down, there are exactly 6 routes to the
 * bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 *
 * [Answer : 407575348]
 */
public class Problem15 implements NumericalProblem<Long>{
    @Override
    public Long solution() {
        return solution(20);
    }

    /**
     * Dynamic programming solution O(mn)
     * ----------------------------------
     * At every point in the square there will be x routes to the end.
     * Starting at the top left edge of the bottom right square this is 2,
     * which happens to be a sum of the bottom left edge and the top right edge.
     * This is true for all sub squares in the grid.  All other points can be
     * calculated from this and knowing all left and bottom edge squares have
     * only one route.
     */
    public Long solution(int squareSize){
        long[][] square = new long[squareSize+1][squareSize+1];

        for (int x=0; x <= squareSize; x++){
            for (int y=0; y <= squareSize; y++){
                if (x == 0 || y == 0){
                    square[x][y] = 1;
                }else{
                    square[x][y] = square[x][y-1] + square[x-1][y];
                }
            }
        }

        return square[squareSize][squareSize];
    }
}
