package com.rox.prob.codeeval.easy;

import com.rox.prob.common.NumberAnalyser;

/**
 * Print to stdout the largest prime palindrome less than 1000.
 *
 * [Answer : 929]
 */
public class PrimePallindrome {
    public static void main(String[] args)
    {
        for (int i=999; i>0; i--)
        {
            if (NumberAnalyser.isPrime(i) && NumberAnalyser.isPallindrome(i)) {
                System.out.println(i);
                return;
            }
        }
    }
}
