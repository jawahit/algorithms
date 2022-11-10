/**
 * 
 */
package com.problems.algorithms2.week1.undirectedgraph;



import java.util.Stack;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**
 * @author Thangaraj Jawahar
 *
 * Oct 23, 2022
 * 
 * time complexity: O(E + V)
 * 
 *
 */
public class BreadthFirstSearch {
	
	private boolean[] hasVisited;
	private int[] edgeTo;
	
	public BreadthFirstSearch(Graph graph, int start) {
		hasVisited = new boolean[graph.V()];
		edgeTo = new int[graph.E()];
		usingQueue(graph, start);
	}
	
	private void usingQueue(Graph graph, int v) {
		Queue<Integer> queue = new Queue<Integer>();
		
		queue.enqueue(v);
		hasVisited[v] = true;
		while (!queue.isEmpty()) {
			int w = queue.dequeue();
			System.out.println(w);
			for (int vertex: graph.adj(w)) {
				if (!hasVisited[vertex]) {
					hasVisited[vertex] = true;
					queue.enqueue(vertex);
					edgeTo[vertex] = w;
				}
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return hasVisited[v];
	}
	
	public Iterable<Integer> pathTo(int s, int v) {
		Stack<Integer> stack = new Stack<Integer>();
		if (!hasVisited[v]) return null;
		for (int i=v; i!=s; i=edgeTo[i]) {
			stack.push(i);
		}
		stack.push(s);
		return stack;
	}

	/**
	 *
	 *void
	 * @param args
	 */
	public static void main(String[] args) {
		In in = new In("/home/jawahar/dev/codes/algorithms/algorithm-solvings-princeton/resources/algorithms2/week1/tinyG.txt");
		Graph graph = new Graph(in);
		System.out.println(graph.toString());
		System.out.println("############## BFS Queue ###########");
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);
		int start = 0;
		int end = 3;
		System.out.println( start + " -> " + end);
		if (bfs.hasPathTo(end)) {
			for (Integer vertex: bfs.pathTo(start, end)) {
				System.out.print(vertex +" ");
			}			
		} else {
			System.out.println("NO path available");
		}
	}

}
