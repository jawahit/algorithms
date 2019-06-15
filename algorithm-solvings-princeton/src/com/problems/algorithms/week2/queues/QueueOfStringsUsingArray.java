/**
 * 
 */
package com.problems.algorithms.week2.queues;

/**
 * @author Thangaraj Jawahar
 *
 */
public class QueueOfStringsUsingArray {

	String[] arr;
	int currentIndex;
	int dequeueIndex;

	public QueueOfStringsUsingArray(int size) {
		arr = new String[size];
	}

	public void enQueue(String item) {
		if (currentIndex >= (arr.length - 1)) {
			resizeArray(arr.length * 2);
		}
		this.arr[currentIndex++] = item;
	}

	public String deQueue() {
		if (dequeueIndex != -1) {
			if (dequeueIndex == (arr.length / 4)) {
				doHalving(arr.length / 2);
			}

			String s = this.arr[dequeueIndex];
			this.arr[dequeueIndex++] = null;
			if (dequeueIndex == currentIndex) {
				dequeueIndex = 0;
				currentIndex = 0;
			}
			return s;
		}
		return null;
	}

	private void resizeArray(int size) {
		String[] newArr = new String[size];
		int count = 0;
		for (int i = dequeueIndex; i < currentIndex; i++) {
			newArr[count] = arr[i];
			count++;
		}
		dequeueIndex = 0;
		//currentIndex = count - 1;
		arr = newArr;
	}

	private void doHalving(int size) {
		String[] newArr = new String[size];
		int forCurrentIndex = dequeueIndex;
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = arr[dequeueIndex++];
		}
		dequeueIndex = 0;
		currentIndex = forCurrentIndex + 1;
		arr = newArr;
	}

	public boolean isEmpty() {
		return currentIndex == 0;
	}

	private int size() {
		return currentIndex;
	}

}
