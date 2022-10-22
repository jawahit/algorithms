/**
 * 
 */
package com.problems.algorithms.week4.priorityqueue;

import com.problems.algorithms.week2.sorting.SortingUtils;

/**
 * 
 * this class {@code MaxPQ} priority queue implementation for Comparable keys
 * 
 * Constraints:
 * 
 * not resize able array ( we can make it as just adding resizing on insert
 * method and resize able on delMax
 * 
 * @author Thangaraj Jawahar
 *
 *         Jul 14, 2019
 * 
 *
 */
public class MaxPQ<Key extends Comparable<Key>> {

	private Key[] keys;

	private int N;

	private Key min;

	public MaxPQ() {
		keys = (Key[]) new Comparable[20];
	}

	public MaxPQ(int size) {
		keys = (Key[]) new Comparable[size];
	}

	public MaxPQ(Key[] keys) {
		this.keys = keys;
	}

	public void insert(Key k) {
		if (N == (keys.length - 1))
			resize(N * 2);
		keys[++N] = k;
		swim(N);
		// to display min value not neccessary
		if (min == null || min.compareTo(k) > 0) {
			min = k;
		}
	}

	public Key delMax() throws IllegalAccessException {
		if(isEmpty()) throw new IllegalAccessException("queue is empty");
		Key key = keys[1];
		keys[1] = keys[N--];
		sink(1);
		keys[N + 1] = null;
		// System.out.println("Item Deleted:" + key);
		if (N > 0 && N == ((keys.length - 1) / 4))
			resize(keys.length / 2);
		return key;
	}

	private void resize(int k) {
		Key[] newKeys = (Key[]) new Comparable[k];
		for (int i = 0; i < keys.length; i++) {
			newKeys[i] = keys[i];
		}
		keys = newKeys;
	}

	public Key max() {
		return keys[1];
	}

	public Key min() {
		return min;
	}

	private void swim(int k) {
		while (k > 1 && SortingUtils.isLess(keys, k / 2, k)) {
			SortingUtils.exchange(keys, k, k / 2);
			k = k / 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= N) {
			int bigger = 2 * k;
			if (bigger < N && SortingUtils.isLess(keys, bigger, bigger + 1))
				bigger++;
			if (keys[bigger] != null && SortingUtils.isLess(keys, k, bigger)) {
				SortingUtils.exchange(keys, k, bigger);
			} else
				break;
			k = bigger;
		}
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N <= 1;
	}

	public void printList() {
		SortingUtils.print(keys);
	}
}
