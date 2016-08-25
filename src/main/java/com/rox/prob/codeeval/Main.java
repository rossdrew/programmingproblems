package com.rox.prob.codeeval;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CodeEval Template
 */
public class Main {
    protected Scanner fileScanner;
    int outputSize = 0;
    String currentLine = null;

    public Main(String filename)
    {
        System.out.println("Loading '" + filename + "'");
        try {
            File file = new File(filename);
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("Invalid file input.");
        }
    }

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

    public void start()
    {
        while (fileScanner.hasNext()) {
            loadNextLine();
            process();
        }
    }

    public static void main (String[] args) throws IOException {
        Main problem = new Main("resources/codeeval.moderate.longestLines.txt");
        problem.start();
    }
}
