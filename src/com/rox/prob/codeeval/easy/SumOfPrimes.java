package com.rox.prob.codeeval.easy;

import com.rox.prob.common.NumberAnalyser;

/**
 * Write a program which determines the sum of the first 1000 prime numbers.
 *
 * [Answer = 3682913]
 */
public class SumOfPrimes {
    public static void main(String[] args)
    {
        int n = 2;
        int count = 0;
        long sum = 0;

        while(count < 1000)
        {
            if (NumberAnalyser.isPrime(n))
            {
                System.out.println(n);
                sum += n;
                count++;
            }

            n++;
        }

        System.out.println(sum);
    }
}
