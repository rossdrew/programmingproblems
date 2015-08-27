package com.rox.prob.sub;

/**
 * Class for analysing numbers
 *
 * XXX Could be made into non-utility method by creating an instance
 *     for number in question then running queries on it
 */
public class NumberAnalyser
{
    /**
     * Is <code>number</code> divisable by <code>divisor</code>
     */
    public static boolean divisableBy(long number, long divisor)
    {
        return (number % divisor == 0);
    }

    /**
     * Return lowest factor of given number
     */
    public static long nextFactor(long n)
    {
        long factorSearchLimit = n / 2;

        for (long divisor = 2; divisor <= factorSearchLimit; divisor++)
        {
            //if n is divisible by divisor then divisor is a factor of n
            if (n % divisor == 0)
            {
                return divisor;
            }
        }

        return n;
    }

    public static boolean isPrime(long n)
    {
        long min = 2;
        double max = Math.sqrt((double)n);

        for (long i=min; i<=max; i++)
        {
            if (divisableBy(n, i))
            {
                return false;
            }
        }

        return true;
    }
}
