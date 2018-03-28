package com.problems.datastructures.linkedlist;



/**
 * {@link https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem}
 * 
 * @author jawahar
 *
 */
public class MergeTwoSortedLinkedList {
	
	public static void main(String args[]) {
		Node nodeA = new Node();
		nodeA.data = 10;
		Node nodeB = new Node();
		nodeB.data = 10;
		mergeLists(nodeA, nodeB);
	}
	
	static Node mergeLists(Node headA, Node headB) {
	     // This is a "method-only" submission. 
	     // You only need to complete this method 
	    if(headA == null || headB == null){
	        return headA == null ? headB : headA;
	    }
	    Node lowerNode = null;
	    Node higherNode = null;
	    if(headA.data > headB.data){
	        higherNode = headA;
	        lowerNode = headB;        
	    }else{
	        higherNode = headB;
	        lowerNode = headA;        
	    }
	    Node lowerNodeTemp = lowerNode;
	    while(lowerNodeTemp.next!=null && higherNode!=null){
	        if(lowerNodeTemp.next.data > higherNode.data){
	            int data = higherNode.data;
	            higherNode = higherNode.next;
	            Node lowerBkupNode = lowerNodeTemp.next;
	            Node newNode = new Node();
	            newNode.data = data;
	            newNode.next = lowerBkupNode;
	            lowerNodeTemp.next = newNode;            
	        }else{
	            lowerNodeTemp = lowerNodeTemp.next;
	        }
	    }
	    if(higherNode!=null){
	        lowerNodeTemp.next = higherNode;
	    }
	   return lowerNode;
	}
	
	
	static class Node {
		int data;
		Node next;
	}

}
