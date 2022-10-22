/******************************************************************************
 *  Compilation:  javac-algs4 PuzzleChecker.java
 *  Execution:    java-algs4 PuzzleChecker filename1.txt filename2.txt ...
 *  Dependencies: Board.java Solver.java
 *
 *  This program creates an initial board from each filename specified
 *  on the command line and finds the minimum number of moves to
 *  reach the goal state.
 *
 *  % java-algs4 PuzzleChecker puzzle*.txt
 *  puzzle00.txt: 0
 *  puzzle01.txt: 1
 *  puzzle02.txt: 2
 *  puzzle03.txt: 3
 *  puzzle04.txt: 4
 *  puzzle05.txt: 5
 *  puzzle06.txt: 6
 *  ...
 *  puzzle3x3-impossible: -1
 *  ...
 *  puzzle42.txt: 42
 *  puzzle43.txt: 43
 *  puzzle44.txt: 44
 *  puzzle45.txt: 45
 *
 ******************************************************************************/
package com.problems.algorithms.week4.priorityqueue.assignment;
import java.io.File;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class PuzzleChecker {

    public static void main(String[] args) {

    	File file = new File("/home/jawahar/dev/codes/algorithms/princenton-assigments/");
    	if(file.isDirectory()) {
    		int count  = 0;
    		for(File f: file.listFiles()) {
    			String filename = f.getAbsolutePath();
    			if(filename.contains(".txt")) {
    				if (filename.contains("unsolvable")) continue;
    				StdOut.println(filename);
    				count++;
    				In in = new In(filename);
    				int n = in.readInt();
    				int[][] tiles = new int[n][n];
    				for (int i = 0; i < n; i++) {
    					for (int j = 0; j < n; j++) {
    						tiles[i][j] = in.readInt();
    					}
    				}
    				
    				// solve the slider puzzle
    				Board initial = new Board(tiles);
    				Solver solver = new Solver(initial);
    				StdOut.println("board" + initial);
    				StdOut.println("Twin Board : " + initial.twin());
    				StdOut.println(filename + ": " + solver.moves());
    			}

    		}
    		System.out.println("Total count :" + count);
    	}

    }
}
