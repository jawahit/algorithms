/**
 * 
 */
package com.problems.algorithms2.week2.mst;

/**
 * @author Thangaraj Jawahar
 *
 * Oct 29, 2022
 * 
 *
 */
public class Edge implements Comparable<Edge>{
	
	private int v;
	private int w;
	private double weight;
	
	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int either() {
		return v;
	}
	
	public int other(int vertex) {
		if (v == vertex) {
			return w;
		}
		return v;
	}
	
	public double weight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Edge [v=" + v + ", w=" + w + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(Edge o) {
		return Double.compare(this.weight, o.weight);
	}

}
