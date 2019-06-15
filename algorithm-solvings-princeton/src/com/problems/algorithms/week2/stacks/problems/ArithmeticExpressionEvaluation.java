/**
 * 
 */
package com.problems.algorithms.week2.stacks.problems;

import java.util.HashMap;
import java.util.Map;

import com.problems.algorithms.week2.stacks.StackUsingLinkedList;

/**
 * This class {@code ArithmeticExpressionEvaluation} used to evaluate the expression only for 
 * paranthesis covered with two values 
 * 
 * For Ex:
 * (1+((2+3)*(4*5))) 
 * here (2+3) covers two values
 * (4*5) covers two values
 * 
 * More things needs to be done for operator precedence more values in paranthesis like ( 2*3+5) etc.,
 * 
 * @author Thangaraj Jawahar
 *
 */
public class ArithmeticExpressionEvaluation {

	static final char CLOSE_PARANTHESIS = ')';
	static final char OPEN_PARANTHESIS = '(';
	static final char PLUS = '+';
	static final char MINUS = '-';
	static final char MUL = '*';
	static final char DIV = '/';
	static Map<Character, Character> operatorMap = new HashMap<Character, Character>();

	public static void main(String[] args) {
		operatorMap.put('+', '+');
		operatorMap.put('-', '-');
		operatorMap.put('/', '/');
		operatorMap.put('*', '*');
		String expression = "(1+((2+3)*(4*5)))";
		StackUsingLinkedList<Double> operandStack = new StackUsingLinkedList<Double>();
		StackUsingLinkedList<Character> operatorStack = new StackUsingLinkedList<Character>();
		for (char s : expression.toCharArray()) {
			if(s == OPEN_PARANTHESIS) {
				continue;
			} else if(s == CLOSE_PARANTHESIS) {
				operandStack.push(operation(operandStack.pop(), operandStack.pop(), operatorStack.pop())); 
			} else if(operatorMap.containsKey(s)) {
				operatorStack.push(s);
			} else {
				operandStack.push(Double.parseDouble(Character.toString(s)));
			}
		}
		System.out.println(operandStack.pop());

	}

	public static Double operation(Double a, Double b, char c) {
		if (c == PLUS) {
			return a + b;
		} else if (c == MINUS) {
			return a - b;
		} else if (c == MUL) {
			return a * b;
		} else {
			return a / b;
		}
	}

}
