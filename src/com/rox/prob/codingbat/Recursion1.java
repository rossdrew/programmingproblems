package com.rox.prob.codingbat;

/**
 * Basic recursion problems. Recursion strategy: first test for one or two base cases that are
 * so simple, the answer can be returned immediately. Otherwise, make a recursive a call for a
 * smaller case (that is, a case which is a step towards the base case). Assume that the
 * recursive call works correctly, and fix up what it returns to make the answer.
 */
public class Recursion1 {
    /**
     * Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. Compute
     * the result recursively (without loops).
     *
     * factorial(1) → 1
     * factorial(2) → 2
     * factorial(3) → 6
     */
    public int factorial(int n) {
        return n==0 ? 1 : (n*factorial(n-1));
    }

    /**
     * We have a number of bunnies and each bunny has two big floppy ears. We want to compute the
     * total number of ears across all the bunnies recursively (without loops or multiplication).
     *
     * bunnyEars(0) → 0
     * bunnyEars(1) → 2
     * bunnyEars(2) → 4
     */
    public int bunnyEars(int bunnies) {
        if (bunnies == 0)
        {
            return 0;
        }

        return 2 + bunnyEars(bunnies-1);
    }

    /**
     * We have triangle made of blocks. The topmost row has 1 block, the next row down has 2
     * blocks, the next row has 3 blocks, and so on. Compute recursively (no loops or
     * multiplication) the total number of blocks in such a triangle with the given number
     * of rows.
     *
     * triangle(0) → 0
     * triangle(1) → 1
     * triangle(2) → 3
     */
    public int triangle(int rows) {
        if (rows == 0)
        {
            return 0;
        }

        return rows+triangle(rows-1);
    }
}
