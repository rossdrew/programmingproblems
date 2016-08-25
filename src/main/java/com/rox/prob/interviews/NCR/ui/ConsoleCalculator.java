package com.rox.prob.interviews.NCR.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.rox.prob.interviews.NCR.Expression;
import com.rox.prob.interviews.NCR.ExpressionParser;
import com.rox.prob.interviews.NCR.err.InvalidExpressionException;


/**
 * A console interface to {@link com.rox.prob.interviews.NCR.ExpressionParser ExpressionParser}
 * 
 * @author Ross W. Drew
 */
public class ConsoleCalculator 
{
	private static void displayHelp()
	{
		System.out.println("Help Menu");
		System.out.println("---------");
		System.out.println("Allowed values  \t[one | two | three | four | five | six | seven | eight | nine | zero]");
		System.out.println("Allowed ops  \t\t[plus | add] | [subtract | minus | less] | [miltiply-by | times] | [divide-by | over]");
		System.out.println("Order of precedence \tMultiply or Divide before Add or Subtract");
		
		System.out.println("\nCommands");
		System.out.println("--------");
		System.out.println("help \t This menu");
		System.out.println("exit \t Exit calculator");
	}
	
	private static String processCalculation(String calculation)
	{
		System.out.println("Processing \"" + calculation + "\"...");
		
		ExpressionParser parser = new ExpressionParser(calculation);
		
		try 
		{
			Expression expression = parser.getExpression();
			int result = expression.getValue();
			
			return "Result: " + result;
		} 
		catch (InvalidExpressionException e) 
		{
			return "Error: " + e.getMessage();
		}
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Natural Language Calculator fro NCR v0.1\n");
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		displayHelp();
		
		String calculation;
		while (true)
		{
			System.out.println("\nPlease enter calculation: ");
			
			try 
			{
				calculation = br.readLine();
				String trimmedCalculation = calculation.trim();
				
				switch (trimmedCalculation.toLowerCase())
				{
				case "help":
					displayHelp();
					break;
					
				case "exit":
					System.exit(1);
					
				default:
					System.out.println(processCalculation(calculation));				
				}
				
			} 
			catch (IOException ioe) 
			{
				System.out.println("IO error trying to read calculation!");
				System.exit(1);
			}
			
			calculation = "";
		}
	}

}
