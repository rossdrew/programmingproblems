package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;

/**
 * The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
 *
 * 73167176531330624919225119674426574742355349194934
 * 96983520312774506326239578318016984801869478851843
 * 85861560789112949495459501737958331952853208805511
 * 12540698747158523863050715693290963295227443043557
 * 66896648950445244523161731856403098711121722383113
 * 62229893423380308135336276614282806444486645238749
 * 30358907296290491560440772390713810515859307960866
 * 70172427121883998797908792274921901699720888093776
 * 65727333001053367881220235421809751254540594752243
 * 52584907711670556013604839586446706324415722155397
 * 53697817977846174064955149290862569321978468622482
 * 83972241375657056057490261407972968652414535100474
 * 82166370484403199890008895243450658541227588666881
 * 16427171479924442928230863465674813919123162824586
 * 17866458359124566529476545682848912883142607690042
 * 24219022671055626321111109370544217506941658960408
 * 07198403850962455444362981230987879927244284909188
 * 84580156166097919133875499200524063689912560717606
 * 05886116467109405077541002256983155200055935729725
 * 71636269561882670428252483600823257530420752963450
 *
 * Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
 *
 * |||||> Solution is 23514624000:420752963450, I get 9781797784617:2091059712, which is wrong
 *
 * the solution is kind of like 6256932197846:235146240 but missing a few zeros!?!?
 *
 * XXX [FAIL : I cannot get this to return the correct answer]
 */
public class Problem8 implements NumericalProblem<Long> {
    @Override
    public Long solution() {
        String numberString = "73167176531330624919225119674426574742355349194934"
                            + "96983520312774506326239578318016984801869478851843"
                            + "85861560789112949495459501737958331952853208805511"
                            + "12540698747158523863050715693290963295227443043557"
                            + "66896648950445244523161731856403098711121722383113"
                            + "62229893423380308135336276614282806444486645238749"
                            + "30358907296290491560440772390713810515859307960866"
                            + "70172427121883998797908792274921901699720888093776"
                            + "65727333001053367881220235421809751254540594752243"
                            + "52584907711670556013604839586446706324415722155397"
                            + "53697817977846174064955149290862569321978468622482"
                            + "83972241375657056057490261407972968652414535100474"
                            + "82166370484403199890008895243450658541227588666881"
                            + "16427171479924442928230863465674813919123162824586"
                            + "17866458359124566529476545682848912883142607690042"
                            + "24219022671055626321111109370544217506941658960408"
                            + "07198403850962455444362981230987879927244284909188"
                            + "84580156166097919133875499200524063689912560717606"
                            + "05886116467109405077541002256983155200055935729725"
                            + "71636269561882670428252483600823257530420752963450";

        return solution(numberString, 13);
    }

    public long solution(String numberString, int snippetSize) {
        System.out.println("Working with snippet size of " + snippetSize);

        char[] characters = numberString.toCharArray();
        long product = 0; //Product of snippet of characters

        for (int i=0; i<characters.length-snippetSize; i++)
        {
            int[] numbers = extractSnippet(snippetSize, characters, i);
            int newProduct = getProduct(numbers);

            product = Math.max(product, newProduct);
        }

        return product;
    }

    private int[] extractSnippet(int snippetSize, char[] characters, int startIndex) {
        int[] numbers = new int[snippetSize];

        for (int j=0; j<snippetSize; j++)
        {
            numbers[j] = Character.getNumericValue(characters[startIndex + j]);
        }

        return numbers;
    }

    private int getProduct(int[] numbers) {
        //Calculate their product
        int newProduct = 1;
        for (int number : numbers) {
            if (number == 0)
            {
                newProduct *= 1;
                break;
            }
            newProduct *= number;
        }

        return newProduct;
    }
}
