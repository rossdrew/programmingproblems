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

    /**
     * Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
     *
     * stringBits("Hello") → "Hlo"
     * stringBits("Hi") → "H"
     * stringBits("Heeololeo") → "Hello"
     */
    public String stringBits(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<str.length(); i+=2)
        {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    /**
     * Given a non-empty string like "Code" return a string like "CCoCodCode".
     *
     * stringSplosion("Code") → "CCoCodCode"
     * stringSplosion("abc") → "aababc"
     * stringSplosion("ab") → "aab"
     */
    public String stringSplosion(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<=str.length(); i++)
        {
            sb.append(str.substring(0, i));
        }

        return sb.toString();
    }

    /**
     * Given a string, return the count of the number of times that a substring length 2 appears in the
     * string and also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).
     *
     * last2("hixxhi") → 1
     * last2("xaxxaxaxx") → 1
     * last2("axxxaaxx") → 2
     */
    public int last2(String str) {
        int count = 0;

        if (str != null && str.length() > 2) {
            String substring = str.substring(str.length() - 2);

            for (int i = 0; i < str.length() - 2; i++) {
                if (str.substring(i, i + 2).compareToIgnoreCase(substring) == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Given an array of ints, return the number of 9's in the array.
     *
     * arrayCount9({1, 2, 9}) → 1
     * arrayCount9({1, 9, 9}) → 2
     * arrayCount9({1, 9, 9, 3, 9}) → 3
     */
    public int arrayCount9(int[] nums) {
        int count=0;

        for (int i : nums)
        {
            if (i==9)
            {
                count++;
            }
        }

        return count;
    }

    /**
     * Given an array of ints, return true if one of the first 4 elements in the array is a 9.
     * The array length may be less than 4.
     *
     * arrayFront9({1, 2, 9, 3, 4}) → true
     * arrayFront9({1, 2, 3, 4, 9}) → false
     * arrayFront9({1, 2, 3, 4, 5}) → false
     */
    public boolean arrayFront9(int[] nums) {
        int length = (nums.length < 4) ? nums.length : 4;

        for (int i=0; i<length; i++)
        {
            if (nums[i] == 9) {
                return true;
            }
        }

        return false;
    }

}
