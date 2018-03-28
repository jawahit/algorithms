package com.problems.datastructures.linkedlist;



/**
 * 
 * {@link https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list/problem}
 * 
 * @author jawahar
 *
 */
public class InsertOnHead {
	
	public static void main(String args[]){
		Node node = new Node();
		node.data = 10;		
		Insert(node,3);
	}
	
	static Node Insert(Node head,int x) {
		// This is a "method-only" submission. 
		// You only need to complete this method. 
	    Node newNode = new Node();
		newNode.data = x;
	    if(head == null){
	        head=newNode;
	        return head;
	    }
	    newNode.next = head;
	    head = newNode;
	    return head;   
	}
	
	static class Node {
		int data;
		Node next;
	}

}
