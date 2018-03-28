package com.problems.datastructures.linkedlist;

/**
 * @author jawahar
 * 
 * {@link https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem}
 *
 */
public class InsertOnTail {

	public static void main(String args[]){
		Node node = new Node();
		node.data = 10;		
		Insert(node,3);
	}
	
	static Node Insert(Node head,int data) {
		// This is a "method-only" submission. 
		// You only need to complete this method. 
		        Node newNode = new Node();
		        newNode.data = data;
		        if(head == null){
					head=newNode;
		            return head;
				}
				Node node = head;
				while(node.next!=null){		
					node=node.next;
			    }        
		        node.next=newNode;
		        return head;   
	}
	
	static class Node {
		int data;
		Node next;
	}

}
