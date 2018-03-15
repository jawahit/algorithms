package com.problems.datastructures.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * {@link https://www.hackerrank.com/challenges/equal-stacks/problem}
 * 
 * @author jawahar
 *
 */
public class EqualStacks {

	static Map<String, Cylinder> map = new HashMap<>();
	static int lowerValue = 0;
	static String lowerStackName = null;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int n3 = in.nextInt();
		Cylinder c1 = fillStack(in, n1, "c1");
		Cylinder c2 = fillStack(in, n2, "c2");
		Cylinder c3 = fillStack(in, n3, "c3");
		map.put("c1", c1);
		map.put("c2", c2);
		map.put("c3", c3);
		in.close();
		equalizing(map);
		
	}

	static void equalizing(Map<String, Cylinder> map) {
		// step: 1 check equal status
		if (checkEqualAndSetStatus(map)) {
			System.out.println(map.get("c1").count);
			return;
		} else {
			for (Cylinder c : map.values()) {
				if (c.count > lowerValue) {
					while (c.count > lowerValue) {
						int v = c.s.peek();
						int m = c.count - v;
						if (m >= lowerValue) {
							c.s.pop();
							c.count = m;
						} else {
							c.s.pop();
							c.count = m;
							break;
						}
					}
				}
			}
			equalizing(map);
		}
	}

	static boolean checkEqualAndSetStatus(Map<String, Cylinder> map) {
		Cylinder c1 = map.get("c1");
		Cylinder c2 = map.get("c2");
		Cylinder c3 = map.get("c3");
		c1.doCompare(c2);
		c2.doCompare(c3);
		if (c1.isEqual && c2.isEqual && c3.isEqual) {
			return true;
		}
		lowerValue = (c1.count <= c2.count && c1.count <= c3.count) ? c1.count
				: (c2.count <= c1.count && c2.count <= c3.count) ? c2.count : c3.count;
		return false;
	}

	static int getLower(int c1, int c2, int c3) {
		return (c1 <= c2 && c1 <= c3) ? c1 : (c2 <= c1 && c2 <= c3) ? c2 : c3;
	}

	private static Cylinder fillStack(Scanner in, int n1, String name) {
		Cylinder c1 = new Cylinder();
		c1.name = name;
		for (int h1_i = 0; h1_i < n1; h1_i++) {
			int v = in.nextInt();
			c1.count = c1.count + v;
			c1.s.push(v);
		}
		Stack<Integer> s1 = new Stack();
		while(!c1.s.isEmpty()){
			s1.push(c1.s.pop());
		}
		c1.s = s1;
		return c1;
	}

	static class Cylinder {
		Stack<Integer> s = new Stack<>();
		String name;
		Integer count = new Integer(0);
		boolean isEqual = false;

		public void doCompare(Cylinder c) {
			int o1 = this.count.compareTo(c.count);
			if (o1 == 0) {
				this.isEqual = true;
				c.isEqual = true;
			} else {
				this.isEqual = false;
				c.isEqual = false;
			}
		}
	}

}
