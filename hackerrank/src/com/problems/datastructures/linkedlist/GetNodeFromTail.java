package com.problems.datastructures.linkedlist;



/**
 * {@link https://www.hackerrank.com/domains/data-structures/linked-lists/1}
 * 
 * @author jawahar
 * 
 * used tortoise & hare technique to find the total length and then 
 * searching is more than mid of the list then continue from there it self to find 
 * the node index else search from start till mid 
 *
 */
public class GetNodeFromTail {
	
	
	public static void main(String args[]) {
		Node nodeA = new Node();
		nodeA.data = 10;
		GetNode(nodeA, 2);
	}
	
	static int GetNode(Node head,int n) {
	     // This is a "method-only" submission. 
	     // You only need to complete this method. 
	    if(head == null){
	        return 0;
	    }    
	    int total = 0;    
	    Node tortoiseRunner = head;
	    Node hareRunner = head;
	    int count = 0;
	    while(hareRunner.next!=null && hareRunner.next.next!=null){        
	        tortoiseRunner = tortoiseRunner.next;        
	        hareRunner = hareRunner.next.next;        
	        count++;
	    }
	    if(hareRunner.next!=null){
	        count++;
	        total = count * 2;
	    }else{
	        total = count * 2;
	        total++;        
	    }
	    
	    int totalIndex = total - 1;
	    int toSearch = totalIndex - n;
	    Node node = head;
	    int counting = 0;
	    count = totalIndex / 2;
	    if(toSearch > count){
	        node = tortoiseRunner;
	        counting = count;
	    }   
	    while(counting!=toSearch){
	        node = node.next;
	        counting++;
	    }
	    return node.data;
	}
	
	
	static class Node {
		int data;
		Node next;
	}


}
