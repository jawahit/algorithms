package com.problems.datastructures.linkedlist;

/**
 * {@link https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem}
 * 
 * @author jawahar
 *
 */
public class DeleteANodeByNth {

	public static void main(String args[]) {
		Node node = new Node();
		node.data = 10;
		Delete(node, 3);
	}

	static Node Delete(Node head, int position) {
		// Complete this method
		if (position == 0) {
			if (head != null) {
				head = head.next;
			}
			return head;
		}
		int count = 1;
		Node node = head;
		while (count != position) {
			node = node.next;
			count++;
			if (count > position)
				break;
		}
		Node nextNode = node.next;
		node.next = nextNode.next;
		return head;
	}

	static class Node {
		int data;
		Node next;
	}

}
