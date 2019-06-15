/**
 * 
 */
package com.problems.algorithms.week2.queues;

import java.util.Iterator;

/**
 * @author Thangaraj Jawahar
 *
 */
public class QueueUsingLinkedList<T> implements Iterable<T> {
	
	LinkedList<T> list;

	public QueueUsingLinkedList() {
		list = new LinkedList<>();
	}

	public void enQueue(T item) {
		list.add(item);
	}

	public T deQueue() {
		return list.removeLastAdded();
	}

	public boolean isEmpty() {
		return list.size() == 0;
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

}
