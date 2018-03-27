package com.problems.datastructures.stack;

import java.util.Scanner;

/**
 * {@link https://www.hackerrank.com/challenges/poisonous-plants/problem}
 * 
 * This logic deals about only the output left over plants not the days count
 * but in the real problem it's ask for days count so if they ask for output
 * plants time this is efficient
 * 
 * @author jawahar
 *
 */
public class PoisonousPlants {

	static int count = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int last = in.nextInt();
		LinkedList<Integer> lastList = new LinkedList<>(last);
		LinkedList<LinkedList> ll = new LinkedList();
		for (int i = 1; i < m; i++) {
			int current = in.nextInt();
			if (current > lastList.tail.data) {
				ll.add(lastList);
				lastList = new LinkedList(current);
			} else {
				lastList.add(current);
			}
		}
		ll.add(lastList);
		// count++;
		long size = ll.size();
		while (size != 1) {
			ll = calculateDays(ll);
			count++;
			size = ll.size();
		}
		System.out.println(count);
		in.close();
	}

	public static LinkedList<LinkedList> calculateDays(LinkedList<LinkedList> ll) {
		Node<LinkedList> firstData = ll.head;
		Node<LinkedList> nextData = firstData.next;
		Node<LinkedList> previousData = firstData;
		while (nextData != null) {
			LinkedList<Integer> dataList = (LinkedList<Integer>) nextData.data;
			if (dataList.removeByHead() == null) {
				nextData.data = null;
				ll.reduceCount();
				previousData.next = nextData.next;
				nextData = nextData.next;
				continue;
			}
			previousData = nextData;
			nextData = nextData.next;
		}

		nextData = firstData.next;
		while (nextData != null) {
			LinkedList<Integer> first = firstData.data;
			LinkedList<Integer> next = (LinkedList<Integer>) nextData.data;
			if (first != null) {
				if (next != null) {
					if (next.head.data > first.tail.data) {
						firstData = nextData;
						nextData = nextData.next;
					} else {
						first.merge(next);
						firstData.next = nextData.next;
						ll.reduceCount();
						nextData = nextData.next;
					}
				}
			}
		}

		return ll;
	}

	static class LinkedList<T> {
		Node<T> head;
		Node<T> tail;
		long count;

		public LinkedList(T t) {
			if (this.head == null) {
				init(t);
			}
		}

		public LinkedList() {
		}

		public void init(T t) {
			this.head = new Node(t);
			this.tail = this.head;
			this.count++;
		}

		public long size() {
			return count;
		}

		public void add(T t) {
			if (this.head == null) {
				init(t);
				return;
			}
			if (tail != null) {
				Node newNode = new Node(t);
				tail.next = newNode;
				tail = tail.next;
				this.count++;
			}
		}

		public void merge(LinkedList<T> ll) {
			if (this.tail == null) {
				this.tail = ll.tail;
				this.head = ll.head;
				this.count = ll.count;
			} else {
				this.tail.next = ll.head;
				this.tail = ll.tail;
				this.count += ll.count;
			}
		}

		public void removeByTail() {
			if (this.tail == null) {
				return;
			} else {
				this.count--;
				long removalCount = this.count;
				Node node = this.head;
				while (removalCount > 1) {
					node = node.next;
					removalCount--;
				}
				node.next = null;
			}
		}

		public LinkedList<T> removeByHead() {
			if (this.head == null) {
				return null;
			}
			this.head = this.head.next;
			this.count--;
			if (this.count == 1) {
				this.tail = this.head;
			} else if (this.count == 0) {
				return null;
			}
			return this;
		}

		public void reduceCount() {
			this.count--;
		}

	}

	static class Node<T> {
		T data;
		Node next;

		Node(T t) {
			this.data = t;
			this.next = null;
		}
	}
}
