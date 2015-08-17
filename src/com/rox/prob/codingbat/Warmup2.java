package com.rox.prob.codingbat;

/**
 * Medium warmup string/array loops from CodingBat.
 *
 * Problems are tiny, two minute things so I wont be properly
 * splitting them into submmethods such as inRange()
 *
 * http://codingbat.com/java/Warmup-1
 */
public class Warmup2 {
    /**
     * Given a string and a non-negative int n, return a larger string that is n copies of the original string.
     *
     * stringTimes("Hi", 2) → "HiHi"
     * stringTimes("Hi", 3) → "HiHiHi"
     * stringTimes("Hi", 1) → "Hi"
     */
    public String stringTimes(String str, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++)
        {
            sb.append(str);
        }

        return sb.toString();
    }
}
