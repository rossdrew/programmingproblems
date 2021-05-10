package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;
import com.rox.prob.common.NumberAnalyser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28
 * is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant
 * if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as
 * the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater
 * than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced
 * any further by analysis even though it is known that the greatest number that cannot be expressed as the
 * sum of two abundant numbers is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 *
 * [Answer: 4179871]
 */
public class Problem23 implements NumericalProblem<BigDecimal> {
    @Override
    public BigDecimal solution() {
        return solution(28123);
    }

    public BigDecimal solution(final long n){
        final List<Integer> deficient = new ArrayList<>();
        final List<Integer> perfect = new ArrayList<>();
        final List<Integer> abundant = new ArrayList<>();

        for (int i=1; i<n; i++){
            final Integer sumOfDivisors = sumOfDivisors(i);
            if (sumOfDivisors < i){
                deficient.add(i);
            }else if (sumOfDivisors > i){
                abundant.add(i);
            }else{
                perfect.add(i);
            }
        }

        final List<Integer> numbers = IntStream.range(1,28123).boxed().collect(Collectors.toList());
        final Set<Integer> sums = new HashSet();

        for (int a=0; a<abundant.size()-1; a++){
            //(b=a): Any b < a has already been considered.  1+1, 1+2, 1+3. (2+1), 2+2, 2+3
            for (int b=a; a<abundant.size()-1; b++){
                int sum = abundant.get(a) + abundant.get(b);
                //b<(n-a): Any b > (n-a) is greater than n (28123) can be written as the sum of two abundant numbers, no need to check
                if (sum > n){
                    break;
                }
                sums.add(sum);
            }
        }

        numbers.removeIf(i->sums.contains(i));
        long finalSum = numbers.stream().mapToLong(i -> i).sum();

        return BigDecimal.valueOf(finalSum);
    }

    public Integer sumOfDivisors(final Integer n){
        final Integer n2 = n/2;
        Integer sum = 1;
        for (Integer i=n2; i > 1; i--){
            if (NumberAnalyser.divisableBy(n, i)){
                sum += i;
            }
        }
        return sum;
    }
}
