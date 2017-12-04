package com.rox.prob.adventofcode.y2017;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day3Test {
    @Test
    public void testPart1part1Solution(){
        Day3 day = new Day3();
        assertEquals(552, day.part1Solution(325489));
    }
    @Test
    public void testPart1Examples(){
        Day3 day = new Day3();
        assertEquals(0, day.part1Solution(1));
        assertEquals(3, day.part1Solution(12));
        assertEquals(2, day.part1Solution(23));
        assertEquals(31, day.part1Solution(1024));
    }

    @Test
    public void testPart1OffCorner(){
        Day3 day = new Day3();
        assertEquals(3, day.part1Solution(24));
        assertEquals(3, day.part1Solution(20));
        assertEquals(3, day.part1Solution(16));
        assertEquals(3, day.part1Solution(12));
    }

    @Test
    public void testPart1Corners(){
        Day3 day = new Day3();
        assertEquals(4, day.part1Solution(25));
        assertEquals(4, day.part1Solution(21));
        assertEquals(4, day.part1Solution(17));
        assertEquals(4, day.part1Solution(13));
    }

    @Test
    public void testPart1Edges(){
        Day3 day = new Day3();
        assertEquals(2, day.part1Solution(23));
        assertEquals(2, day.part1Solution(19));
        assertEquals(2, day.part1Solution(15));
        assertEquals(2, day.part1Solution(11));
    }

    @Test
    public void testPart1InnerRing(){
        Day3 day = new Day3();
        assertEquals(2, day.part1Solution(5));
        assertEquals(1, day.part1Solution(2));
    }
}
