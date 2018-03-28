package com.problems.datastructures.linkedlist;

/**
 * {@link https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem}
 * 
 * @author jawahar
 *
 */
public class ReversePrint {
	
	public static void main(String args[]) {
		Node node = new Node();
		node.data = 10;
		ReversePrintList(node);
	}
	
	static void ReversePrintList(Node head) {
		  // This is a "method-only" submission. 
		  // You only need to complete this method.
		    if(head == null){
		        return;
		    }
		    Node node = head;
		    Node prevNode = null;
		    while(node!=null){
		        Node bkupNode = node.next;
		        node.next = prevNode;
		        prevNode = node;
		        node = bkupNode;        
		    }
		    head = prevNode;
		    node = head;
		    while(node!=null){
		      System.out.println(node.data);
		      node= node.next;  
		    }    
		}
	
	static class Node {
		int data;
		Node next;
	}


}
