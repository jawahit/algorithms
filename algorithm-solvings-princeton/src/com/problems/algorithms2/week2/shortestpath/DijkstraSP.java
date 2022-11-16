/**
 * 
 */
package com.problems.algorithms2.week2.shortestpath;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

/**
 * @author Thangaraj Jawahar
 *
 * Nov 12, 2022
 * 
 *
 */
public class DijkstraSP {
	
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	// this can be done by just adding, Double to IndexMinPQ
	private IndexMinPQ<DirectedEdge> pq;

	
	public DijkstraSP(EWDG ewdg) {
		edgeTo = new DirectedEdge[ewdg.V()];
		distTo = new double[ewdg.V()];
		for (int i = 1; i < ewdg.V(); i++) {
			distTo[i] = Double.POSITIVE_INFINITY;
		}
		distTo[0] = 0;
		pq = new IndexMinPQ<DirectedEdge>(ewdg.V());
		checkAndAddToShortestPath(ewdg, 0);
		while (!pq.isEmpty()) {
			int minVertex = pq.delMin();
			checkAndAddToShortestPath(ewdg, minVertex);
		}	
	}
	
	public void checkAndAddToShortestPath(EWDG ewdg,int v) {
		for (DirectedEdge edge: ewdg.adj(v)) {
			relax(edge);
		}
	}
	
	
	private void relax(DirectedEdge de) {
		int v = de.from(), w = de.to();
		// if already computed distance is greater than current distance, then update it
		if (distTo[w] > distTo[v] + de.weight()) {
			distTo[w] = distTo[v] + de.weight();
			edgeTo[w] = de;
			if (!pq.contains(w)) {
				pq.insert(w, de);
			} else {
				pq.decreaseKey(w, de);
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return false;
	}
	
	public double distTo(int v) {
		return distTo[v];
	}
	
	public Iterable<DirectedEdge> pathTo(int v) {
		Stack<DirectedEdge> fullPath = new Stack<DirectedEdge>();
		for (DirectedEdge edge = edgeTo[v]; edge != null; edge = edgeTo[v]) {
			fullPath.push(edge);
			v = edge.from();
		}
		return fullPath;
	}

	/**
	 *
	 *void
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		In in = new In("/home/jawahar/dev/codes/algorithms/algorithm-solvings-princeton/resources/algorithms2/week2/tinyEWD.txt");
		EWDG ewdg = new EWDG(in);
		DijkstraSP sp = new DijkstraSP(ewdg);
		int dest = 1;
		System.out.println(sp.distTo(dest));
		for (DirectedEdge de: sp.pathTo(dest)) {
			System.out.print(de + " ");
		}
		System.out.println();
	}

}
