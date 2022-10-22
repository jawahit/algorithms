/**
 * 
 */
package com.problems.algorithms.week4.priorityqueue.assignment;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * week4 assignment 8Puzzle
 * @author Thangaraj Jawahar
 * 
 *         Aug 3, 2019
 * 
 *
 */
public class Solver {

	private MinPQ<Node> pq;
	private Board initialBoard;
	private Stack<Board> solutionBoard;

	/*implementing A* Search algorithm*/
	public Solver(Board initial) {
		if (initial == null) {
			throw new java.lang.IllegalArgumentException("board can't be null");
		}
		this.initialBoard = initial;
		solutionBoard = new Stack<Board>();
		pq = new MinPQ<Node>();
		pq.insert(createNode(initial, 0, initialBoard.manhattan(), null));
		while (!pq.isEmpty()) {
			Node minNode = pq.delMin();
			if (minNode.getManhattan() == 0) {
				Node node = minNode;
				while (node != null) {
					solutionBoard.push(node.getBoard());
					node = node.getPrevious();
				}
				break;
			}
			for (Board board : minNode.getBoard().neighbors()) {
				if (minNode.getPrevious() != null && board.equals(minNode.getPrevious().getBoard()))
					continue;
				pq.insert(createNode(board, minNode.getMoves() + 1, board.manhattan(), minNode));
			}
		}

	}

	private Node createNode(Board board, int move, int manhattan, Node previous) {
		Node node = new Node();
		node.setBoard(board);
		node.setMoves(move);
		node.setManhattan(manhattan);
		node.setPriority(move + manhattan);
		node.setPrevious(previous);
		return node;
	}

	// is the initial board solvable? (see below)
	public boolean isSolvable() {
		return moves() != -1;
	}

	// min number of moves to solve initial board
	public int moves() {
		return solutionBoard.size() - 1;
	}

	// sequence of boards in a shortest solution
	public Iterable<Board> solution() {
		return solutionBoard;
	}

	private class Node implements Comparable<Node> {
		private Board board;
		private int moves;
		private int priority;
		private Node previous;
		private int manhattan;

		public Board getBoard() {
			return board;
		}

		public void setBoard(Board board) {
			this.board = board;
		}

		public int getMoves() {
			return moves;
		}

		public void setMoves(int moves) {
			this.moves = moves;
		}

		public Node getPrevious() {
			return previous;
		}

		public void setPrevious(Node previous) {
			this.previous = previous;
		}

		public int getPriority() {
			return priority;
		}

		public void setPriority(int priority) {
			this.priority = priority;
		}
		
		public int getManhattan() {
			return manhattan;
		}

		public void setManhattan(int manhattan) {
			this.manhattan = manhattan;
		}

		@Override
		public int compareTo(Node o) {
			if (this.priority < o.priority)
				return -1;
			else if (this.priority > o.priority)
				return 1;
			return 0;
		}

	}

	/**
	 *
	 * void
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// In in = new In(args[0]);
//		String filePath =
//		 "/home/jawahar/dev/codes/algorithms/princenton-assigments/sample-puzzle.txt";
		String filePath = "/home/jawahar/dev/codes/algorithms/princenton-assigments/puzzle14.txt";
		In in = new In(filePath);
		int n = in.readInt();
		int[][] tiles = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				tiles[i][j] = in.readInt();
		Solver solver = new Solver(new Board(tiles));
		if (!solver.isSolvable()) {
			StdOut.println("No Solutions possible");
		} else {
			StdOut.println("Minimum number of moves = " + solver.moves());
			int count = 0;
			for (Board board : solver.solution()) {
				StdOut.println("Count : " + count++);
				StdOut.println("manhattan : " + board.manhattan());
				System.out.println(board);
			}
		}

	}

}
