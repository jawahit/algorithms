/**
 * 
 */
package com.problems.algorithms.week2.queues;

import java.util.Iterator;

/**
 * @author Thangaraj Jawahar
 *
 */
class LinkedList<T> implements Iterable<T> {
	Node head;
	Node tail;
	int size;

	public LinkedList() {
	}

	public void add(T t) {
		if (this.head == null) {
			this.head = new Node(t);
			this.tail = head;
		} else {
			Node node = new Node(t);
			this.tail.next = node;
			this.tail = this.tail.next;
		}
		increaseSize();
	}

	public T removeLastAdded() {
		if (this.head != null) {
			Node node = this.head;
			this.head = this.head.next;
			decreaseSize();
			return (T) node.data;
		}
		return null;
	}

	private void increaseSize() {
		size++;
	}

	private void decreaseSize() {
		size--;
	}

	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator<T>();
	}

	private class ListIterator<T> implements Iterator<T> {

		private Node headPointer = head;

		@Override
		public boolean hasNext() {
			return headPointer != null;
		}

		@Override
		public T next() {
			Node n = headPointer;
			headPointer = headPointer.next;
			return  (T) n.data;
		}

	}
}

class Node<T> {
	T data;
	Node next;

	public Node(T t) {
		this.data = t;
	}
}
