package com.problems.algorithms.week1.union.find.assignment;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * The {@code Percolation} class used to perfom the Monte Carlo simulation.<br/>
 * don't try to copy the code for assignment submission you will get caught :) 
 *
 * @author Thangaraj Jawahar <br/>
 * Feb 11, 2019
 */
public class Percolation {

	private final int size;
	private int numberOfOpenSites;
	private final int[][] sites;
	private final boolean[][] siteStatus;
	private final WeightedQuickUnionUF wqf;
	private final int sizePlusOne;	
	private int bottomRowParent;

	/**
	 * initialize the sites with n * n & the weightedQuickUnion with n * n
	 */
	public Percolation(int n) {
		validate(n);
		size = n;
		sizePlusOne = n + 1;
		siteStatus = new boolean[sizePlusOne][sizePlusOne];
		sites = new int[sizePlusOne][sizePlusOne];
		wqf = new WeightedQuickUnionUF(n * n + 1);
		int index = 1;
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n; col++) {
				sites[row][col] = index;
				index++;
			}
		}
		makeSingleParentForTopRow();
		makeSingleParentForBottomRow();
	}
	
	private void makeSingleParentForTopRow() {
		int topRowColumnIndex = 1;
		while (topRowColumnIndex <= size) {
			wqf.union(0, topRowColumnIndex);
			topRowColumnIndex++;
		}
	}

	private void makeSingleParentForBottomRow() {
		int bottomRowColumnIndex = 1;
		bottomRowParent = sites[size][bottomRowColumnIndex];
		while (bottomRowColumnIndex <= size) {
			int index = sites[size][bottomRowColumnIndex];
			wqf.union(bottomRowParent, index);
			bottomRowColumnIndex++;
		}
	}

	/**
	 * validate the size is greater than zero if it's not throw error
	 * 
	 * @param n
	 */
	private void validate(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("value should be greater than zero but it's" + n);
		}
	}

	/**
	 * validate the range
	 * 
	 * @param n
	 */
	private void validateRange(int n) {
		if (n < 1 || n > size) {
			throw new IllegalArgumentException("value should be with in the range 1 and " + size + " but it was" + n);
		}
	}

	/**
	 * validate the row & columnrange
	 * 
	 * @param n
	 */
	private void validateRowAndColumnRange(int row, int col) {
		validateRange(row);
		validateRange(col);
	}

	/**
	 * check the range
	 * 
	 * @param n
	 * @return
	 */
	private boolean isValidRange(int n) {
		if (n < 1 || n > size) {
			return false;
		}
		return true;
	}

	/**
	 * this method is used to open the blocked sites if it's not open already
	 * 
	 * @param row
	 * @param col
	 */
	public void open(int row, int col) {
		if (!isOpen(row, col)) {
			siteStatus[row][col] = true;
			int baseId = sites[row][col];
			numberOfOpenSites++;
			// check left
			if (isValidRange(col - 1)) {
				checkNeighbourStatusAndConnect(row, col - 1, baseId);
			}
			// check right
			if (isValidRange(col + 1)) {
				checkNeighbourStatusAndConnect(row, col + 1, baseId);
			}
			// check top
			if (isValidRange(row + 1)) {
				checkNeighbourStatusAndConnect(row + 1, col, baseId);
			}
			// check bottom
			if (isValidRange(row - 1)) {
				checkNeighbourStatusAndConnect(row - 1, col, baseId);
			}
		}
	}

	private void checkNeighbourStatusAndConnect(int row, int col, int baseId) {
		boolean status = siteStatus[row][col];
		if (status) {
			wqf.union(sites[row][col], baseId);
		}
	}

	/**
	 * this method is used to check whether the site is open already or not
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean isOpen(int row, int col) {
		validateRowAndColumnRange(row, col);
		return siteStatus[row][col];
	}

	/**
	 * this method is used to tell whether the given site is connected to the top
	 * row or not
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean isFull(int row, int col) {
		if (isOpen(row, col)) {
			int givenId = sites[row][col];
			if (wqf.connected(givenId, 0)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * this method tells number of open sites
	 * 
	 * @return
	 */
	public int numberOfOpenSites() {
		return numberOfOpenSites;
	}

	/**
	 * it tells whether the system percolated or not i.e., any of the bottom row is
	 * connected to top row or not
	 * 
	 * @return
	 */
	public boolean percolates() {		
		if (numberOfOpenSites >= size && wqf.connected(bottomRowParent, 0)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

	}

}

