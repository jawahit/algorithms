/**
 * 
 */
package com.problems.algorithms.week4.priorityqueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Thangaraj Jawahar
 *
 *         Jul 9, 2019
 * 
 *
 */
public class MaxPQUsingList<Key extends Comparable<Key>> {

	private List<Key> list;
	
	private int N;

	public MaxPQUsingList() {
		list = new ArrayList<Key>();
		list.add(N++,null);
	}

	public MaxPQUsingList(int size) {
		list = new ArrayList<Key>(size);
		list.add(null);
	}

	public MaxPQUsingList(List<Key> l) {
		list = l;
	}

	public void insert(Key k) {
		list.add(N,k);
		swim(N++);
	}

	public Key delMax() {
		Key key = list.get(1);
		list.set(1, list.get(N - 1));
		list.set(--N, null);
		sink(1);
		System.out.println("Item Deleted:" + key);
		return key;
	}

	private void swim(int k) {
		while (k >= 2 && list.get(k / 2).compareTo(list.get(k)) < 0) {
			Key parent = list.get(k / 2);
			list.set(k / 2, list.get(k));
			list.set(k, parent);
			k = k / 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= N) {
			int bigger = 2 * k;
			if (bigger < N && list.get(bigger).compareTo(list.get(bigger + 1)) < 0)
				bigger++;
			if (list.get(bigger) != null && list.get(k).compareTo(list.get(bigger)) < 0) {
				Key parent = list.get(k);
				list.set(k, list.get(bigger));
				list.set(bigger, parent);
			} else break;
			k = bigger;
		}
	}

	public int size() {
		return list.size();
	}
	
	public void printList() {
		for(Key s:list){
			System.out.println(s);
		}
	}

}
