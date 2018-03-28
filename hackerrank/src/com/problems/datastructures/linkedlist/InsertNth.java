package com.problems.datastructures.linkedlist;



/**
 * 
 * {@link https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem}
 * 
 * @author jawahar
 *
 */
public class InsertNth {
	
	public static void main(String args[]){
		Node node = new Node();
		node.data = 10;		
		InsertNthPosition(node,3,0);
	}
	
	static Node InsertNthPosition(Node head, int data, int position) {
		   // This is a "method-only" submission. 
		    // You only need to complete this method.
		    Node newNode = new Node();
		    newNode.data = data;
		    if(head == null){
		        head=newNode;
		        return head;
		    }
		    if(position == 0){
		        newNode.next = head;
			    head = newNode;
			    return head; 
		    }
		    int count = 1;
		    Node node = head;
		    while(count!=position){
		        node = node.next;
		        count++;
		    }
		    Node nextNode = node.next;
		    node.next = newNode;
		    newNode.next = nextNode;
		    return head;    
		}
	
	
	static class Node {
		int data;
		Node next;
	}

}
