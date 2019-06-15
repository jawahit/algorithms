package com.problems.algorithms.week2.queues.assignment;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;


/**
 * This class{@code RandomizedQueue} uses Array Implementation of queue return & removes in random order
 * @author Thangaraj Jawahar
 *
 * @param <Item>
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

	private Object[] arr;
	private int currentIndex;

	/**
	 * construct an empty randomized queue
	 */
	public RandomizedQueue() {
		arr = new Object[2];
	}

	/**
	 * is the randomized queue empty?
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return currentIndex <= 0;
	}

	/**
	 * return the number of items on the randomized queue
	 * 
	 * @return
	 */
	public int size() {
		return currentIndex;
	}

	/**
	 * add the item
	 * 
	 * @param item
	 */
	public void enqueue(Item item) {
		if (item == null) {
			throw new java.lang.IllegalArgumentException("can't be null");
		}
		if (currentIndex >= arr.length) {
			resizeArray(arr.length * 2);
		}
		arr[currentIndex++] =  item;
	}

	private void resizeArray(int size) {
		Object[] newArr = new Object[size];
		for (int i = 0; i < currentIndex; i++) {
			newArr[i] = arr[i];
		}
		arr = newArr;
	}
	
	 private void rangeCheck(int index) {
	        if (index >= arr.length)
	            throw new IndexOutOfBoundsException("Index out of bound" + index);
	 }
	 
	 private Item getData(int index) {
		 rangeCheck(index);
		 return (Item) arr[index];
	 }
	 
	 

	/**
	 * remove and return a random item
	 * 
	 * @return
	 */
	public Item dequeue() {
		if (isEmpty()) {
			throw new java.util.NoSuchElementException("Queue is empty");
		}
		int r = StdRandom.uniform(currentIndex);
		Item s = getData(r);
		arr[r] = arr[currentIndex - 1];
		arr[currentIndex - 1] = null;
		if (currentIndex == (arr.length / 4)) {
			resizeArray(arr.length / 2);
		}
		currentIndex--;
		return s;
	}

	/**
	 * return a random item (but do not remove it)
	 * 
	 * @return
	 */
	public Item sample() {
		if (isEmpty()) {
			throw new java.util.NoSuchElementException("Queue is empty");
		}
		return getData(StdRandom.uniform(currentIndex));
	}

	public Iterator<Item> iterator() {
		return new RandomQueueIterator();
	}

	private class RandomQueueIterator implements Iterator<Item> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return currentIndex > 0;
		}

		@Override
		public Item next() {
			if (currentIndex <= 0) {
				throw new java.util.NoSuchElementException("Queue is empty");
			}
			return getData(StdRandom.uniform(currentIndex));
		}
		
		public void remove() {
			throw new java.lang.UnsupportedOperationException(" remove method not accepted");
		}

	}

	public static void main(String[] args) {
		
		RandomizedQueue<String> queue = new RandomizedQueue<>();
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");
		queue.enqueue("e");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		//System.out.println(queue.dequeue());
		

		RandomizedQueue<Integer> queue1 = new RandomizedQueue<>();
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);
		queue1.enqueue(4);
		queue1.enqueue(5);
		System.out.println(queue1.dequeue());
		System.out.println(queue1.dequeue());
		System.out.println(queue1.dequeue());
		System.out.println(queue1.dequeue());
		System.out.println(queue1.dequeue());
		System.out.println(queue1.dequeue());

	}
}
