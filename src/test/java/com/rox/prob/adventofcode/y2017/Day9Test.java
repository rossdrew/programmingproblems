package com.rox.prob.adventofcode.y2017;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day9Test {
    private Day9 day;

    @Before
    public void setup(){
        day = new Day9();
    }
    @Test
    public void part1Examples(){
        assertEquals(1, day.part1Solution("{}"));
        assertEquals("1 + 2 + 3 = 6.", 6, day.part1Solution("{{{}}}"));
        assertEquals("1 + 2 + 2 = 5.",5, day.part1Solution("{{},{}}"));
        assertEquals("1 + 2 + 3 + 3 + 3 + 4 = 16.",16, day.part1Solution("{{{},{},{{}}}}"));
        assertEquals(1, day.part1Solution("{<a>,<a>,<a>,<a>}"));
        assertEquals("1 + 2 + 2 + 2 + 2 = 9.", 9, day.part1Solution("{{<ab>},{<ab>},{<ab>},{<ab>}}"));
        assertEquals("1 + 2 + 2 + 2 + 2 = 9.", 9, day.part1Solution("{{<!!>},{<!!>},{<!!>},{<!!>}}"));
        assertEquals("1 + 2 = 3.", 3, day.part1Solution("{{<a!>},{<a!>},{<a!>},{<ab>}}"));

    }
}
