package com.problems.datastructures.linkedlist;

public class FindMergePoint {

	public static void main(String args[]) {
		Node nodeA = new Node();
		nodeA.data = 10;
		Node nodeB = new Node();
		nodeB.data = 10;
		System.out.println(FindMergeNode(nodeA, nodeB));
	}

	static int FindMergeNode(Node headA, Node headB) {
		// Complete this function
		// Do not write the main method.
		int nodeAsize = getSize(headA);
		int nodeBsize = getSize(headB);
		int lowerCount = 0;
		int higherCount = 0;
		Node higherNode = null;
		Node lowerNode = null;
		if (nodeAsize > nodeBsize) {
			lowerCount = nodeBsize;
			higherNode = headA;
			lowerNode = headB;
			higherCount = nodeAsize;
		} else {
			lowerCount = nodeAsize;
			higherNode = headB;
			lowerNode = headA;
			higherCount = nodeBsize;
		}
		int count = 0;
		int toMeet = higherCount - lowerCount;
		while (count != toMeet) {
			higherNode = higherNode.next;
			count++;
		}
		Node nodeA = higherNode;
		Node nodeB = lowerNode;
		while (nodeA != null) {
			if (nodeA == nodeB) {
				return nodeA.data;
			}
			nodeA = nodeA.next;
			nodeB = nodeB.next;
		}
		return 0;
	}

	static int getSize(Node head) {
		int total = 0;
		Node tortoiseRunner = head;
		Node hareRunner = head;
		int count = 0;
		while (hareRunner.next != null && hareRunner.next.next != null) {
			tortoiseRunner = tortoiseRunner.next;
			hareRunner = hareRunner.next.next;
			count++;
		}
		if (hareRunner.next != null) {
			count++;
			total = count * 2;
		} else {
			total = count * 2;
			total++;
		}
		return total;
	}

	static class Node {
		int data;
		Node next;
	}
}
