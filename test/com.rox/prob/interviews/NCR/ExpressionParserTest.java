package com.rox.prob.interviews.NCR;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.rox.prob.interviews.NCR.err.InvalidExpressionException;

/**
 * Write a tex-based console application to perform simple natural language calculations.
 *
 * For example, if the user enters the test "two plus four" the program would output the value '6'.
 *
 * The program should be implemented in Java and please avoid using libraries or scripting engines,
 * for this excercise we want to see how you would implement the solution yourself.
 *
 * We would expect implementation to take no more than 4 hours.
 *
 * Supported input values: whole numbers between 0-9 inclusive expressed as case insensitive text.
 * Supported arithmatic operators: Add, plus, subtract, minus, less, multiply-by, times, over and divide-by
 */
public class ExpressionParserTest
{
    private ExpressionParser parser;

    @Test
    public void testAddition() throws InvalidExpressionException
    {
        parser = new ExpressionParser("two plus one");
        Expression expression = parser.getExpression();

        int result = expression.getValue();
        assertEquals(3, result);
    }

    @Test
    public void testSubtraction() throws InvalidExpressionException
    {
        parser = new ExpressionParser("two minus one");
        Expression expression = parser.getExpression();

        int result = expression.getValue();
        assertEquals(1, result);
    }

    @Test
    public void testMultiplication() throws InvalidExpressionException
    {
        parser = new ExpressionParser("two times three");
        Expression expression = parser.getExpression();

        int result = expression.getValue();
        assertEquals(6, result);
    }

    @Test
    public void testMultipleHighPrecedenceOperators() throws InvalidExpressionException
    {
        parser = new ExpressionParser("two times three times three");
        Expression expression = parser.getExpression();

        int result = expression.getValue();
        assertEquals(18, result);
    }

    @Test
    public void testDivision() throws InvalidExpressionException
    {
        parser = new ExpressionParser("eight divide-by two");
        Expression expression = parser.getExpression();

        int result = expression.getValue();
        assertEquals(4, result);
    }

    @Test
    public void testSimpleNestedExpression() throws InvalidExpressionException
    {
        parser = new ExpressionParser("three plus two minus four");
        Expression expression = parser.getExpression();

        int result = expression.getValue();
        assertEquals(1, result);
    }

    @Test
    public void testMultiplePrecedenceNestedExpression() throws InvalidExpressionException
    {
        parser = new ExpressionParser("three plus two times four");
        Expression expression = parser.getExpression();

        int result = expression.getValue();
        assertEquals(11, result);
    }

    @Test
    public void testWrongFirstToken()
    {
        parser = new ExpressionParser("add three two");

        try
        {
            parser.getExpression();
            fail("Invalid expression exception expected");
        }
        catch (InvalidExpressionException e)
        {
            assertEquals("Invalid expression 'add three two' expected <numeral>", e.getMessage());
        }
    }

    @Test
    public void testWrongSecondToken()
    {
        parser = new ExpressionParser("one three two");

        try
        {
            parser.getExpression();
            fail("Invalid expression exception expected");
        }
        catch (InvalidExpressionException e)
        {
            assertEquals("Invalid expression 'one three two' expected <operator>", e.getMessage());
        }
    }

    @Test
    public void testWrongThirdToken()
    {
        parser = new ExpressionParser("one add times");

        try
        {
            parser.getExpression();
            fail("Invalid expression exception expected");
        }
        catch (InvalidExpressionException e)
        {
            assertEquals("Invalid expression 'one add times' expected <numeral>", e.getMessage());
        }
    }

    @Test
    public void testInvalidToken()
    {
        parser = new ExpressionParser("two to-the-power-of five");

        try
        {
            parser.getExpression();
            fail("Invalid expression exception expected");
        }
        catch (InvalidExpressionException e)
        {
            assertEquals("Invalid expression 'two to-the-power-of five' Unknown token 'to-the-power-of'", e.getMessage());
        }
    }
}
