package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation
 * of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically,
 * we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 *
 *                      012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 *
 * [Answer: 2783915460]
 */
public class Problem24 implements NumericalProblem<BigDecimal> {
    @Override
    public BigDecimal solution() {
        return solution(new int[]{0,1,2,3,4,5,6,7,8,9});
    }

    public BigDecimal solution(final int[] digits){
        final List<String> permutations = heapsPermutations(digits.length, digits);
        Collections.sort(permutations);
        return new BigDecimal(permutations.get(999999));
    }

    /**
     * Heap's Algorithm
     *
     * Generate all possible permutations of a <code>collection</code>.
     * Permutations are generated from the previous one by interchanging a single pair of elements.
     *
     * @param k starts as the length of <code>collection</code> and used in recursive calls
     * @param collection that we want permutations of
     * @return a {@link List} of {@link String} containing all permutations of <code>collection</code>
     */
    private List<String> heapsPermutations(int k, int[] collection) {
        if (k == 1) {
            final String permutation = Arrays.stream(collection).mapToObj(i -> ((Integer) i).toString()).collect(Collectors.joining());
            final ArrayList<String> permutations = new ArrayList<>();
            permutations.add(permutation);
            System.out.println("\t+" + Arrays.toString(collection));
            return permutations;
        }

        /***
         * Trying to better understand the algoritm:
         *
         * 1. recurses-1 down to k==1 and adds permutation 0
         * 	    +[1, 2, 3, 4, 5]
         * 2. back up to k==2, create permutation 1
         *      k:2 i:0 > [2, 1, 3, 4, 5]
         * 3. recurses-2 down to k-1 (1), adds permutation 1
         * 	    +[2, 1, 3, 4, 5]
         * 4. back up to k==2, exit loop and falls out of recursive frame to k==3, create permutation 2
         *      k:3 i:0 > [3, 1, 2, 4, 5]
         * 5. recurses-2 down to k-1 (2), recurses-1 down to k-1 (1), adds permutation 2
         * 	    +[3, 1, 2, 4, 5]
         * 6. back up to k==2, create permutation 3
         *      k:2 i:0 > [1, 3, 2, 4, 5]
         * 7. recurses-2 down to k-1 (1), adds permutation 3
         * 	    +[1, 3, 2, 4, 5]
         * 8. back up to k==2, exit loop falls out of recursive frame to k==3, increment i and create permutation  4      *
         *      k:3 i:1 > [2, 3, 1, 4, 5]
         * 9. recurses-2 down to k-1 (2), recurses-1 down to k-1 (1), adds permutation 4
         * 	    +[2, 3, 1, 4, 5]
         *
         * k:2 i:0 > [3, 2, 1, 4, 5]
         * 	+[3, 2, 1, 4, 5]
         * k:4 i:0 > [4, 2, 1, 3, 5]
         * 	+[4, 2, 1, 3, 5]
         */

        final List<String> permutations = heapsPermutations(k - 1, collection);
        for (int i=0; i<k-1; i++){
            swap(isEven(k) ? i : 0, k-1, collection);
            System.out.println("k:" + k + " i:" + i + " > " + Arrays.toString(collection));
            permutations.addAll(heapsPermutations(k-1, collection));
        }

        return permutations;
    }

    public static void main(String[] args){
        new Problem24().heapsPermutations(5, new int[] {1,2,3,4,5});
    }

    private boolean isEven(long n){
        return (n & 1) == 0;
    }

    /**
     * Swap items at index i & j in collection
     */
    private void swap(int i, int j, int[] collection){
        int tmp = collection[i];
        collection[i] = collection[j];
        collection[j] = tmp;
    }

    /**
     * This may work but is way too slow and therefore hard to debug, abandoned but kept for posterity.
     */
    private List<Long> permutationsV1(){
        LongStream longStream = LongStream.range(123456789L, 9876543210L).filter(i -> {
            final String a = Long.toString(i);
            final String b = Arrays.stream(a.split(""))
                    .distinct()
                    .collect(Collectors.joining());

            return a.length() == b.length();
        });

        return longStream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
