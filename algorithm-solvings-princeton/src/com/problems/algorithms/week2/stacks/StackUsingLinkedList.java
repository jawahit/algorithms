/**
 * 
 */
package com.problems.algorithms.week2.stacks;

/**
 * @author Thangaraj Jawahar
 *
 */
public class StackUsingLinkedList<T> {

	LinkedList<T> list;

	public StackUsingLinkedList() {
		list = new LinkedList<>();
	}

	public void push(T item) {
		list.add(item);
	}

	public T pop() {
		return list.removeLastAdded();
	}

	public boolean isEmpty() {
		return list.size() == 0;
	}

	
}
