/**
 * 
 */
package com.problems.algorithms.week2.queues;

/**
 * @author Thangaraj Jawahar
 *
 */
class LinkedList<T> {
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
}

class Node<T> {
	T data;
	Node next;

	public Node(T t) {
		this.data = t;
	}
}

