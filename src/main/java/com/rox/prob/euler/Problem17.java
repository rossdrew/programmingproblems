package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;

/**
 * If the numbers 1 to 5 are written out in words:
 *   one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive
 * were written out in words, how many letters would be used?
 *
 * NOTE: Do not count spaces or hyphens. For example, 342
 * (three hundred and forty-two) contains 23 letters and 115
 * (one hundred and fifteen) contains 20 letters. The use of
 * "and" when writing out numbers is in compliance with
 * British usage.
 */
public class Problem17 implements NumericalProblem<Long>{
    private String[] numberals = {"","one","two","three","four","five","six","seven","eight","nine","ten","eleven"};
    private String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private String[] tens = {"", "ten", "twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    private String[] placePostfix = {"", "XXX", "hundred", "thousand"};

    @Override
    public Long solution() {
        return solution(1000);
    }

    /**
     * Brute force solution seems to work in acceptable time
     *
     * XXX could most likely be optimised
     */
    public Long solution(int limit){
        long sum=0;
        for (int i=1; i<=1000; i++){
            int letters = getLetterCountIn(i);
            sum+=letters;
        }
        return sum;
    }

    private int getLetterCountIn(int number){
        int digits = (int)(Math.log10(number)+1);

        StringBuilder numberAsString = new StringBuilder();
        int digitQueue = number;
        for (int i=0; i<digits; i++){
            String newString = "";
            if (i==0 && (digitQueue % 100 / 10)==1) {
                newString = (digits > 2 ? " and " : "") + teens[digitQueue % 10];
                i = 1;
                digitQueue = digitQueue / 100;
            }else if (i==1) {
                int thisDigit = digitQueue%10;
                newString = thisDigit > 0 ? ((digits > 2 ? " and " : "") + tens[thisDigit] + " ") : "";
                digitQueue = digitQueue / 10;
            }else if (i>1){
                int thisDigit = digitQueue%10;
                newString = thisDigit > 0 ? (numberals[thisDigit] + " " + placePostfix[i]) : "";
                digitQueue = digitQueue / 10;
            }else{
                int thisDigit = digitQueue%10;
                if (thisDigit > 0)

                    newString = ((digits>1 && ((digitQueue %100/10)==0)) ? " and " : "") + numberals[thisDigit];
                digitQueue = digitQueue / 10;
            }

            numberAsString.insert(0, newString);
        }

        return numberAsString.toString().replaceAll(" ","").length();

    }
}
