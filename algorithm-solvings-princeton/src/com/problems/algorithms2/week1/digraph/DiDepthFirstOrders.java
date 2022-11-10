/**
 * 
 */
package com.problems.algorithms2.week1.digraph;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 *  Directed DFS pre,post & reverse post orders
 * 
 * @author Thangaraj Jawahar
 *
 * Oct 26, 2022
 * 
 *
 */
public class DiDepthFirstOrders {
	
	private boolean[] hasVisited;
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reversePost;
	
	public DiDepthFirstOrders(Digraph graph) {
		hasVisited = new boolean[graph.V()];
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();
		dfs(graph, 0);
	}
	
	public void dfs(Digraph graph, int v) {
		hasVisited[v] = true;
		pre.enqueue(v);
		System.out.println(v);
		for (int vertex: graph.adj(v)) {
			if (!hasVisited[vertex]) {
				dfs(graph, vertex);
			}
		}
		post.enqueue(v);
		reversePost.push(v);
	}
	
	public Iterable<Integer> preOrder() {
		return pre;
	}
	
	public Iterable<Integer> postOrder() {
		return post;
	}
	
	public Iterable<Integer> reversePostOrder() {
		return reversePost;
	}

	/**
	 *
	 *void
	 * @param args
	 */
	public static void main(String[] args) {
        In in = new In("/home/jawahar/dev/codes/algorithms/algorithm-solvings-princeton/resources/algorithms2/week1/tinyDAG.txt");
		System.out.println("##### DFS ####");
        DiDepthFirstOrders dfsOrders = new DiDepthFirstOrders(new Digraph(in));
        System.out.println("DFS == pre order, how ever we r printing both");
        // pre order
        System.out.println("### Pre order ###");
        for (Integer v: dfsOrders.preOrder()) {
        	System.out.print(v + " ");
        }
        System.out.println();
        // post order
        System.out.println("### Post order ###");
        for (Integer v: dfsOrders.postOrder()) {
        	System.out.print(v + " ");
        }
        System.out.println();
        // reverse post  order
        System.out.println("### reverse post order or topological sort (if DAG)###");
        for (Integer v: dfsOrders.reversePostOrder()) {
        	System.out.print(v + " ");
        }
        System.out.println();
        
	}

}
