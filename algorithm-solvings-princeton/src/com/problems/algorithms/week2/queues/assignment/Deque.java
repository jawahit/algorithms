package com.problems.algorithms.week2.queues.assignment;
import java.util.Iterator;

/**
 * This class {@code Deque} internally uses Doubly Linked List for Deque
 * operation
 * 
 * @author Thangaraj Jawahar
 *
 */
public class Deque<Item> implements Iterable<Item> {

	private Node<Item> first;
	private Node<Item> last;
	private int size;

	// construct an empty deque
	public Deque() {

	}

	// is the deque empty?
	public boolean isEmpty() {
		return size == 0;
	}

	// return the number of items on the deque
	public int size() {
		return size;
	}

	private void increaseSize() {
		size++;
	}

	private void decreaseSize() {
		size--;
	}

	// add the item to the front
	public void addFirst(Item item) {
		if (item == null) {
			throw new java.lang.IllegalArgumentException("it can't be null");
		} else {
			if (this.first == null && this.last == null) {
				this.first = new Node<Item>(item);
				this.last = this.first;
			} else {
				Node<Item> node = new Node<Item>(item);
				node.next = this.first;
				this.first.prev = node;
				this.first = node;
			}
			increaseSize();
		}
	}

	// add the item to the end
	public void addLast(Item item) {
		if (item == null) {
			throw new java.lang.IllegalArgumentException("it can't be null");
		} else {
			if (this.first == null && this.last == null) {
				this.first = new Node<Item>(item);
				this.last = this.first;
			} else {
				this.last.next = new Node<Item>(item);
				this.last.next.prev = this.last;
				this.last = this.last.next;
			}
			increaseSize();
		}
	}

	// remove and return the item from the front
	public Item removeFirst() {
		if (isEmpty()) {
			throw new java.util.NoSuchElementException("queue is empty");
		} else {
			Node<Item> node = this.first;
			this.first = this.first.next;
			if (this.first != null) {
				this.first.prev = null;
			} else {
				this.last = null;
			}
			decreaseSize();
			return node.data;
		}
	}

	// remove and return the item from the end
	public Item removeLast() {
		if (isEmpty()) {
			throw new java.util.NoSuchElementException("queue is empty");
		} else {
			Node<Item> node = this.last;
			this.last = this.last.prev;
			if (this.last != null) {
				this.last.next = null;
			} else {
				this.first = null;
			}
			decreaseSize();
			return node.data;
		}
	}

	// return an iterator over items in order from front to end
	public Iterator<Item> iterator() {
		return new DqueueIterator();
	}

	private class DqueueIterator implements Iterator<Item> {

		private Deque<Item>.Node<Item> frontPointer = first;

		@Override
		public boolean hasNext() {
			return frontPointer != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new java.util.NoSuchElementException("queue is empty");
			}
			Deque<Item>.Node<Item> node = frontPointer;
			frontPointer = frontPointer.next;
			return node.data;
		}
		
		public void remove() {
			throw new java.lang.UnsupportedOperationException(" remove method not accepted");
		}

	}

	private class Node<Item> {
		private Item data;
		private Node<Item> next;
		private Node<Item> prev;

		public Node(Item t) {
			this.data = t;
		}
	}

	public static void main(String args[]) {
	
	}

}
