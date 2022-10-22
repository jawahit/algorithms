/**
 * 
 */
package com.problems.algorithms.week4.symboltables.bst;

/**
 * @author Thangaraj Jawahar
 *
 * Nov 17, 2019
 * 
 * Symbol table interface
 * 
 *
 */
public interface ST<Key extends Comparable<Key>, Value> {
	
	public void put(Key key, Value val);
	public Key min() ;
	public Value get(Key key);
	public Key max();
	public Key floor(Key key);
	public Key ceiling(Key key);
	public int rank(Key key);
	public boolean contains(Key key);
	public boolean isEmpty();
	public int size();
	public void deleteMin();
	public void deleteMax();
	public void delete(Key k);
	public Iterable<Key> keys(); 
	public Iterable<Key> levelOrder(); //bfs
	public int size(Key lo, Key hi);
	public int rangeCount(Key lo,Key hi);
	public Iterable<Key> rangeSearch(Key lo, Key hi);
	

}
