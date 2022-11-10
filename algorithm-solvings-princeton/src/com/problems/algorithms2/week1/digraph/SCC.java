/**
 * 
 */
package com.problems.algorithms2.week1.digraph;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

/**
 * Strongly connected component
 * 
 * time complexity: O(E + V)
 * 
 * @author Thangaraj Jawahar
 *
 * Oct 27, 2022
 * 
 *
 */
public class SCC {
	private boolean[] hasVisited;
	private int[] scc;
	private int count;
	
	public SCC(Digraph graph) {
		hasVisited = new boolean[graph.V()];
		scc = new int[graph.V()];
		for (int i = 0; i < graph.V(); i++) {
			if (!hasVisited[i]) {
				dfs(graph, i);
				count++;				
			}
		}
	}
	
	public void dfs(Digraph graph, int v) {
		hasVisited[v] = true;
		scc[v] = count;
		for (int vertex: graph.adj(v)) {
			if (!hasVisited[vertex]) {
				dfs(graph, vertex);
			}
		}
	}
	
	public int totalSCC() {
		return count;
	}
	
	public boolean isSCC(int v, int w) {
		return scc[v] == scc[w];
	}
	
	public static void main(String args[]) {
	    In in = new In("/home/jawahar/dev/codes/algorithms/algorithm-solvings-princeton/resources/algorithms2/week1/tinyDAG.txt");
		
		SCC scc = new SCC(new Digraph(in));
		System.out.println("total scc: " + scc.totalSCC());
		int v = 0;
		int w = 6;
		System.out.println(v + (scc.isSCC(v, w) ? " strongly connected to " : " not connected to ") + w);
	}
}

