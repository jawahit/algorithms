/**
 * 
 */
package com.problems.algorithms2.week1.undirectedgraph;

import java.util.Stack;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

/**
 * @author Thangaraj Jawahar
 *
 * Oct 22, 2022
 * 
 * time complexity: O(E + V)
 * 
 *
 */
public class DepthFirstSearch {
	
	private  boolean[] hasVisited;
	public DepthFirstSearch(Graph graph, int start, boolean useStack) {
		hasVisited = new boolean[graph.V()];
		if (!useStack) {
			recursive(graph, start);			
		} else {
			usingStack(graph, start);
		}
	}
	
	public  void recursive(Graph graph, int v) {
		hasVisited[v] = true;
		System.out.println(v);
		for (Integer vertex: graph.adj(v)) {
			if (!hasVisited[vertex]) {
				recursive(graph, vertex);
			}
		}
	}
	
	public  void usingStack(Graph g, int start) {
		Stack<Integer> stack = new Stack();
		stack.push(start);
		hasVisited[start] = true;
		
		while(!stack.isEmpty()) {
			Integer v = stack.pop();			
			System.out.println(v);
			for (Integer vertex: g.adj(v)) {
				if (!hasVisited[vertex]) {
					hasVisited[vertex] = true;
					stack.push(vertex);
				}
			}
		}
	}
	
	public boolean isConnected(int v) {
		return hasVisited[v];
	}

	/**
	 *
	 *void
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		In in = new In("/home/jawahar/dev/codes/algorithms/algorithm-solvings-princeton/resources/algorithms2/week1/tinyG.txt");
		Graph graph = new Graph(in);
		System.out.println(graph.toString());
		System.out.println("############## DFS recursive ##########");
		DepthFirstSearch dfs = new DepthFirstSearch(graph, 9, false);
		int v = 0;
		System.out.println(v + " isConnected to source: " + dfs.isConnected(0));
		System.out.println("############## DFS stack ##########");
		DepthFirstSearch dfsByStack = new DepthFirstSearch(graph, 0, true);
	}

}
