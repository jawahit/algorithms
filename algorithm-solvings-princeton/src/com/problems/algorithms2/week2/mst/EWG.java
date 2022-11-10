/**
 * 
 */
package com.problems.algorithms2.week2.mst;

import java.util.Arrays;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Edge weighted Graph
 * 
 * @author Thangaraj Jawahar
 *
 *         Oct 29, 2022
 * 
 *
 */
public class EWG {
	
	private static final String NEWLINE = System.getProperty("line.separator");

	private final int V; // number of vertices in this EWG
	private int E; // number of edges in this EWG
	private Bag<Edge>[] adj; // adj[v] = adjacency list for vertex v
	private Bag<Edge> edges;

	public EWG(int v) {
		this.V = v;
		adj = (Bag<Edge>[]) new Bag[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new Bag<Edge>();
		}
	}

	public EWG(In in) {
		try {
			this.V = in.readInt();
			checkNegative(V);
			adj = (Bag<Edge>[]) new Bag[V];
			for (int i = 0; i < V; i++) {
				adj[i] = new Bag<Edge>();
			}
			this.E = in.readInt();
			checkNegative(E);
			edges = new Bag<Edge>();
			for (int i = 0; i < E; i++) {
				Edge edge = new Edge(in.readInt(), in.readInt(), in.readDouble());
				edges.add(edge);
				addEdge(edge);
			}
		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException("invalid input format in EWG constructor", e);
		}

	}

	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
	}

	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	public Iterable<Edge> edges() {
		return edges;
	}

	int V() {
		return V;
	}

	int E() {
		return E;
	}
	
	

	@Override
	public String toString() {
		 StringBuilder s = new StringBuilder();
	        s.append(V + " vertices, " + E + " edges " + NEWLINE);
	        for (int v = 0; v < V; v++) {
	            s.append(String.format("%d: ", v));
	            for (Edge e : adj[v]) {
	                s.append(String.format("%d=%s,", e.other(v), e.weight()));
	            }
	            s.append(NEWLINE);
	        }
	        return s.toString();
	}

	private void validateVertex(int v) {
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
	}

	private void checkNegative(int v) {
		if (v < 0)
			throw new IllegalArgumentException("vertex v shoud be non negative: " + v);
	}

	/**
	 *
	 * void
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		In in = new In("/home/jawahar/dev/codes/algorithms/algorithm-solvings-princeton/resources/algorithms2/week2/tinyEWG.txt");
		EWG ewg = new EWG(in);
		System.out.println(ewg.toString());
	}

}
