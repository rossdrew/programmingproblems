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

    @Override
    public void loadNextLine() {
        if (outputSize > 0)
        {
            currentLine = fileScanner.nextLine();
        }
        else
        {
            outputSize = Integer.parseInt(fileScanner.nextLine());
        }
    }

    @Override
    public void process() {
        List<String> fileContents = new ArrayList<String>();

        while (fileScanner.hasNext()){
            loadNextLine();
            fileContents.add(currentLine);
        }

        fileContents = bubbleSort(fileContents);

        for (int i=0; i<outputSize; i++){
            System.out.println(fileContents.get(i));
        }
    }

    /**
     * <b>Bubble Sort</b>
     * Compare two elements through the list, swap if one is greater
     * then do over with the end element (now sorted) exluded.
     * Repeat until sorted.
     */
    private List<String> bubbleSort(List<String> list){
        for (int lastIndex=list.size()-1; lastIndex >= 0; lastIndex--){
            for (int i=0; i<lastIndex; i++){
                String first = list.get(i);
                String second = list.get(i+1);

                //Swap?
                if (first.length() < second.length()){
                    list.set(i, second);
                    list.set(i+1, first);
                }
            }
        }

        return list;
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
