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
 *    not resize able array ( we can make it as just adding resizing on insert method
 *    and resize able on delMax
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
		keys[++N] = k;
		swim(N);
	}

	public Key delMax() {
		Key key = keys[1];
		keys[1] = keys[N--];
		sink(1);
		keys[N + 1] = null;
		// System.out.println("Item Deleted:" + key);
		return key;
	}

	public Key max() {
		return keys[1];
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
