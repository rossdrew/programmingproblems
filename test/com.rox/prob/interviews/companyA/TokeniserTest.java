package com.rox.prob.interviews.companyA;

import com.rox.prob.interviews.companyA.token.ExpressionToken;
import com.rox.prob.interviews.companyA.token.NonTerminalToken;
import com.rox.prob.interviews.companyA.token.Numeral;
import com.rox.prob.interviews.companyA.token.Operator;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public class TokeniserTest 
{
	private Tokeniser tokeniser;
	private ExpressionToken token;
	
	@Test
	public void testLowerCaseNumeralParsing() throws Exception
	{
		tokeniser = new Tokeniser("One");
		token = tokeniser.getNextToken();
		assertEquals(Numeral.ONE, token);
	}

	@Test
	public void testUpperCaseNumeralParsing() throws Exception
	{	
		tokeniser = new Tokeniser("TWO");
		token = tokeniser.getNextToken();
		assertEquals(Numeral.TWO, token);		
	}
	
	@Test
	public void testVariedCaseNumeralParsing() throws Exception
	{	
		tokeniser = new Tokeniser("SeVeN");
		token = tokeniser.getNextToken();
		assertEquals(Numeral.SEVEN, token);		
	}
	
	@Test
	public void testMultipleNumeralParsing() throws Exception
	{		
		tokeniser = new Tokeniser("one two three four five six seven eight nine zero");
		
		assertEquals(Numeral.ONE, tokeniser.getNextToken());
		assertEquals(Numeral.TWO, tokeniser.getNextToken());
		assertEquals(Numeral.THREE, tokeniser.getNextToken());
		assertEquals(Numeral.FOUR, tokeniser.getNextToken());
		assertEquals(Numeral.FIVE, tokeniser.getNextToken());
		assertEquals(Numeral.SIX, tokeniser.getNextToken());
		assertEquals(Numeral.SEVEN, tokeniser.getNextToken());
		assertEquals(Numeral.EIGHT, tokeniser.getNextToken());
		assertEquals(Numeral.NINE, tokeniser.getNextToken());
		assertEquals(Numeral.ZERO, tokeniser.getNextToken());
		
		try
		{
			tokeniser.getNextToken();
			assertEquals(tokeniser.getNextToken(), NonTerminalToken.END);
			tokeniser.getNextToken();
		}
		catch(NoSuchElementException e) {}
	}
	
	@Test
	public void testOperatorParsing() throws Exception
	{	
		tokeniser = new Tokeniser("plus");
		token = tokeniser.getNextToken();
		assertEquals(Operator.ADDITION, token);
	}
	
	@Test
	public void testDuplicateNameOperatorParsing() throws Exception
	{	
		tokeniser = new Tokeniser("ADD");
		token = tokeniser.getNextToken();
		Assert.assertEquals(Operator.ADDITION, token);
	}
	
	@Test
	public void testMultipleOperatorParsing() throws Exception
	{		
		tokeniser = new Tokeniser("add plus subtract minus less multiply-by times divide-by over");
		
		assertEquals(Operator.ADDITION, tokeniser.getNextToken());
		assertEquals(Operator.ADDITION, tokeniser.getNextToken());
		assertEquals(Operator.SUBTRACTION, tokeniser.getNextToken());
		assertEquals(Operator.SUBTRACTION, tokeniser.getNextToken());
		assertEquals(Operator.SUBTRACTION, tokeniser.getNextToken());
		assertEquals(Operator.MULTIPLICATION, tokeniser.getNextToken());
		assertEquals(Operator.MULTIPLICATION, tokeniser.getNextToken());
		assertEquals(Operator.DIVISION, tokeniser.getNextToken());
		assertEquals(Operator.DIVISION, tokeniser.getNextToken());
		
		try
		{
			tokeniser.getNextToken();
			assertEquals(tokeniser.getNextToken(), NonTerminalToken.END);
		}
		catch(NoSuchElementException e) {}
	}
	
	@Test
	public void testInvalidTokenParsing() throws Exception
	{
		try
		{
			tokeniser = new Tokeniser("Gagillion");
			token = tokeniser.getNextToken();
			fail("Invalid token expected.");
		}
		catch(Exception e)
		{
			assertEquals("Unknown token 'Gagillion'", e.getMessage());
		}
				
	}
}