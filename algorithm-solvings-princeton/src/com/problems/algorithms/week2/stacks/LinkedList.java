/**
 * 
 */
package com.problems.algorithms.week2.stacks;

import java.util.Iterator;

/**
 * @author Thangaraj Jawahar
 *
 */
class LinkedList<T> implements Iterable<T> {
	Node head;
	int size;

	public LinkedList() {
	}

	public void add(T t) {
		if (this.head == null) {
			this.head = new Node(t);
		} else {
			Node node = new Node(t);
			node.next = this.head;
			this.head = node;
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
	
	public T getLastAdded() {
		return (T) this.head.data;
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
		return new ListIterator();
	}

	private class ListIterator implements Iterator<T> {

		private Node current = head;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public T next() {
			T t = (T) current.data;
			current = current.next;
			return t;
		}

	}

	class Node<T> {
		T data;
		Node next;

		public Node(T t) {
			this.data = t;
		}
	}
}
