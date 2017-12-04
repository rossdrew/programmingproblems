package com.rox.prob.adventofcode.y2017;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Day4Test {
    @Test
    public void testPart1Example(){
        Day4 day = new Day4();
        assertTrue(day.validPassphrase("aa bb cc dd ee"));
        assertFalse(day.validPassphrase("aa bb cc dd aa"));
        assertTrue(day.validPassphrase("aa bb cc dd aaa"));
    }
}
