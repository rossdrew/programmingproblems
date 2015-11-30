package com.rox.prob.interviews.NCR;

import com.rox.prob.interviews.NCR.token.*;

/**
 * Essentially a basic tree data structure representing an expression which 
 * can evaluate all sub {@link com.rox.prob.interviews.NCR.token.NumeralValue NumeralValues} and
 * {@link com.rox.prob.interviews.NCR.Expression Expressions} ergo, itself via <tt>getValue()</tt>
 * 
 * @author Ross W. Drew
 *
 */
public class Expression implements NumeralValue, ExpressionToken
{
	private NumeralValue firstNumeral, secondNumeral;
	private Operator operator;
	
	public Expression(NumeralValue n1, Operator o, NumeralValue n2)
	{
		this.firstNumeral = n1;
		this.operator = o;
		this.secondNumeral = n2;
	}

	@Override
	public int getValue() 
	{
		switch (operator)
		{
		case ADDITION:
			return firstNumeral.getValue() + secondNumeral.getValue();
		case SUBTRACTION:
			return firstNumeral.getValue() - secondNumeral.getValue();
		case DIVISION:
			int val = secondNumeral.getValue();
			if (val == 0)
				return 0;
			else
				return firstNumeral.getValue() / val;
		case MULTIPLICATION:
			return firstNumeral.getValue() * secondNumeral.getValue();
			
		default:
			return 0;
		}
	}
}
