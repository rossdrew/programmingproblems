package com.rox.prob.codeeval.easy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Ross on 10/09/2015.
 */
public abstract class FileLineReader {
    protected Scanner fileScanner;

    public FileLineReader(String filename)
    {
        System.out.println("Loading '" + filename + "'");
        try {
            File file = new File(filename);
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("Invalid file input.");
        }
    }

    public void start()
    {
        while (fileScanner.hasNext()) {
            loadNextLine();
            process();
        }
    }

    public abstract void loadNextLine();
    public abstract void process();
}
