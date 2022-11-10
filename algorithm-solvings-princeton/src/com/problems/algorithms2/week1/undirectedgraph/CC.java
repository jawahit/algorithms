/**
 * 
 */
package com.problems.algorithms2.week1.undirectedgraph;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

/**
 * Connected components using DFS technique
 * 
 * time complexity: O(E + V)
 * 
 * @author Thangaraj Jawahar
 *
 * Oct 23, 2022
 * 
 *
 */
public class CC {
	
	private int[] cc;
	private  boolean[] hasVisited;
	private int count;

	public CC (Graph graph) {
		hasVisited = new boolean[graph.V()];
		cc = new int[graph.V()];
		for (int vertex = 0; vertex < graph.V(); vertex++) {
			if (!hasVisited[vertex]) {
				dfs(graph, vertex);
				count++;
			}
		}
	}
	
	public  void dfs(Graph graph, int v) {
		if (hasVisited[v]) {
			return;
		}
		hasVisited[v] = true;
		cc[v] = count;
		System.out.println(v);
		for (Integer vertex: graph.adj(v)) {
			if (!hasVisited[vertex]) {
				dfs(graph, vertex);
			}
		}
	}
	
    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(Graph graph, int v) {
        if (v < 0 || v >= graph.V())
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (graph.V()-1));
    }
	
	public boolean isConnected(int s, int v) {
		// ignoring validate vertex, just for local
		return cc[s] == cc[v];
	}
	
	public int count() {
		return count;
	}
	/**
	 *
	 *void
	 * @param args
	 */
	public static void main(String[] args) {
		In in = new In("/home/jawahar/dev/codes/algorithms/algorithm-solvings-princeton/resources/algorithms2/week1/tinyG.txt");
		CC cc = new CC(new Graph(in));
		int s = 9;
		int t = 12;
		System.out.println(s +" -> " + t +" is connected: " + cc.isConnected(s, t));
		System.out.println("total connected components count in graph: " + cc.count());
	}

}
