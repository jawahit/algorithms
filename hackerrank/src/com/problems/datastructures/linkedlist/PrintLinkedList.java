package com.problems.datastructures.linkedlist;


/**
 * @author jawahar
 * 
 * {@link https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem}
 *
 */
public class PrintLinkedList {
	
	public static void main(String args[]){
		Node node = new Node();
		node.data = 10;		
		Print(node);
	}
	public static void Print(Node head) {
		if(head == null){
			return;
		}
		Node node = head;
		while(node!=null){
			System.out.println(node.data);
			node=node.next;
		}    
	}

	static class Node {
		int data;
		Node next;
	}

}
