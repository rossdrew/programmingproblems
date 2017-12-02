package com.rox.prob.adventofcode.y2017;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Ross W. Drew
 */
public class Day2Test {
    @Test
    public void testExample(){
        int[][] speadsheet = new int[][] {{5,1,9,5},
                                          {7,5,3},
                                          {2,4,6,8}};
        assertEquals(18, Day2.solution(speadsheet));
    }
}
