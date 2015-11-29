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
public class Problem15 implements NumericalProblem<Integer>{
    @Override
    public Integer solution() {
        return solution(10);
    }

    public Integer solution(int squareSize){
        int[][] square = new int[squareSize+1][squareSize+1];

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
