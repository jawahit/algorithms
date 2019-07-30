/**
 * 
 */
package com.problems.algorithms.week4.priorityqueue;

import java.util.NoSuchElementException;

import com.problems.algorithms.week2.sorting.SortingUtils;

/**
 * @author Thangaraj Jawahar
 *
 *         Jul 20, 2019
 * 
 *
 */
public class IndexMaxPQ<Key extends Comparable<Key>> {

	private Key[] keys;

	private int[] pq;

	private int[] qp;

	private int N;

	public IndexMaxPQ() {
		keys = (Key[]) new Comparable[20];
	}

	public IndexMaxPQ(int size) {
		keys = (Key[]) new Comparable[size + 1];
		pq = new int[size + 1];
		qp = new int[size + 1];
		for (int i = 1; i <= size; i++) {
			qp[i] = -1;
		}
	}

	public IndexMaxPQ(Key[] keys) {
		this.keys = keys;
	}
	
	private void validate(int i) {
		if(i < 1 || i > keys.length) throw new IllegalArgumentException("index is out of range");
	}

	public void insert(int i, Key k) {
		validate(i);
		++N;
		pq[N] = i;
		qp[i] = N;
		keys[i] = k;
		swim(N);
	}

	public Key delMax() throws IllegalAccessException {
		throwIfEmpty();
		Key key = keys[pq[1]];
		int max = pq[1];
		exchange(1, N--);
		sink(1);
		qp[max] = -1;
		pq[N+1] = -1;
		keys[max] = null;
		return key;
	}
	
	public void delete(int i) {
		throwIfEmpty();
		validate(i);
		int ind = qp[i];
		exchange(ind, N--);
		swim(ind);
		sink(ind);
		keys[i] = null;
		qp[i] = -1;
		pq[N+1] = -1; // TODO need to verify
	}
	
	public void throwIfEmpty() {
		if(isEmpty()) {
			throw new NoSuchElementException("no elements in queue");
		}
	}


	public Key max() {
		throwIfEmpty();
		return keys[pq[1]];
	}
	
	public int maxIndex() {
		throwIfEmpty();
		return pq[1];
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
			if (bigger < N && isLess(bigger, bigger + 1))
				bigger++;
			if (keys[bigger] != null && isLess( k, bigger)) {
				exchange(k, bigger);
			} else
				break;
			k = bigger;
		}
	}
	
	private boolean isLess(int i , int j) {
		return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
	}
	
	private void exchange(int i, int j) {
		int temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}

	public boolean contains(int k) {
		return qp[k] != -1;
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void printList() {
		SortingUtils.print(keys);
	}

}
