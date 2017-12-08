package com.rox.prob.adventofcode.y2017;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day8Test {
    @Test
    public void testSolution1Example(){
         Day8 day = new Day8();
         assertEquals(1, day.part1Solution( "b inc 5 if a > 1\n" +
                                                     "a inc 1 if b < 5\n" +
                                                     "c dec -10 if a >= 1\n" +
                                                     "inc -20 if c == 10"));
    }
}
