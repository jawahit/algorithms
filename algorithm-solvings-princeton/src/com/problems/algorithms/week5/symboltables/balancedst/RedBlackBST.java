/**
 * 
 */
package com.problems.algorithms.week5.symboltables.balancedst;

import com.problems.algorithms.week4.symboltables.bst.ST;

/**
 * @author Thangaraj Jawahar
 *
 *         Nov 21, 2019
 * 
 *
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private Node root = null;

	@Override
	public void put(Key key, Value val) {
		this.root = insert(this.root, key, val);
		this.root.color = BLACK;
	}

	/*
	 * red-black BST properties right child red,left child black - rotateLeft left
	 * child , left left child red - rotateRight both children red - flipColors
	 * 
	 */
	private Node insert(Node x, Key key, Value val) {
		if (x == null) {
			x = new Node(key, val, 1);
			x.color = RED;
			return x;
		}
		int c = key.compareTo(x.key);
		if (c < 0)
			x.left = insert(x.left, key, val);
		else if (c > 0)
			x.right = insert(x.right, key, val);
		else
			x.value = val;

		if (isRed(x.right) && !isRed(x.left))
			x = rotateLeft(x);
		if (isRed(x.left) && isRed(x.left.left))
			x = rotateRight(x);
		if (isRed(x.left) && isRed(x.right))
			flipColors(x);
		return x;
	}

	@Override
	public Key min() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value get(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key max() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key floor(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key ceiling(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int rank(Key key) {
		// TODO Auto-generated method stub
		return this.rank(this.root, key);
	}

	private int rank(Node x, Key k) {
		if (x == null)
			return 0;
		int comp = k.compareTo(x.key);
		if (comp == 0)
			return size(x.left);
		else if (comp < 0)
			return rank(x.left, k);
		return 1 + size(x.left) + rank(x.right, k);
	}

	@Override
	public boolean contains(Key key) {
		// TODO Auto-generated method stub
		return this.get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.root == null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size(this.root);
	}

	private int size(Node x) {
		if (x == null)
			return 0;
		return x.count;
	}

	@Override
	public void deleteMin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMax() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Key k) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterable<Key> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Key> levelOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	private Node rotateLeft(Node x) {
		assert isRed(x.right);
		Node head = x.right;
		x.right = head.left;
		head.left = x;
		head.color = x.color;
		x.color = RED;
		return head;
	}

	private Node rotateRight(Node x) {
		assert isRed(x.left);
		Node head = x.left;
		x.left = head.right;
		head.right = x;
		head.color = x.color;
		x.color = RED;
		return head;
	}

	private void flipColors(Node x) {
		assert !isRed(x);
		assert isRed(x.left);
		assert isRed(x.right);
		x.color = RED;
		x.left.color = BLACK;
		x.right.color = BLACK;
	}

	private boolean isRed(Node x) {
		if (x == null)
			return false;
		return x.color == RED;
	}

	private class Node {
		private Key key;
		private Value value;
		private Node left, right;
		private int count;
		private boolean color;

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

	@Override
	public int size(Key lo, Key hi) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rangeCount(Key lo, Key hi) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<Key> rangeSearch(Key lo, Key hi) {
		// TODO Auto-generated method stub
		return null;
	}

}
