/**
 * 
 */
package com.problems.algorithms.week2.stacks;

import java.util.Iterator;

/**
 * @author Thangaraj Jawahar
 *
 */
public class StackUsingLinkedList<T> implements Iterable<T>  {

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
	
	public T peek() {
		return list.getLastAdded();
	}

	public boolean isEmpty() {
		return list.size() == 0;
	}
	
	public Iterator<T> iterator() {
		return list.iterator();
	}

	
}
