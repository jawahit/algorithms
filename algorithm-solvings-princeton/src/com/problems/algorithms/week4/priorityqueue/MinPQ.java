/**
 * 
 */
package com.problems.algorithms.week4.priorityqueue;

import com.problems.algorithms.week2.sorting.SortingUtils;

/**
 * @author Thangaraj Jawahar
 *
 *         Jul 14, 2019
 * 
 *
 */
public class MinPQ<Key extends Comparable<Key>> {

	private Key[] keys;

	private int N;

	public MinPQ(int size) {
		keys = (Key[]) new Comparable[size];
	}
	
	public MinPQ() {
		keys = (Key[]) new Comparable[5];
	}

	public MinPQ(Key[] keys) {
		this.keys = keys;
	}

	public void insert(Key k) {
		if (N == (keys.length - 1))
			resize(N * 2);
		keys[++N] = k;
		swim(N);
	}

	private void swim(int k) {
		while (k > 1 && SortingUtils.isGreater(keys, k / 2, k)) {
			SortingUtils.exchange(keys, k, k / 2);
			k = k / 2;
		}
	}

	public Key delMin() {
		Key min = keys[1];
		keys[1] = keys[N--];
		sink(1);
		keys[N + 1] = null;
		if (N > 0 && N == ((keys.length - 1) / 4))
			resize(keys.length / 2);
		return min;
	}

	private void resize(int k) {
		Key[] newKeys = (Key[]) new Comparable[k];
		for (int i = 0; i <= N; i++) {
			newKeys[i] = keys[i];
		}
		keys = newKeys;
	}

	public Key min() {
		return keys[1];
	}

	public void printList() {
		SortingUtils.print(keys);
	}

	private void sink(int k) {
		int smaller = 2 * k;
		while (smaller <= N) {
			if (smaller < N && SortingUtils.isGreater(keys, smaller, smaller + 1))
				smaller++;
			if (SortingUtils.isGreater(keys, k, smaller)) {
				SortingUtils.exchange(keys, k, smaller);
			} else
				break;
			k = smaller;
			smaller = smaller * 2;
		}
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N <= 1;
	}

}
