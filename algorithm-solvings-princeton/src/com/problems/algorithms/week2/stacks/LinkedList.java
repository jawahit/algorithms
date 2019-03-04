/**
 * 
 */
package com.problems.algorithms.week2.stacks;

/**
 * @author Thangaraj Jawahar
 *
 */
class LinkedList<T> {
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
