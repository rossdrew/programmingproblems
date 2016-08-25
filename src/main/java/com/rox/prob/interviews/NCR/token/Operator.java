package com.rox.prob.interviews.NCR.token;


public enum Operator implements ExpressionToken
{
	ADDITION(1),
	SUBTRACTION(1),
	MULTIPLICATION(2),
	DIVISION(2);

	private int ordinalValue = 1;
	
	private Operator(int ordinalValue)
	{
		this.ordinalValue = ordinalValue;
	}
	
	public int getOrdinalValue()
	{
		return ordinalValue;
	}
	
	public boolean higherPrecedenceThan(Operator o)
	{
		return this.ordinalValue > o.ordinalValue;
	}
}
