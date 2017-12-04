package com.rox.prob.adventofcode.y2017;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day3Test {
    @Test
    public void testPart1Solution(){
        Day3 day = new Day3();
        assertEquals(552, day.solution(325489));
    }
    @Test
    public void testPart1Examples(){
        Day3 day = new Day3();
        assertEquals(0, day.solution(1));
        assertEquals(3, day.solution(12));
        assertEquals(2, day.solution(23));
        assertEquals(31, day.solution(1024));
    }

    @Test
    public void testPart1OffCorner(){
        Day3 day = new Day3();
        assertEquals(3, day.solution(24));
        assertEquals(3, day.solution(20));
        assertEquals(3, day.solution(16));
        assertEquals(3, day.solution(12));
    }

    @Test
    public void testPart1Corners(){
        Day3 day = new Day3();
        assertEquals(4, day.solution(25));
        assertEquals(4, day.solution(21));
        assertEquals(4, day.solution(17));
        assertEquals(4, day.solution(13));
    }

    @Test
    public void testPart1Edges(){
        Day3 day = new Day3();
        assertEquals(2, day.solution(23));
        assertEquals(2, day.solution(19));
        assertEquals(2, day.solution(15));
        assertEquals(2, day.solution(11));
    }

    @Test
    public void testPart1InnerRing(){
        Day3 day = new Day3();
        assertEquals(2, day.solution(5));
        assertEquals(1, day.solution(2));
    }
}
