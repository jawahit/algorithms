/**
 * 
 */
package com.problems.algorithms2.week2.mst;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;

/**
 * My own implementation of Prims Minimum Spannig tree eager way
 * 
 * 
 * @author Thangaraj Jawahar
 *
 * Nov 6, 2022
 * 
 *
 */
public class PrimsMSTEager {
	
	private Queue<Edge> mst = new Queue<Edge>();
	private boolean[] isInMST; // mst vertices 
	IndexMinPQ<Edge> pq;
	
	public PrimsMSTEager(EWG ewg) {
		 pq = new IndexMinPQ<Edge>(ewg.V());
		 isInMST = new boolean[ewg.V()];
		 checkAndAddtoPQIfnotInMST(ewg, 0); // fill the priority queue from adj of 0
		 while (!pq.isEmpty()) {
			 mst.enqueue(pq.minKey());
			 int minVertex = pq.delMin();
			 checkAndAddtoPQIfnotInMST(ewg, minVertex);					 
		 }
	}
	
	public void checkAndAddtoPQIfnotInMST(EWG ewg, int v) {
		isInMST[v] = true;
		for(Edge e: ewg.adj(v)) {
			int w = e.other(v);
			// make sure, queue not contains the other edges pair
			if (!isInMST[w] && !pq.contains(w)) {
				pq.insert(w, e);
			} else if (pq.contains(w)) { // if pq contains edge, then check for their weight if lesser update the PQ for that vertex edge
				 Edge pqEdge = pq.keyOf(w);
				 if (e.weight() < pqEdge.weight()) {
					 pq.decreaseKey(w, e);
				 }
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

	
	public static void main(String[] args) {
		 In in = new In("/home/jawahar/dev/codes/algorithms/algorithm-solvings-princeton/resources/algorithms2/week2/tinyEWG.txt");
		// mediumEWG.txt
		//In in = new In("/home/jawahar/Desktop/largeEWG.txt");
		EWG ewg = new EWG(in);
		PrimsMSTEager primsMSTEager = new PrimsMSTEager(ewg);
		System.out.println("prim's Eager mst weight: " + primsMSTEager.weight());
		/*for (Edge edge : primsMSTEager.edges()) {
			System.out.println(edge.toString());
		}*/

	}

}
