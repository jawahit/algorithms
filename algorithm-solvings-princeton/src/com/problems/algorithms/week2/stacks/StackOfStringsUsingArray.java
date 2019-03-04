/**
 * 
 */
package com.problems.algorithms.week2.stacks;

/**
 * warmup api for Stack using Array
 * 
 * @author Thangaraj Jawahar
 *
 */
public class StackOfStringsUsingArray {
	String[] arr;
	int currentIndex;

	public StackOfStringsUsingArray(int size) {
		arr = new String[size];
	}

	public void push(String item) {
		if(currentIndex == (arr.length - 1)) {
			resizeArray(arr.length * 2);
		}
		this.arr[currentIndex++] = item;
	}

	public String pop() {
		if (currentIndex != -1) {
			if(currentIndex == (arr.length / 4)) {
				doHalving(arr.length /2 );
			}
			String s = this.arr[--currentIndex];
			this.arr[currentIndex] = null;
			return s;
		}
		return null;
	}
	
	private void resizeArray(int size) {
		String[] newArr = new String[size];
		for(int i = 0; i < arr.length - 1; i++) {
			newArr[i] = arr[i];
		}
		arr = newArr;
	}
	
	private void doHalving(int size) {
		String[] newArr = new String[size];
		for(int i = 0; i < newArr.length - 1; i++) {
			newArr[i] = arr[i];
		}
		arr = newArr;
	}

	public boolean isEmpty() {
		return currentIndex == 0;
	}

	private int size() {
		return currentIndex;
	}
}
