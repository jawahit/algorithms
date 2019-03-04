/**
 * 
 */
package com.problems.algorithms.week2.queues;


/**
 * @author Thangaraj Jawahar
 *
 */
public class QueueUsingLinkedList<T> {
	
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

}
