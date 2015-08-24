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

    /**
     * Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars,
     * or whatever is there if the string is less than length 3. Return n copies of the front;
     *
     * frontTimes("Chocolate", 2) → "ChoCho"
     * frontTimes("Chocolate", 3) → "ChoChoCho"
     * frontTimes("Abc", 3) → "AbcAbcAbc"
     */
    public String frontTimes(String str, int n) {
        String front = str.substring(0, (str.length() > 3 ? 3 : str.length()));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++)
        {
            sb.append(front);
        }

        return sb.toString();
    }

    /**
     * Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".
     *
     * countXX("abcxx") → 1
     * countXX("xxx") → 2
     * countXX("xxxx") → 3
     */
    int countXX(String str) {
        int count = 0;

        for (int i=0; i<str.length()-1; i++)
        {
            if (str.charAt(i) == 'x' && str.charAt(i+1) == 'x')
            {
                count++;
            }
        }

        return count;
    }

    /**
     * Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".
     *
     * doubleX("axxbb") → true
     * doubleX("axaxax") → false
     * doubleX("xxxxx") → true
     */
    boolean doubleX(String str) {
        int i = str.indexOf('x');

        //An x exists and is not the last char
        if (i >= 0 && i < str.length()-1)
        {
            return str.charAt(i+1) == 'x';
        }

        return false;
    }
}
