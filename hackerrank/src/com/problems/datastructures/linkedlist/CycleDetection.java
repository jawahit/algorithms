package com.problems.datastructures.linkedlist;



/**
 * {@link https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem}
 * 
 * @author jawahar
 *
 */
public class CycleDetection {

	public static void main(String args[]) {
		Node nodeA = new Node();
		nodeA.data = 10;
		System.out.println(hasCycle(nodeA));
	}

	static boolean hasCycle(Node head) {

		if (head == null) {
			return false;
		}
		Node tortoiseRunner = head;
		Node hareRunner = head;
		while (hareRunner.next != null && hareRunner.next.next != null) {
			tortoiseRunner = tortoiseRunner.next;
			hareRunner = hareRunner.next.next;
			if (tortoiseRunner == hareRunner) {
				return true;
			}
		}
		return false;
	}

	static class Node {
		int data;
		Node next;
	}

}
