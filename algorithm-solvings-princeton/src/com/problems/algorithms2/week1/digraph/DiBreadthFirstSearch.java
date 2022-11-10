/**
 * 
 */
package com.problems.algorithms2.week1.digraph;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**
 * 
 * Directed BFS
 * 
 * time complexity: O(E + V)
 * 
 * @author Thangaraj Jawahar
 * 
 * 
 *
 * Oct 23, 2022
 * 
 *
 */
public class DiBreadthFirstSearch {
	
	private boolean[] hasVisited;
	private int[] edgeTo;
	
	public DiBreadthFirstSearch(Digraph digraph, int start) {
		hasVisited = new boolean[digraph.V()];
		edgeTo = new int[digraph.V()];
		usingQueue(digraph, start);
	}

	/**
	 *
	 *void
	 * @param digraph
	 * @param start
	 */
	private void usingQueue(Digraph digraph, int start) {
		Queue<Integer> queue = new Queue<Integer>();
		hasVisited[start] = true;
		queue.enqueue(start);
		while (!queue.isEmpty()) {
			int vertex = queue.dequeue();
			System.out.println(vertex);
			for (int w: digraph.adj(vertex)) {
				if (!hasVisited[w]) {
					queue.enqueue(w);
					hasVisited[w] = true;
				}
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
		System.out.println("########### Digraph BFS ##########");
		DiBreadthFirstSearch search = new DiBreadthFirstSearch(digraph, 0);

	}

}
