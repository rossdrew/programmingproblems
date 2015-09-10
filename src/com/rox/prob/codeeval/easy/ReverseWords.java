package com.rox.prob.codeeval.easy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Input sample:
 *
 *The first argument is a file that contains multiple sentences, one per line.
 * Empty lines are also possible.
 *
 *For example:
 *  Hello World
 *  Hello CodeEval
 *
 *Output sample:
 *
 *Print to stdout each sentence with the reversed words in it, one per line.
 * Empty lines in the input should be ignored. Ensure that there are no
 * trailing empty spaces in each line you print.
 *
 *For example:
 *  World Hello
 *  CodeEval Hello
 *
 *  TODO need to add common CodeEVal boiler plater class
 */
public class ReverseWords {
    private Scanner fileScanner;
    private String currentLine;

    public ReverseWords(String filename)
    {
        try {
            File file = new File(filename);
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("Invalid file input.");
        }
    }

    private void loadNextLine()
    {
        currentLine = fileScanner.nextLine();
    }

    public void start()
    {
        while (fileScanner.hasNext()) {
            loadNextLine();
            String output = reverseWords();
            System.out.println(output);
        }
    }

    private String reverseWords() {
        Scanner lineScanner = new Scanner(currentLine);
        StringBuilder sb = new StringBuilder();

        while (lineScanner.hasNext())
        {
            sb.insert(0, lineScanner.next() + " ");
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        ReverseWords problem = new ReverseWords("resources/codeeval.easy.reverseWords.txt");
        problem.start();
    }
}
