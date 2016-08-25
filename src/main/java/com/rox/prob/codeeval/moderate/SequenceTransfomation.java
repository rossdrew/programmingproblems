package com.rox.prob.codeeval.moderate;

import com.rox.prob.codeeval.easy.FileLineReader;

import java.util.Scanner;

/**
 * Sequence Transformation
 *
 * Challenge Description:
 *
 * There are two sequences. The first sequence consists of digits
 * "0" and "1", the second one consists of letters "A" and "B". The
 * challenge is to determine whether it's possible to transform a
 * given binary sequence into a string sequence using the following
 * rules:
 * 1. "0" can be transformed into non empty sequence of letters "A" ("A", "AA", "AAA" etc.)
 * 2. "1" can be transformed into non empty sequence of letters "A" ("A", "AA", "AAA" etc.)
 *    or to non empty sequence of letters "B" ("B", "BB", "BBB" etc) e.g.
 *
 * Input sample:
 *
 * Your program should accept as its first argument a path to a filename. Each line in this
 * file contains a binary sequence and a sequence of letters "A" and "B" separated by a
 * single whitespace. E.g.
 *   1010 AAAAABBBBAAAA
 *   00 AAAAAA
 *   01001110 AAAABAAABBBBBBAAAAAAA
 *   1100110 BBAABABBA
 *
 * Output sample:
 *
 * For each test case print out "Yes" if the transformation is possible, otherwise print
 * "No". E.g.
 *
 *   Yes
 *   Yes
 *   Yes
 *   No
 *
 * Constraints:
 *  The length of a binary sequence is in range [1, 150]
 *  The length of a string sequence is in range [1, 1000]
 *  The number of test cases is <= 50
 */
public class SequenceTransfomation extends FileLineReader{
    private String currentLine;

    SequenceTransfomation(String file){
        super(file);
    }

    @Override
    public void loadNextLine() {
        currentLine = fileScanner.nextLine();
    }

    @Override
    public void process() {
        while (fileScanner.hasNext()){
            loadNextLine();
            parseSequence();
        }
    }

    private void parseSequence() {
        Scanner lineScanner = new Scanner(currentLine);

        //Create a Regex from the binary and simply compare it
        String binary = lineScanner.next();
        binary = binary.replace("0", "A+");
        binary = binary.replace("1", "(A+|B+)");

        String sequence = lineScanner.next();

        System.out.println(sequence.matches(binary));
    }

    public static void main(String[] args){
        SequenceTransfomation problem = new SequenceTransfomation("resources/codeeval.moderate.sequenceTransformation.txt");
        problem.start();
    }
}
