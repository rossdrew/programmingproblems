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
            return permutations;
        }

        final List<String> permutations = heapsPermutations(k - 1, collection);
        for (int i=0; i<k-1; i++){
            if (k%2==0){
                swap(i, k-1, collection);
            }else{
                swap(0, k-1, collection);
            }
            permutations.addAll(heapsPermutations(k-1, collection));
        }

        return permutations;
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
