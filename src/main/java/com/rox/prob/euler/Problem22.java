package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Using names.txt ('euler_p022_names.txt'), a 46K text file containing over
 * five-thousand first names, begin by sorting it into alphabetical order. Then working out the
 * alphabetical value for each name, multiply this value by its alphabetical position in the
 * list to obtain a name score.
 *
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth
 * 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 */
public class Problem22 implements NumericalProblem<BigDecimal> {
    private Scanner fileScanner;

    @Override
    public BigDecimal solution() {
        return solution("src/main/resources/euler_p022_names.txt");
    }

    public BigDecimal solution(final String filename){
        BigDecimal result = BigDecimal.ZERO;

        final Map<String, BigDecimal> sortedNames = new TreeMap<>();
        for (String name : getNames(filename)) {
            sortedNames.put(name.replaceAll("\"", "").trim(), BigDecimal.ZERO);
        }

        int nameIndex = 1;
        for (final String sortedName : sortedNames.keySet()) {
            int charSum = numericalValueSum(sortedName);

            final BigDecimal value = BigDecimal.valueOf(charSum * nameIndex++);
            sortedNames.put(sortedName, value);
            result = result.add(value);
        }

        return result;
    }

    private int numericalValueSum(final String name){
        char[] nameChars = name.toCharArray();

        int sum = IntStream.range(0, nameChars.length)
                           .map(i -> Character.getNumericValue(nameChars[i]) - 9)
                           .sum();

        return sum;
    }

    private String[] getNames(String filename) {
        try {
            File file = new File(filename);
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("Invalid file input.");
        }

        final String input = fileScanner.next();
        return input.split(",");
    }
}
