package com.rox.prob.adventofcode.y2017;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day6Test {
    private static final String INPUT = "0	5	10	0	11	14	13	4	11	8	8	7	1	4	12	11";

    @Test
    public void testPart1Example(){
        Day6 day = new Day6();
        assertEquals(5, day.part1Solution(new int[] {0, 2, 7, 0}));
    }

    @Test
    public void testPart1Solution(){
        Day6 day = new Day6();
        assertEquals(7864, day.part1Solution(INPUT));
    }

    @Test
    public void testPart2Solution(){
        Day6 day = new Day6();
        assertEquals(1695, day.part2Solution(INPUT));
    }
}
