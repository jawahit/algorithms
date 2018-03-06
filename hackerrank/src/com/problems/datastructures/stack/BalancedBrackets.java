package com.problems.datastructures.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * {@link https://www.hackerrank.com/domains/data-structures/stacks }
 * @author jawahar
 *
 */
public class BalancedBrackets {

	static Map<Character, Character> brackets = new HashMap<>();

	static String isBalanced(String s) {
		Stack<Character> stackBrackets = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char p = s.charAt(i);
			Character c = brackets.get(p);
			if (c != null) {
				stackBrackets.push(c);
			} else {
				if (!stackBrackets.isEmpty()) {
					Character stored = stackBrackets.pop();
					if (stored.equals(p)) {
						continue;
					} else {
						return "NO";
					}
				} else {
					return "NO";
				}
			}
		}
		if(stackBrackets.isEmpty()) return "YES";
		return "NO";
	}

	public static void main(String[] args) {
		brackets.put('{', '}');
		brackets.put('[', ']');
		brackets.put('(', ')');
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String s = in.next();
			String result = isBalanced(s);
			System.out.println(result);
		}
		in.close();
	}

}
