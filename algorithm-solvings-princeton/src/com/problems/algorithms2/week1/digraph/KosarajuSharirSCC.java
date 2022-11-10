/**
 * 
 */
package com.problems.algorithms2.week1.digraph;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

/**
 * Another Strongly connected component algorithm
 * 
 * 2 pass dfs algorithm
 * 
 * time complexity: O(E + V)
 * 
 * @author Thangaraj Jawahar
 *
 * Oct 27, 2022
 * 
 *
 */
public class KosarajuSharirSCC {
	
	private boolean[] hasVisited;
	private int[] scc;
	private int count;
	
	public KosarajuSharirSCC(Digraph graph) {
		hasVisited = new boolean[graph.V()];
		scc = new int[graph.V()];
		// reverse the original digraph and do reverse post order
		DiDepthFirstOrders  depthFirstOrders = new DiDepthFirstOrders(graph.reverse());
		// do dfs as per reverse post order
		for (int v: depthFirstOrders.reversePostOrder()) {
			if (!hasVisited[v]) {
				dfs(graph, v);
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
		
	    KosarajuSharirSCC scc = new KosarajuSharirSCC(new Digraph(in));
		System.out.println("total scc: " + scc.totalSCC());
		int v = 6;
		int w = 8;
		System.out.println(v + (scc.isSCC(v, w) ? " strongly connected to " : " not connected to ") + w);
	}

}
