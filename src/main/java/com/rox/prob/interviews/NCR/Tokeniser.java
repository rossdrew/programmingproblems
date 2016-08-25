package com.rox.prob.interviews.NCR;

import com.rox.prob.interviews.NCR.err.UnknownTokenException;
import com.rox.prob.interviews.NCR.token.ExpressionToken;
import com.rox.prob.interviews.NCR.token.NonTerminalToken;
import com.rox.prob.interviews.NCR.token.Numeral;
import com.rox.prob.interviews.NCR.token.Operator;

import java.util.StringTokenizer;

public class Tokeniser 
{
	private StringTokenizer tokeniser; //Americanised spelling buffer object
	private int tokenIndex;
	
	public Tokeniser(String string)
	{
		tokeniser = new StringTokenizer(string, " ");
		tokenIndex = 0;
	}

	public ExpressionToken getNextToken() throws UnknownTokenException
	{
		String stringToken;
		if (tokeniser.hasMoreElements())
		{
			 stringToken = tokeniser.nextToken();
		}
		else
		{
			return NonTerminalToken.END;
		}
		
		String trimmedStringToken = stringToken.trim();
		
		tokenIndex++;
		
		switch (trimmedStringToken.toLowerCase())
		{
		case "one":
			return Numeral.ONE;
		case "two":
			return Numeral.TWO;
		case "three":
			return Numeral.THREE;
		case "four":
			return Numeral.FOUR;
		case "five":
			return Numeral.FIVE;
		case "six":
			return Numeral.SIX;
		case "seven":
			return Numeral.SEVEN;
		case "eight":
			return Numeral.EIGHT;
		case "nine":
			return Numeral.NINE;
		case "zero":
			return Numeral.ZERO;
			
		case "plus": 
		case "add":
			return Operator.ADDITION;
		case "subtract":
		case "minus":
		case "less":
			return Operator.SUBTRACTION;
		case "multiply-by":
		case "times":
			return Operator.MULTIPLICATION;
		case "divide-by":
		case "over":
			return Operator.DIVISION;
			
		default: 
			throw new UnknownTokenException(trimmedStringToken, tokenIndex);
		}
	}
}
