package com.rox.prob.adventofcode.y2017;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day7Test {
    private static final String INPUT = "pbga (66)\n"+
                                        "xhth (57)\n"+
                                        "ebii (61)\n"+
                                        "havc (66)\n"+
                                        "ktlj (57)\n"+
                                        "fwft (72) -> ktlj, cntj, xhth\n"+
                                        "qoyq (66)\n"+
                                        "padx (45) -> pbga, havc, qoyq\n"+
                                        "tknk (41) -> ugml, padx, fwft\n"+
                                        "jptl (61)\n"+
                                        "ugml (68) -> gyxo, ebii, jptl\n"+
                                        "gyxo (61)\n"+
                                        "cntj (57)";
    @Test
    public void testPart1Example(){
        Day7 day = new Day7();
        assertEquals("tknk", day.part1Solution(INPUT));
    }
}
