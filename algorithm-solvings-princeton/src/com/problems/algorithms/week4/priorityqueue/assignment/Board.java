/**
 * 
 */
package com.problems.algorithms.week4.priorityqueue.assignment;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Week 4 assignment 8Puzzle
 * @author Thangaraj Jawahar
 *
 *         Aug 3, 2019
 * 
 *
 */
public class Board {

	private int[][] tiles = null;
	private int N;

	// create a board from an n-by-n array of tiles,
	// where tiles[row][col] = tile at (row, col)
	public Board(int[][] tiles) {
		if (tiles == null) {
			throw new java.lang.IllegalArgumentException("it shouldn't be null");
		}
		this.N = tiles.length;
		this.tiles = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				this.tiles[i][j] = tiles[i][j];
			}
		}
	}

	// string representation of this board
	public String toString() {
		int n = this.dimension();
		StringBuilder str = new StringBuilder();
		str.append(n);
		str.append("\n");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				str.append(this.tiles[i][j] + " ");
			}
			str.append("\n");
		}
		return str.toString();
	}

	// board dimension n
	public int dimension() {
		return N;
	}

	// number of tiles out of place
	public int hamming() {
		int count = 1;
		int invalidCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (this.tiles[i][j] != count) {
					invalidCount++;
				}
				count++;
			}
		}
		return invalidCount - 1;
	}

	// sum of Manhattan distances between tiles and goal
	public int manhattan() {
		int totalDistance = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (tiles[i][j] == 0)
					continue;
				totalDistance += Math.abs(i - getRow(tiles[i][j]));
				totalDistance += Math.abs(j - getCol(tiles[i][j]));
			}
		}
		return totalDistance;
	}
	
	

	// is this board the goal board?
	public boolean isGoal() {
		return this.hamming() == 0;
	}

	// does this board equal y?
	public boolean equals(Object y) {
		if (y == this)
			return true;
		if (y == null)
			return false;
		if (y.getClass() != this.getClass())
			return false;
		Board that = (Board) y;
		if (this.N != that.N)
			return false;
		for (int i = 0; i < this.N; i++) {
			for (int j = 0; j < this.N; j++) {
				if (this.tiles[i][j] != that.tiles[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	

	// all neighboring boards
	public Iterable<Board> neighbors() {
		Stack<Board> stack = new Stack<Board>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (tiles[i][j] == 0) {
					// for top is available
					if (i - 1 >= 0) {
						stack.push(createBoard(i, i - 1, j, j));
					}
					// for bottom is available
					if (i + 1 <= N - 1) {
						stack.push(createBoard(i, i + 1, j, j));
					}
					// for left is available
					if (j - 1 >= 0) {
						stack.push(createBoard(i, i, j, j - 1));
					}
					// for right is available
					if (j + 1 <= N - 1) {
						stack.push(createBoard(i, i, j, j + 1));
					}
					return stack;
				}
			}
		}
		return null;
	}

//	private int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + N;
//		result = prime * result + Arrays.deepHashCode(tiles);
//		return result;
//	}

//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Board other = (Board) obj;
//		if (N != other.N)
//			return false;
//		if (!Arrays.deepEquals(tiles, other.tiles))
//			return false;
//		return true;
//	}

	private Board createBoard(int blankRow, int moveBlankRow, int blankCol, int moveBlankCol) {
		Board nBoard = new Board(tiles);
		int b = tiles[moveBlankRow][moveBlankCol];
		nBoard.tiles[moveBlankRow][moveBlankCol] = 0;
		nBoard.tiles[blankRow][blankCol] = b;
		return nBoard;
	}

	// a board that is obtained by exchanging any pair of tiles
	public Board twin() {
		Board twinBoard = new Board(tiles);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if (tiles[i][j] == 0) {
					// for top is available
					if (i - 1 >= 0) {
						if(j + 1 <= N-1) {
							swap(twinBoard, i-1, j, i-1, j+1);
							return twinBoard;
						}else if(j - 2 >=0) {
							swap(twinBoard, i-1, j, i-1, j-2);
							return twinBoard;
						}else if(j-1 >=0) {
							swap(twinBoard, i-1, j, i-1, j-1);
							return twinBoard;
						}
					}
					// for bottom is available
					if (i + 1 <= N - 1) {
						if(j + 1 <= N-1) {
							swap(twinBoard, i+1, j, i+1, j+1);
							return twinBoard;
						}else if(j - 2 >=0) {
							swap(twinBoard, i+1, j, i+1, j-2);
							return twinBoard;
						}else if(j - 1 >=0) {
							swap(twinBoard, i+1, j, i+1, j-1);
							return twinBoard;
						}
					}
					// for left is available
					if (j - 1 >= 0) {
						if(i + 1 <= N-1) {
							swap(twinBoard, i, j-1, i+1, j-1);
							return twinBoard;
						}else if(i - 2 >=0) {
							swap(twinBoard, i, j-1, i-2, j-1);
							return twinBoard;
						}else if(i - 1 >=0) {
							swap(twinBoard, i, j-1, i-1, j-1);
							return twinBoard;
						}
					}
					// for right is available
					if (j + 1 <= N - 1) {
						if(i + 1 <= N-1) {
							swap(twinBoard, i, j+1, i+1, j+1);
							return twinBoard;
						}else if(i - 2 >=0) {
							swap(twinBoard, i, j+1, i-2, j+1);
							return twinBoard;
						}else if(i - 1>=0) {
							swap(twinBoard, i, j+1, i-1, j+1);
							return twinBoard;
						}	
					}
				}
			}
		}
		return twinBoard;
	}
	
	private void swap(Board board,int i,int j,int k ,int l) {
		int temp = board.tiles[i][j];
		board.tiles[i][j] = board.tiles[k][l];
		board.tiles[k][l] = temp;
	}

	private int getCol(int value) {
		return (value - 1) % N;
	}

	private int getRow(int value) {
		return (value - 1) / N;
	}

	/**
	 *
	 * void
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "/home/jawahar/dev/codes/algorithms/princenton-assigments/sample-puzzle.txt";
		In in = new In(filePath);
		int n = in.readInt();
		int[][] tiles = new int[n][n];
		int[][] newTiles = new int[n][n];
		// since System.Array.copy will not work for two dimensional array so adding
		// newTiles array values
		// in the same way we add one dim array.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int d = in.readInt();
				tiles[i][j] = d;
			}
		}
		Board board = new Board(tiles);
		newTiles = tiles.clone();
		Board otherBoard = new Board(newTiles);
		otherBoard.tiles[0][0] = 9;
		StdOut.println(board);
//		//StdOut.println(otherBoard);
//		StdOut.println("Hamming : " + board.hamming());
		StdOut.println("Manhattan : " + board.manhattan());
//		StdOut.println("Equals : " + board.equals(otherBoard));
		StdOut.println("Twin Board : " + board.twin());
//		for(Board b:board.neighbors()) {
//			System.out.println(b);
//			StdOut.println("Hamming : " + b.hamming());
//			StdOut.println("Manhattan : " + b.manhattan());
//		}

	}

}
