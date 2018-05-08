package com.problems.datastructures.arrays;



/**
 * {@link https://www.hackerrank.com/challenges/dynamic-array/problem}
 * 
 * @author jawahar
 *
 */
public class DynamicArray {

	public static void main(String[] args) {
		int[][] queries = { { 1, 0, 5 }, { 1, 1, 7 }, { 1, 0, 3 }, { 2, 1, 0 }, { 2, 1, 1 } };
		Object[] test = dynamicArray(2, queries);
		for (Object i : test) {
			if (i == null)
				break;
			System.out.println(i);
		}

	}

	static Object[] dynamicArray(int n, int[][] queries) {
		MyList<MyList<Integer>> mainList = new MyList<>(n);
		int c = n;
		while (c != 0) {
			mainList.add(new MyList<>());
			c--;
		}
		MyList<Integer> lastAnswerList = new MyList<>(queries.length);
		int lastAnswer = 0;
		int j = 0;
		for (int i = 0; i < queries.length; i++) {
			int data = lastAnswer ^ queries[i][j + 1];
			MyList<Integer> li = mainList.get(data % n);
			if (queries[i][j] == 1) {
				li.add(queries[i][j + 2]);
			} else if (queries[i][j] == 2) {
				int datas = queries[i][j + 2] % li.size();
				lastAnswer = li.get(datas);
				lastAnswerList.add(lastAnswer);
			}
		}
		return lastAnswerList.toArray();
	}

	static class MyList<T> {
		int initialValue = 10;
		Object[] element;
		int index = 0;

		public MyList(int initial) {
			initialValue = initial;
			element = new Object[initial];
		}

		public MyList() {
			element = new Object[initialValue];
		}

		public void add(T t) {
			if (index > initialValue - 1) {
				initialValue = initialValue + (initialValue / 2);
				Object[] arr = new Object[initialValue];
				System.arraycopy(element, 0, arr, 0, index);
				element = arr;
			}
			element[index] = t;
			index++;
		}

		public T get(int index) {
			return (T) element[index];
		}

		public int size() {
			return index;
		}

		public T[] toArray() {
			return (T[]) element;
		}

	}
}
