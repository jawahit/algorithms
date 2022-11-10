/**
 * 
 */
package com.problems.algorithms2.week2.mst;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

/**
 * Kruskal's Minimum spanning tree implementation
 * 
 * mst conditions
 * 1. shouldn't form a cycle
 * 2. should find min edges and connects the component
 * 3. mst size should be < vertexes of graph (ie., G.V()) -1
 * 
 * implementation:
 *  1. prepare Edge weighted graph
 *  2. sort all the edges by weight
 *  3. iterate the edges and connect the vertex (if not form a cycle)
 *  
 *  Data structures used:
 *    1. MinPriorityQueue (can also be done using Sorting, but this is efficient)
 *    2. Union Find (Data structure from Algorithms1 week1 course)
 * 
 * @author Thangaraj Jawahar
 *
 *         Oct 29, 2022
 * 
 *
 */
public class KruskalsMST {

	private Queue<Edge> mst = new Queue<Edge>();

	public KruskalsMST(EWG ewg) {
		// 1. sort by weight
		MinPQ<Edge> pq = new MinPQ<Edge>();
		for (Edge e : ewg.edges()) {
			pq.insert(e);
		}	
		// prepare UF with vertex;
		UF uf = new UF(ewg.V());
		while (!pq.isEmpty() && mst.size() < ewg.V()-1) {
			Edge edge = pq.delMin();
			int v = edge.either();
			int w = edge.other(v);
			// to check that it's not forming a cycle
			if (!uf.connected(v, w)) {
				uf.union(v, w);
				mst.enqueue(edge);
			}
		}
	}

	public Iterable<Edge> edges() {
		return mst;
	}

	public double weight() {
		double weight = 0;
		for (Edge e : mst) {
			weight += e.weight();
		}
		return weight;
	}

	/**
	 *
	 * void
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		In in = new In(
				"/home/jawahar/dev/codes/algorithms/algorithm-solvings-princeton/resources/algorithms2/week2/tinyEWG.txt");
		EWG ewg = new EWG(in);
		KruskalsMST kruskalsMST = new KruskalsMST(ewg);
		System.out.println("kruskal's mst weight: " + kruskalsMST.weight());
		for (Edge edge : kruskalsMST.edges()) {
			System.out.println(edge.toString());
		}

	}

}
