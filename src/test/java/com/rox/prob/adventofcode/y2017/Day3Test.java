package com.rox.prob.adventofcode.y2017;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day3Test {
    @Test
    @Ignore("Work in progress")
    public void testPart1Examples(){
        Day3 day = new Day3();
        assertEquals(0, day.solution(1));
        assertEquals(3, day.solution(12));
        assertEquals(2, day.solution(23));
        assertEquals(31, day.solution(1024));
    }

    @Test
    @Ignore("Work in progress")
    public void testBlock(){
        Day3 day = new Day3();
        assertEquals(31, day.solution(50));
    }
}
