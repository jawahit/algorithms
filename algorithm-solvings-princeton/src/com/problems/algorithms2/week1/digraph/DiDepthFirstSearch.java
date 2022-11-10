/**
 * 
 */
package com.problems.algorithms2.week1.digraph;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

/**
 * 
 * directed DFS
 * 
 * time complexity: O(E + V)
 * 
 * @author Thangaraj Jawahar
 *
 * Oct 23, 2022
 * 
 *
 */
public class DiDepthFirstSearch {
	
	private boolean[] hasVisited;
	private int[] edgeTo;
	
	public DiDepthFirstSearch(Digraph graph, int start) {
		hasVisited = new boolean[graph.V()];
		edgeTo = new int[graph.V()];
		recursive(graph, start);
	}
	
	public void recursive(Digraph graph, int v) {
		hasVisited[v] = true;
		System.out.println(v);
		for (int vertex: graph.adj(v)) {
			if (!hasVisited[vertex]) {
				edgeTo[vertex] = v;
				recursive(graph, vertex);
			}
		}
	}


	/**
	 *
	 *void
	 * @param args
	 */
	public static void main(String[] args) {
		In in = new In("/home/jawahar/dev/codes/algorithms/algorithm-solvings-princeton/resources/algorithms2/week1/tinyDG2.txt");
		Digraph digraph = new Digraph(in);
		System.out.println(digraph.toString());
		System.out.println("########### DFS ##########");
		DiDepthFirstSearch search = new DiDepthFirstSearch(digraph, 0);
	}

}
