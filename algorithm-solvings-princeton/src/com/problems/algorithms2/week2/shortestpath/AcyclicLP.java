/**
 * 
 */
package com.problems.algorithms2.week2.shortestpath;

import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Topological;

/**
 * @author Thangaraj Jawahar
 *
 * Nov 13, 2022
 * 
 *
 */
public class AcyclicLP {

	private edu.princeton.cs.algs4.DirectedEdge[] edgeTo;
	private double[] distTo;
	
	public AcyclicLP(EdgeWeightedDigraph ewdg, int source) {
		edgeTo = new edu.princeton.cs.algs4.DirectedEdge[ewdg.V()];
		distTo = new double[ewdg.V()];
		for (int i = 1; i < ewdg.V(); i++) {
			distTo[i] = Double.NEGATIVE_INFINITY;
		}
		distTo[source] = 0;
		Topological topological = new Topological(ewdg);
		for (int v : topological.order()) {
			for (edu.princeton.cs.algs4.DirectedEdge de: ewdg.adj(v)) {
				relax(de);
			}
		}
	}
	
	private void relax(edu.princeton.cs.algs4.DirectedEdge de) {
		int v = de.from(), w = de.to();
		// if already computed distance is greater than current distance, then update it
		if (distTo[w] < distTo[v] + de.weight()) {
			distTo[w] = distTo[v] + de.weight();
			edgeTo[w] = de;
		}
	}
	
	 public boolean hasPathTo(int v) {
	        return distTo[v] > Double.NEGATIVE_INFINITY;
	 }
	
	public double distTo(int v) {
		return distTo[v];
	}
	
	public Iterable<edu.princeton.cs.algs4.DirectedEdge> pathTo(int v) {
		Stack<edu.princeton.cs.algs4.DirectedEdge> fullPath = new Stack<edu.princeton.cs.algs4.DirectedEdge>();
		for (edu.princeton.cs.algs4.DirectedEdge edge = edgeTo[v]; edge != null; edge = edgeTo[v]) {
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
		In in = new In("/home/jawahar/dev/codes/algorithms/algorithm-solvings-princeton/resources/algorithms2/week2/tinyEWDAG.txt");
		EdgeWeightedDigraph ewdg = new EdgeWeightedDigraph(in);
		int s = 5;
		AcyclicLP sp = new AcyclicLP(ewdg, s);
		for (int v = 0; v < ewdg.V(); v++) {
            if (sp.hasPathTo(v)) {
                System.out.printf("%d to %d (%.2f)  ", s, v, sp.distTo(v));
                for (edu.princeton.cs.algs4.DirectedEdge e : sp.pathTo(v)) {
                	System.out.print(e + "   ");
                }
                System.out.println();
            }
            else {
            	System.out.printf("%d to %d         no path\n", s, v);
            }
        }
	}
	
	

}
