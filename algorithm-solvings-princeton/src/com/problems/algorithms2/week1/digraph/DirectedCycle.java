/**
 * 
 */
package com.problems.algorithms2.week1.digraph;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * Detect a cycle is there is one in graph, using DFS
 * 
 * time complexity: O(E + V)
 * 
 * @author Thangaraj Jawahar
 *
 * Oct 24, 2022
 * 
 *
 */
public class DirectedCycle {
	
	private boolean[] hasVisited;
	private int[] edgeTo;
	private boolean[] isOnStack;
	private Stack<Integer> cycle;
	
	public DirectedCycle(Digraph graph) {
		hasVisited = new boolean[graph.V()];
		edgeTo = new int[graph.V()];
		isOnStack = new boolean[graph.V()];
		for (int vertex = 0; vertex < graph.V(); vertex++) {
			if (!hasVisited[vertex] && cycle == null) {
				dfs(graph, vertex);				
			}
		}
	}
	
	public void dfs(Digraph graph, int v) {
		isOnStack[v] = true;
		hasVisited[v] = true;
		// System.out.println(v);
		for (int vertex: graph.adj(v)) {
			
			// check for cycle, if not null then cycle detected so return
			if (cycle != null) {
				return;
			}
			// do recursive for new vertex
			if (!hasVisited[vertex]) {
				edgeTo[vertex] = v;
				dfs(graph, vertex);
			}
			// cycle found, hence prepare the cycle path
			else if (isOnStack[vertex]) {
				cycle = new Stack<Integer>();
				for (int i = v; i != vertex; i = edgeTo[i]) {
					cycle.push(i);
				}
				cycle.push(vertex);
				cycle.push(v);
				assert check();
			}
		}
		isOnStack[v] = false;		
	}
	
	public boolean hasCycle() {
		return cycle != null;
	}
	
	public Iterable<Integer> cyclePath() {
		return hasCycle() ? cycle : null;
	}
	
	public boolean check() {
		int first = -1, last = -1;
		for(Integer i: cycle) {
			if (first == -1) first = i;
			last = i;
		}
		
		if (first != last) {
			System.out.println("No cyle found");
			return false;
		}
		return true;
	}

	/**
	 *
	 *void
	 * @param args
	 */
	public static void main(String[] args) {
		In in = new In("/home/jawahar/dev/codes/algorithms/algorithm-solvings-princeton/resources/algorithms2/week1/tinyDAG.txt");
		
		Digraph graph = new Digraph(in);
		//Digraph copyGraph = new Digraph(graph);
		System.out.println(graph);
		//System.out.println(copyGraph);
		
		DirectedCycle diCycle = new DirectedCycle(graph);
		
		if (diCycle.hasCycle()) {
			System.out.println("There is a cycle !!!");
			for(Integer i: diCycle.cyclePath()) {
				System.out.println(i + " ");
			}
		} else {
			System.out.println("No Cycle found");
		}
	}

}
