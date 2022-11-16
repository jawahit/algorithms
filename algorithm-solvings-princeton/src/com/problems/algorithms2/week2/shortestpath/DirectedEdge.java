/**
 * 
 */
package com.problems.algorithms2.week2.shortestpath;

/**
 * Direct Edge API implementation
 * 
 * @author Thangaraj Jawahar
 *
 * Nov 7, 2022
 * 
 *
 */
public class DirectedEdge implements Comparable<DirectedEdge>{
	
	private int v;
	private int w;
	private double weight;
	
	public DirectedEdge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int from() {
		return v;
	}
	
	public int to() {
		return w;
	}
	
	public double weight() {
		return weight;
	}

	@Override
	public String toString() {
		return "DirectedEdge [v=" + v + ", w=" + w + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(DirectedEdge o) {
		// TODO Auto-generated method stub
		return Double.compare(this.weight, o.weight);
	}

}
