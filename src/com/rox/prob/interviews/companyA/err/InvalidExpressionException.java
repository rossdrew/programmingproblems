package com.rox.prob.interviews.companyA.err;

public class InvalidExpressionException extends Exception 
{
	public InvalidExpressionException(String expression)
	{
		super("Invalid expression '" + expression + "'");
	}
	
	public InvalidExpressionException(String expression, String additionalInformation)
	{
		super("Invalid expression '" + expression + "' " + additionalInformation);
	}
}
