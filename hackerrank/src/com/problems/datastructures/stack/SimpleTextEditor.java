package com.problems.datastructures.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/simple-text-editor/problem
 * 
 * @author jawahar
 *
 */
public class SimpleTextEditor {

	public static Stack<Input> operationStack = new Stack<>();
	public static StringBuilder content = new StringBuilder();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int p_i = 0; p_i < n; p_i++) {
			int operation = in.nextInt();
			if (operation == 1) {
				Input i = new Input(operation, in.nextLine().trim());
				add(i);
				operationStack.push(i);
			} else if (operation == 2) {
				// delete
				String s = delete(in.nextInt());
				if (s != null)
					operationStack.push(new Input(operation, s));
			} else if (operation == 3) {// print
				System.out.println(content.charAt(in.nextInt() - 1));
			} else { // undo
				if (operationStack.isEmpty()) {
					return;
				}
				Input lastAction = operationStack.pop();
				String lastStr = lastAction.getValue();
				if (lastAction.getOperation() == 2) {
					add(lastAction);
				} else if (lastAction.getOperation() == 1) {
					//delete(lastStr.length());
					content.delete(content.length() - lastStr.length(), content.length());
				}
			}
		}

	}

	public static void add(Input i) {
		content.append(i.getValue());
	}

	public static String delete(int k) {
		if (content.length() == 0)
			return null;
		int size = content.length();
		String s = content.substring(size - k);
		content.delete(size - k, size);
		return s;
	}

	static class Input {
		int operation;
		String value;

		public Input(int operation, String value) {
			this.operation = operation;
			this.value = value;
		}

		public int getOperation() {
			return operation;
		}

		public String getValue() {
			return value;
		}
	}

}
