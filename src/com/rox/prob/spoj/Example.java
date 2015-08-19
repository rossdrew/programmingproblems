package com.rox.prob.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 */
public class Example {
    public void waitFor42()
    {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String input = br.readLine();
            while(input != null && input.trim() != "42"){
                System.out.println(input);
            }
        }catch(IOException io){
            io.printStackTrace();
        }
    }
}
