package com.rox.prob.adventofcode.y2017;

/**
 * --- Day 3: Spiral Memory ---
 *
 * You come across an experimental new kind of memory stored on an infinite two-dimensional grid.
 *
 * Each square on the grid is allocated in a spiral pattern starting at a location marked 1 and then counting up while
 * spiraling outward. For example, the first few squares are allocated like this:
 *
 * 17  16  15  14  13
 * 18   5   4   3  12
 * 19   6   1   2  11
 * 20   7   8   9  10
 * 21  22  23---> ...
 *
 *  While this is very space-efficient (no squares are skipped), requested data must be carried back to square 1 (the
 *  location of the only access port for this memory system) by programs that can only move up, down, left, or right.
 *  They always take the shortest path: the Manhattan Distance between the location of the data and square 1.
 *
 * For example:
 *
 * Data from square 1 is carried 0 steps, since it's at the access port.
 * Data from square 12 is carried 3 steps, such as: down, left, left.
 * Data from square 23 is carried only 2 steps: up twice.
 * Data from square 1024 must be carried 31 steps.
 *
 * How many steps are required to carry the data from the square identified in your puzzle input all the way to the
 * access port?
 *
 * Your puzzle input is 325489.
 * Your puzzle answer was 552.
 *
 * --- Part Two ---
 *
 * As a stress test on the system, the programs here clear the grid and then store the value 1 in square 1. Then, in the
 * same allocation order as shown above, they store the sum of the values in all adjacent squares, including diagonals.
 *
 * So, the first few squares' values are chosen as follows:
 *
 * Square 1 starts with the value 1.
 * Square 2 has only one adjacent filled square (with value 1), so it also stores 1.
 * Square 3 has both of the above squares as neighbors and stores the sum of their values, 2.
 * Square 4 has all three of the aforementioned squares as neighbors and stores the sum of their values, 4.
 * Square 5 only has the first and fourth squares as neighbors, so it gets the value 5.
 * Once a square is written, its value does not change. Therefore, the first few squares would receive the following
 * values:
 *
 * 147  142  133  122   59
 * 304    5    4    2   57
 * 330   10    1    1   54
 * 351   11   23   25   26
 * 362  747  806--->   ...
 *  What is the first value written that is larger than your puzzle input?
 *
 *  Your puzzle input is still 325489.
 *
 */
public class Day3 {
    /**
     * - Find the nth odd square above our number (the spiral ceiling)
     * - Step back along the spiral to the given cellNumber, creating a square
     * - Find the manhattan distance from the centre of the created square (cell 1) to the cellNumber
     */
    public long part1Solution(int cellNumber){
        if (cellNumber == 1)
            return 0;

        /** Which ring of the spiral we are on (1,3,5,7...), also the size of the arm */
        int spiralValue = 1;
        /** The ceiling of the ring (highest value) */
        int spiralCeiling = 1;

        while (spiralCeiling < cellNumber){
            while (++spiralValue % 2 == 0){}//Next odd number
            spiralCeiling = spiralValue * spiralValue;
        }

        int stepsAroundToCell = spiralCeiling - cellNumber;
        int stepsAlongArm = stepsAroundToCell % (spiralValue-1);
        int armNumber = stepsAroundToCell / (spiralValue-1);

        //System.out.println("f(" + cellNumber + ") -> " + spiralValue + "x" + spiralValue + "=" + spiralCeiling + "\t armLength="+spiralValue + "\t Directions (" + stepsAroundToCell + " steps) = arm: " + armNumber + ", stepsAlongArm = " + stepsAlongArm);

        //get the offset from cell spiralIndex X spiralIndex
        int x = spiralValue-1;
        int y = spiralValue-1;
        switch (armNumber){
            case 0: //bottom arm
                System.out.println("Bottom arm...");
                x -= stepsAlongArm;
                break;

            case 1: //left arm
                System.out.println("Left arm...");
                x -= (spiralValue-1);
                y -= (stepsAlongArm);
                break;

            case 2: //top arm
                System.out.println("Top arm...");
                x += (stepsAlongArm-(spiralValue-1));
                y -= ((spiralValue-1));
                break;

            case 3: //right arm
                System.out.println("Right arm...");
                y += (stepsAlongArm-(spiralValue-1));
                break;
        }
        //System.out.println("Offset Calculated as (" + y + ", " + x + ") for " + cellNumber);

        int sourceX = spiralValue / 2;
        int sourceY = spiralValue / 2;

        //manhattan distance between offset from ceiling and source
        int xDistance = (sourceX > x) ? (sourceX - x) : (x - sourceX);
        int yDistance = (sourceY > y) ? (sourceY - y) : (y - sourceY);
        int manhattanDistance = xDistance+yDistance;

        //System.out.println("Distance from (" + sourceY + "," + sourceX + ") is (" + yDistance + ", " + xDistance + ") -> " + manhattanDistance);

        return manhattanDistance;
    }

    public long part2Solution(){
        //TODO
        return -1;
    }

}
