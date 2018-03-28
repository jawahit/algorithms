package com.problems.datastructures.linkedlist;


/**
 * {@link https://www.hackerrank.com/challenges/compare-two-linked-lists/problem}
 * 
 * @author jawahar
 *
 */
public class compareTwoLinkedLists {
	
	public static void main(String args[]) {
		Node nodeA = new Node();
		nodeA.data = 10;
		Node nodeB = new Node();
		nodeB.data = 10;
		CompareLists(nodeA, nodeB);
	}
	
	static int CompareLists(Node headA, Node headB) {
	    // This is a "method-only" submission. 
	    // You only need to complete this method
	    if(headA == null && headB == null){
	        return 1;
	    }
	    
	    Node aNode = headA;
	    Node bNode = headB;
	    while(aNode!=null){
	        if(aNode.data != bNode.data){
	            return 0;
	        }
	        aNode = aNode.next;
	        bNode = bNode.next;        
	    }
	    if(aNode == null && bNode == null){
	        return 1;    
	    }
	    return 0;  
	}
	
	static class Node {
		int data;
		Node next;
	}

}
