package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;

import java.util.HashMap;

/**
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 *
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains
 * 10 terms. Although it has not been proved yet (Collatz Problem), it is thought
 * that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 *
 * [Answer : 837799]
 */
public class Problem14 implements NumericalProblem<Long> {
    private HashMap<Long, Long> solvedTermSources = new HashMap<>();

    @Override
    public Long solution() {
        return solution(1000000);
    }

    public long solution(long limit){
        long highestTermSource = 1;
        long highestTerms = 1;

        for (int i=1; i<=limit; i++){
            long termCount = collatzConjectureTerms(i);
            if (termCount > highestTerms){
                highestTerms = termCount;
                highestTermSource = i;
            }
        }

        return highestTermSource;
    }

    private long collatzConjectureTerms(long start){
        if (start == 1){
            return 1;
        }

        if (solvedTermSources.containsKey(start)){
            return solvedTermSources.get(start);
        }

        long modifiedNumber = isEven(start) ? (start / 2) : ((start * 3) + 1);
        long terms = collatzConjectureTerms(modifiedNumber);

        solvedTermSources.put(start, terms);

        return 1 + terms;
    }

    private boolean isEven(long n){
        return (n & 1) == 0;
    }
}
