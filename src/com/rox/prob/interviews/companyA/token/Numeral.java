package com.rox.prob.interviews.companyA.token;


public enum Numeral implements ExpressionToken, NumeralValue
{
	ZERO(0), 
	ONE(1), 
	TWO(2), 
	THREE(3), 
	FOUR(4), 
	FIVE(5), 
	SIX(6), 
	SEVEN(7), 
	EIGHT(8), 
	NINE(9);
	
	private int numeralValue = 0;
	
	private Numeral(int numeralValue)
	{
		this.numeralValue = numeralValue;
	}
	
	@Override
	public int getValue()
	{
		return this.numeralValue;
	}
}
