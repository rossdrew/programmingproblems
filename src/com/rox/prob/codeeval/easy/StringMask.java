package com.rox.prob.codeeval.easy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * String mask
 *
 * Challenge Description:
 *
 * You’ve got a binary code which has to be buried among words in order to unconsciously pass the cipher.
 * Create a program that would cover the word with a binary mask. If, while covering, a letter finds
 * itself as 1, you have to change its register to the upper one, if it’s 0, leave it as it is. Words are
 * always in lower case and in the same row with the binary mask.
 * Input sample:
 *
 * The first argument is a path to a file. Each row contains a test case with a word and a binary code
 * separated with space, inside of it. The length of each word is equal to the length of the binary code.
 *
 * For example:
 *  hello 11001
 *  world 10000
 *  cba 111
 *
 * Output sample:
 *  HEllO
 *  World
 *  CBA
 *
 * Print the encrypted words without binary code.
 *
 * For example:
 *
 * Constraints:
 *
 * Words are from 1 to 20 letters long.
 * The number of test cases is 40.
 *
 */
public class StringMask {
    Scanner fileScanner;

    String word;
    String mask;

    public StringMask(String filename)
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
        word = fileScanner.next();
        mask = fileScanner.next();
    }

    public void start()
    {
        while (fileScanner.hasNext()) {
            loadNextLine();
            System.out.println(word + " " + mask);
            String maskedWord = maskWord(word, mask);
            System.out.println(maskedWord);
        }
    }

    private String maskWord(String word, String mask) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<word.length(); i++)
        {
            if (mask.charAt(i) == '1')
            {
                sb.append(Character.toUpperCase(word.charAt(i)));
            }
            else
            {
                sb.append(word.charAt(i));
            }

        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        StringMask m = new StringMask("resources/codeeval.easy.stringmask.txt");
        m.start();
    }
}
