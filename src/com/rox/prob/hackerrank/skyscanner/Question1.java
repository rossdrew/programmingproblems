package com.rox.prob.hackerrank.skyscanner;

import com.rox.prob.StringProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Top Search Term
 * -Bad formatting due to HackerRanks ugly online interface restrictions-   
 *
 * Input a number to standard out which defines the number of  following inputs.
 * Then a series of destinations as "search terms".
 *
 * Output is the top searched destination.
 *
 * XXX Change to an ordered list, change to deal with stin rather than fixed values
 */
public class Question1 implements StringProblem {
    public String solution()
    {
        Map<String, Integer> destinations = new HashMap<>();

        int count = 5;
        Scanner input = new Scanner("one two three two two");

        for (int i=0; i<count; i++)
        {
            String destination = input.next();

            //Create search term or increment its count if it has been searched before
            if (destinations.containsKey(destination)) {
                destinations.put(destination, destinations.get(destination) + 1);
            } else {
                destinations.put(destination, 1);
            }
        }

        String topSearch = null;
        for (String key : destinations.keySet())
        {
            if (topSearch==null || destinations.get(key) > destinations.get(topSearch))
            {
                topSearch = key;
            }
        }

        return topSearch;
    }
}
