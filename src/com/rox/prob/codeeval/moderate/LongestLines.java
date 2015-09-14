package com.rox.prob.codeeval.moderate;

import com.rox.prob.codeeval.easy.FileLineReader;

import java.util.ArrayList;
import java.util.List;

/**
 *  Write a program which reads a file and prints to stdout the specified number
 *  of the longest lines that are sorted based on their length in descending
 *  order.
 * Input sample:
 *
 * Your program should accept a path to a file as its first argument. The file
 * contains multiple lines. The first line indicates the number of lines you
 * should output, the other lines are of different length and are presented
 * randomly. You may assume that the input file is formatted correctly and the
 * number in the first line is a valid positive integer.
 *
 * For example:
 *   2
 *   Hello World
 *   CodeEval
 *   Quick Fox
 *   A
 *   San Francisco
 *
 * Output sample:
 *
 * Print out the longest lines limited by specified number and sorted by their
 * length in descending order.
 *
 * For example:
 *   San Francisco
 *   Hello World
 */
public class LongestLines extends FileLineReader{
    int outputSize = 0;
    String currentLine = null;
    String [] topRankingLines;

    @Override
    public void loadNextLine() {
        currentLine = fileScanner.nextLine();
    }

    @Override
    public void process() {
        while (fileScanner.hasNext()){
            loadNextLine();

            if (outputSize == 0){
                outputSize = Integer.parseInt(currentLine);
                topRankingLines = new String[outputSize];
            }else{
                rankLine();
            }
        }

        for (String line : topRankingLines){
            System.out.println(line);
        }
    }

    private void rankLine(){
        String tmp;
        String entry = currentLine;

        for (int i=0; i<topRankingLines.length; i++){
            if (topRankingLines[i] == null || entry.length() > topRankingLines[i].length()){
                tmp = topRankingLines[i];
                topRankingLines[i] = entry;
                entry = tmp;
            }
        }
    }

    public LongestLines(String filename){
        super(filename);
    }

    public static void main(String[] args)
    {
        LongestLines problem = new LongestLines("resources/codeeval.moderate.longestLines.txt");
        problem.start();
    }
}
