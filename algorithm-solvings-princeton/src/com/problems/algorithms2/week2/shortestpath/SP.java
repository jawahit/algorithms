/**
 * 
 */
package com.problems.algorithms2.week2.shortestpath;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Shortest path implementation from s to v
 * 
 * @author Thangaraj Jawahar
 *
 * Nov 7, 2022
 * 
 *
 */
public class SP {
	
	private EWDG ewdg;
	private int s;
	public SP(EWDG ewdg, int s) {
		this.ewdg = ewdg;
		this.s = s;
	}
	
	public double distTo(int v) {
		double weight = 0;

		return weight;
	}
	
	public boolean hasPathTo(int v) {
		return false;
	}
	
	public Iterable<DirectedEdge> pathTo(int v) {
		Bag<DirectedEdge> fullPath = new Bag<DirectedEdge>();

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
		SP sp = new SP(ewdg, 0);
		int dest = 6;
		System.out.println(sp.distTo(dest));
		for (DirectedEdge de: sp.pathTo(dest)) {
			System.out.print(de + " ");
		}
		System.out.println();
	}

}
