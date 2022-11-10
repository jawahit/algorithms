/**
 * 
 */
package com.problems.algorithms2.week2.mst;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

/**
 * Prim's minimum spanning tree algorithm implementation - Lazy Approach using minPQ
 * 
 *  approach:
 *     1. Start with vertex 0 and greedily grow tree T
 *     2. Add to T min weight edge with exactly one endpoint in T
 *     3. Repeat until v-1 edges
 * 
 * @author Thangaraj Jawahar
 *
 * Oct 29, 2022
 * 
 *
 */
public class PrimsMSTLazy {
	
	private Queue<Edge> mst = new Queue<Edge>();
	private boolean[] isInMST; // mst vertices 
	MinPQ<Edge> pq = new MinPQ<Edge>();
	
	
	public PrimsMSTLazy(EWG ewg) {
		isInMST = new boolean[ewg.V()];
		checkAndAddtoPQIfnotInMST(ewg, 0);
		while(!pq.isEmpty()) {
			Edge minEdge = pq.delMin();
			int v = minEdge.either();
			int w = minEdge.other(v);
			if (!isInMST[v] || !isInMST[w]) {
				mst.enqueue(minEdge);
				if (!isInMST[v]) checkAndAddtoPQIfnotInMST(ewg, v);
				if (!isInMST[w]) checkAndAddtoPQIfnotInMST(ewg, w);
			}
		}
	}
	
	public Iterable<Edge> edges() {
		return mst;
	}
	
	public void checkAndAddtoPQIfnotInMST(EWG ewg, int v) {
		isInMST[v] = true;
		for(Edge e: ewg.adj(v)) {
			if (!isInMST[e.other(v)]) // make sure, queue not contains the other edges pair 
			pq.insert(e);
		}
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
	 *void
	 * @param args
	 */
	public static void main(String[] args) {
		In in = new In(
				"/home/jawahar/dev/codes/algorithms/algorithm-solvings-princeton/resources/algorithms2/week2/tinyEWG.txt");
		EWG ewg = new EWG(in);
		PrimsMSTLazy primsMSTLazy = new PrimsMSTLazy(ewg);
		System.out.println("prim's Lazy mst weight: " + primsMSTLazy.weight());
		for (Edge edge : primsMSTLazy.edges()) {
			System.out.println(edge.toString());
		}

	}

}
