package com.rox.prob.interviews.companyA;

import com.rox.prob.interviews.companyA.err.InvalidExpressionException;
import com.rox.prob.interviews.companyA.err.UnknownTokenException;
import com.rox.prob.interviews.companyA.token.*;

import java.util.Stack;


/**
 * Parse <tt>expressionString</tt> into a very basic AST like data structure in 
 * {@link com.rox.prob.interviews.companyA.Expression Expression} and provide it through
 * <tt>getExpression()</tt>
 * 
 * @author Ross W. Drew
 */
public class ExpressionParser 
{
	private String expressionString;
	private Tokeniser tokeniser;
	
	private Stack<ExpressionToken> tokenStack = new Stack<>();
	
	public ExpressionParser(String expressionString)
	{
		this.expressionString = expressionString;
		tokeniser = new Tokeniser(expressionString);
	}

	private boolean isNumeral(ExpressionToken token)
	{
		return (token instanceof Numeral);
	}
	
	private boolean isOperator(ExpressionToken token)
	{
		return (token instanceof Operator);
	}
	
	private void buildExpressionFromStack()
	{
		NumeralValue n1 = (NumeralValue)tokenStack.pop();
		Operator o = (Operator)tokenStack.pop();
		NumeralValue n2 = (NumeralValue)tokenStack.pop();
		
		tokenStack.push(new Expression(n2, o, n1));
	}
	
	private void pushNumeralValue() throws UnknownTokenException, InvalidExpressionException
	{
		ExpressionToken t = tokeniser.getNextToken();
		
		if (isNumeral(t))
		{
			tokenStack.push(t);
		}
		else
		{
			throw new InvalidExpressionException(expressionString, "expected <numeral>");
		}
	}
	
	private void pushOperator() throws UnknownTokenException, InvalidExpressionException
	{
		ExpressionToken t = tokeniser.getNextToken();
		pushOperator(t);
	}
	
	private void pushOperator(ExpressionToken t) throws UnknownTokenException, InvalidExpressionException 
	{
		if (isOperator(t))
		{
			tokenStack.push(t);
		}
		else
		{
			throw new InvalidExpressionException(expressionString, "expected <operator>");
		}
	}
	
	private void lookAhead() throws UnknownTokenException, InvalidExpressionException
	{
		ExpressionToken t = tokeniser.getNextToken();
		if (t instanceof Operator)
		{
			Operator o = (Operator)t;
			lookAhead(o);
		}
		else if (t instanceof NonTerminalToken)
		{
			NonTerminalToken nt = (NonTerminalToken)t;
			if (nt == NonTerminalToken.END)
			{
				buildExpressionFromStack();
				return;
			}
		}
		else
		{
			throw new InvalidExpressionException(expressionString, "Operator expected, got " + t.getClass());
		}
	}
	
	private void lookAhead(Operator o) throws UnknownTokenException, InvalidExpressionException
	{
		//Next calculation is of higher precedence
		if (o.getOrdinalValue() == 2)
		{
			pushOperator(o);
			pushNumeralValue();
			buildExpressionFromStack();
			lookAhead();// R e c u r s i v e
		}
		else
		{
			buildExpressionFromStack();
			pushOperator(o);
			pushNumeralValue();
			lookAhead();// R e c u r s v i v e
		}
	}
	
	/**
	 * @return {@link com.rox.prob.interviews.companyA.Expression Expression} containing entire expression as data structure
	 * @throws InvalidExpressionException if provided textual expression is invalid
	 */
	public Expression getExpression() throws InvalidExpressionException
	{
		try
		{
			pushNumeralValue();
			pushOperator();
			pushNumeralValue();
			
			lookAhead();
			
			//Should be one expression left on the stack, containing all nested expressions
			ExpressionToken completeExpression = tokenStack.pop();
			
			if (completeExpression instanceof Expression)
			{
				return (Expression)completeExpression;
			}
			else
			{
				throw new InvalidExpressionException(expressionString, "Unknown error while parsing expression");
			}
		}
		catch (UnknownTokenException e)
		{
			throw new InvalidExpressionException(expressionString, e.getMessage());
		}
	}
}
