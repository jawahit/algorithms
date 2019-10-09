/**
 * 
 */
package com.problems.algorithms.week4.symboltables.bst;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.Queue;

/**
 * 
 * {@code BST} is a symbol table api representation
 * 
 * Big O: (No of Compares)
 *
 * (Average case )Search / Insert : ~ 2 ln N (Worst case ) Search /Insert : ~
 * 4.311 ln N
 * 
 * @author Thangaraj Jawahar
 *
 *         Sep 11, 2019
 * 
 *
 */
public class BST<Key extends Comparable<Key>, Value> {

	private Node root;

	public BST() {

	}

	public void put(Key key, Value val) {
		if (key == null)
			throw new IllegalArgumentException("key should n't be null");
		this.root = put(this.root, key, val);
	}

	private Node put(Node n, Key key, Value val) {
		if (n == null) {
			return new Node(key, val, 1);
		} else {
			int cmp = key.compareTo(n.key);
			if (cmp < 0)
				n.left = put(n.left, key, val);
			else if (cmp > 0)
				n.right = put(n.right, key, val);
			else
				n.value = val;
			n.count = 1 + size(n.left) + size(n.right);
		}
		return n;
	}

	public Value get(Key key) {
		Node node = this.root;
		while (node != null) {
			int cmp = key.compareTo(node.key);
			if (cmp < 0)
				node = node.left;
			else if (cmp > 0)
				node = node.right;
			else
				return node.value;
		}
		return null;

	}

	public void delete(Key key) {

	}

	public Key min() {
		if (this.root != null) {
			Node n = this.root;
			while (n != null) {
				if (n.left != null)
					n = n.left;
				else
					return n.key;
			}
		}
		return null;
	}

	public Key max() {
		if (this.root != null) {
			Node n = this.root;
			while (n != null) {
				if (n.right != null)
					n = n.right;
				else
					return n.key;
			}

		}
		return null;
	}

	public Key floor(Key key) {
		if (key == null)
			throw new IllegalArgumentException("Key should n't be null");
		Node node = floor(this.root, key);
		if (node != null)
			return node.key;
		else
			return null;
	}

	private Node floor(Node node, Key key) {
		if (node == null)
			return null;
		int comp = key.compareTo(node.key);
		if (comp == 0)
			return node;
		if (comp < 0)
			return floor(node.left, key);
		Node t = floor(node.right, key);
		if (t != null)
			return t;
		return node;
	}

	public Key ceiling(Key key) {
		if (key == null)
			throw new IllegalArgumentException("Key should n't be null");
		Node node = ceiling(this.root, key);
		if (node != null)
			return node.key;
		else
			return null;
	}

	private Node ceiling(Node node, Key key) {
		if (node == null)
			return null;
		int comp = key.compareTo(node.key);
		if (comp == 0)
			return node;
		if (comp < 0) {
			Node t = ceiling(node.left, key);
			if (t != null)
				return t;
			return node;
		}
		return ceiling(node.right, key);
	}

	public int rank(Key key) {
		if (key == null)
			throw new IllegalArgumentException("Key should n't be null");
		return rank(this.root, key);
	}

	private int rank(Node node, Key key) {
		if (node == null)
			return 0;
		int comp = key.compareTo(node.key);
		if (comp == 0)
			return size(node.left);
		else if (comp < 0)
			return rank(node.left, key);
		return 1 + size(node.left) + rank(node.right, key);
	}

	public boolean contains(Key key) {
		return get(key) != null;
	}

	public boolean isEmpty() {
		return this.root == null;
	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {
		if (node == null)
			return 0;
		return node.count;
	}

	public Iterable<Key> keys() {
		Queue<Key> q = new Queue<Key>();
		inorder(this.root, q);
		return q;
	}

	private void inorder(Node node, Queue<Key> q) {
		if (node == null)
			return;
		inorder(node.left, q);
		q.enqueue(node.key);
		inorder(node.right, q);
	}

	public Iterable<Key> levelOrder() {
		Queue<Node> q = new Queue<Node>();
		q.enqueue(this.root);
		return bfs(this.root, q);
	}

	private List<Key> bfs(Node node, Queue<Node> q) {
		List<Key> list = new ArrayList<Key>();
		while (!q.isEmpty()) {
			Node n = q.dequeue();
			list.add(n.key);
			if (n.left != null)
				q.enqueue(n.left);
			if (n.right != null)
				q.enqueue(n.right);
		}
		return list;
	}

	private class Node {
		private Key key;
		private Value value;
		private Node left, right;
		private int count;

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}

		public Node(Key key, Value value, int count) {
			this.key = key;
			this.value = value;
			this.count = count;
		}
	}

	public static void main(String args[]) {
		System.out.println("BST STarted");
		BST<String, String> bst = new BST<String, String>();
		bst.put("s", "s");
		bst.put("e", "e");
		bst.put("x", "x");
		bst.put("a", "a");
		bst.put("r", "r");
		bst.put("c", "c");
		bst.put("h", "h");
		bst.put("m", "m");
		System.out.println(bst.keys());
		System.out.println("ceiling : " + bst.ceiling("f"));
		System.out.println("floor : " + bst.floor("t"));
		System.out.println("rank : " + bst.rank("d"));
		System.out.println(bst.levelOrder());
	}
}
