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
public class BST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

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

	private Node min(Node n) {
		if (n != null) {
			Node x = n;
			while (x != null) {
				if (x.left != null)
					x = x.left;
				else
					return x;
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

	@Override
	public Iterable<Key> rangeSearch(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("left key value shouldn't be null");
        if (hi == null) throw new IllegalArgumentException("right key value shouldn't be null");
		Queue<Key> queue = new Queue<Key>();
		if (this.root != null) {
			rangeSearch(root, lo, hi, queue);
		}
		return queue;
	}

	public void rangeSearch(Node x, Key lo, Key hi, Queue<Key> queue) {
		if (x == null)
			return;
		int compLo = lo.compareTo(x.key);
		int compHi = hi.compareTo(x.key);
		if (compLo < 0)
			rangeSearch(x.left, lo, hi, queue);
		if (compLo <= 0 && compHi >= 0)
			queue.enqueue(x.key);
		if (compHi > 0)
			rangeSearch(x.right, lo, hi, queue);
	}

	private Node find(Node x, Key k) {
		int c = k.compareTo(x.key);
		if (c == 0)
			return x;
		if (c < 0)
			return find(x.left, k);
		else
			return find(x.right, k);
	}

	@Override
	public int rangeCount(Key lo, Key hi) {
		// TODO Auto-generated method stub
		return size(lo, hi);
	}

	@Override
	public int size(Key lo, Key hi) {
		if (contains(hi))
			return rank(hi) - rank(lo) + 1;
		else
			return rank(hi) - rank(lo);
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

	public void deleteMin() {
		this.root = deleteMin(this.root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}

	public void deleteMax() {
		this.root = deleteMax(this.root);
	}

	private Node deleteMax(Node n) {
		if (n.right == null)
			return n.left;
		n.right = deleteMax(n.right);
		n.count = 1 + size(n.left) + size(n.right);
		return n;
	}

	public void delete(Key k) {
		this.root = delete(this.root, k);
	}

	/*
	 * Follows hibbard deletion pattern Average case is Sqrt N
	 * 
	 */
	private Node delete(Node n, Key k) {
		if (n == null)
			return null;
		int comp = k.compareTo(n.key);
		if (comp < 0) {
			n.left = delete(n.left, k);
		} else if (comp > 0) {
			n.right = delete(n.right, k);
		} else {
			if (n.right == null)
				return n.left;
			if (n.left == null)
				return n.right;
			Node x = n;
			n = min(x.right);
			n.right = deleteMin(x.right);
			n.left = x.left;
		}
		n.count = size(n.left) + size(n.right) + 1;
		return n;
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
		System.out.println("rank : " + bst.rank("c"));
		System.out.println(bst.levelOrder());
	}

}
