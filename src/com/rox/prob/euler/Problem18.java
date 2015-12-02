package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;
import com.rox.prob.common.struct.Graph;
import com.rox.prob.common.struct.Vertice;

import java.util.Scanner;
import java.util.Vector;

/**
 * By starting at the top of the triangle below and moving to adjacent numbers on
 * the row below, the maximum total from top to bottom is 23.
 *
 *    3
 *   7 4
 *  2 4 6
 * 8 5 9 3
 *
 * That is, 3 + 7 + 4 + 9 = 23.
 *
 * Find the maximum total from top to bottom of the triangle below:
 *
 *               75
 *              95 64
 *             17 47 82
 *            18 35 87 10
 *           20 04 82 47 65
 *          19 01 23 75 03 34
 *         88 02 77 73 07 63 67
 *        99 65 04 28 06 16 70 92
 *       41 41 26 56 83 40 80 70 33
 *      41 48 72 33 47 32 37 16 94 29
 *     53 71 44 65 25 43 91 52 97 51 14
 *    70 11 33 28 77 73 17 78 39 68 17 57
 *   91 71 52 38 17 14 91 43 58 50 27 29 48
 *  63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 *
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by
 * trying every route. However, Problem 67, is the same challenge with a triangle
 * containing one-hundred rows; it cannot be solved by brute force, and requires
 * a clever method! ;o)
 */
public class Problem18 implements NumericalProblem<Long> {
    private String triangleDefinition = "75\n" +
                                        "95 64\n" +
                                        "17 47 82\n" +
                                        "18 35 87 10\n" +
                                        "20 04 82 47 65\n" +
                                        "19 01 23 75 03 34\n" +
                                        "88 02 77 73 07 63 67\n" +
                                        "99 65 04 28 06 16 70 92\n" +
                                        "41 41 26 56 83 40 80 70 33\n" +
                                        "41 48 72 33 47 32 37 16 94 29\n" +
                                        "53 71 44 65 25 43 91 52 97 51 14\n" +
                                        "70 11 33 28 77 73 17 78 39 68 17 57\n" +
                                        "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
                                        "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
                                        "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

    @Override
    public Long solution() {
        return solution(triangleDefinition);
    }

    public Long solution(String triangleDefinition){
        Scanner defScanner = new Scanner(triangleDefinition);

        Graph<Integer, Integer> triangle = buildTriangleGraph(defScanner);

        return solution(triangle);
    }

    private Graph<Integer, Integer> buildTriangleGraph(Scanner defScanner) {
        Graph<Integer, Integer> triangle = new Graph<>();
        Vertice<Integer, Integer>[] previousRow = null;
        Vertice<Integer, Integer>[] currentRow = null;

        int row = 1;
        while (defScanner.hasNext()){
            currentRow = new Vertice[row];
            previousRow = compileTriangleGraphRow(defScanner, triangle, previousRow, currentRow, row);
            row++;
        }
        return triangle;
    }

    private Vertice<Integer, Integer>[] compileTriangleGraphRow(Scanner defScanner,
                                                                Graph<Integer, Integer> triangle,
                                                                Vertice<Integer, Integer>[] previousRow,
                                                                Vertice<Integer, Integer>[] currentRow,
                                                                int row) {
        int id = 0;
        for (int col = 0; col < row && defScanner.hasNext(); col++){
            int s = defScanner.nextInt();
            currentRow[col] = triangle.addVertice(id++, s);

            //start connecting on the second row
            if (row > 1) {
                if (col > 0) {
                    triangle.addVector(previousRow[col - 1], currentRow[col]);
                }

                if (col < row-1) {
                    triangle.addVector(previousRow[col], currentRow[col]);
                }
            };
        }

        return currentRow;
    }

    public Long solution(Graph triangle){
        Vertice<Integer,Integer> root = triangle.getRootNode();

        System.out.println(root.getValue());

        return -1l;
    }
}
