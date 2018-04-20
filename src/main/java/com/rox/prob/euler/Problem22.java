package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

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

        final String[] names = getNames(filename);

        final Map<String, BigDecimal> sortedNames = new TreeMap<>();
        for (String name : names) {
            sortedNames.put(name.replaceAll("\"", "").trim(), BigDecimal.ZERO);
        }

        int nameIndex = 1;
        for (final String sortedName : sortedNames.keySet()) {
            char[] nameChars = sortedName.toCharArray();
            int charSum = 0;
            for (char nameChar : nameChars)
                charSum += Character.getNumericValue(nameChar) - 9; // 'A' == 10

            final BigDecimal value = BigDecimal.valueOf(((long)nameIndex++) * charSum);
            sortedNames.put(sortedName, value);
            result = result.add(value);
        }

        return result;
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
