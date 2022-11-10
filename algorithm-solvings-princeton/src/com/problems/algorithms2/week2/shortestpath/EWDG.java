/**
 * 
 */
package com.problems.algorithms2.week2.shortestpath;

import java.util.NoSuchElementException;

import com.problems.algorithms2.week2.mst.EWG;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 *  Edge Weighted Digraph
 * 
 * @author Thangaraj Jawahar
 *
 * Nov 7, 2022
 * 
 *
 */
public class EWDG {
	
	private static final String NEWLINE = System.getProperty("line.separator");
	
	private int V; // number of vertices in this EWDG
	private int E; // number of edges in this EWDG
	private Bag<DirectedEdge>[] adj; // adj[v] = adjacency list for vertex v
	private int[] indegree;             // indegree[v] = indegree of vertex v

	public EWDG(int v) {
		this.V = v;
		adj = (Bag<DirectedEdge>[]) new Bag[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new Bag<DirectedEdge>();
		}
	}

	public EWDG(In in) {
		try {
			this.V = in.readInt();
			checkNegative(V);
			adj = (Bag<DirectedEdge>[]) new Bag[V];
			for (int i = 0; i < V; i++) {
				adj[i] = new Bag<DirectedEdge>();
			}
			this.E = in.readInt();
			checkNegative(E);
			indegree = new int[V];
			for (int i = 0; i < E; i++) {
				DirectedEdge directedEdge = new DirectedEdge(in.readInt(), in.readInt(), in.readDouble());
				addEdge(directedEdge);
			}
		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException("invalid input format in EWDG constructor", e);
		}

	}

	public void addEdge(DirectedEdge e) {
		adj[e.from()].add(e);
		indegree[e.to()]++;
	}

	public Iterable<DirectedEdge> adj(int v) {
		return adj[v];
	}

    public int outdegree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    public int indegree(int v) {
        validateVertex(v);
        return indegree[v];
    }
    

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> list = new Bag<DirectedEdge>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj(v)) {
                list.add(e);
            }
        }
        return list;
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
	            for (DirectedEdge e : adj[v]) {
	                s.append(String.format("%d=%s,", e.to(), e.weight()));
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
		In in = new In("/home/jawahar/dev/codes/algorithms/algorithm-solvings-princeton/resources/algorithms2/week2/tinyEWD.txt");
		EWDG ewdg = new EWDG(in);
		System.out.println(ewdg.toString());
	}

}
