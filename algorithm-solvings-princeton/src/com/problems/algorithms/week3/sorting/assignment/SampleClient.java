package com.problems.algorithms.week3.sorting.assignment;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 
 */

/**
 * @author Thangaraj Jawahar
 *
 */
public class SampleClient {
	// read the n points from a file
	public static void main(String[] args) {
		In in = new In("C:\\Users\\thangj3\\Desktop\\pers\\Alg1\\collinear\\rs1423.txt");
		int n = in.readInt();
		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
			int x = in.readInt();
			int y = in.readInt();
			points[i] = new Point(x, y);
		}

		// draw the points
		StdDraw.enableDoubleBuffering();
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);
		for (Point p : points) {
			p.draw();
		}
		StdDraw.show();

		// print and draw the line segments
		
		Stopwatch sw = new Stopwatch();
		BruteCollinearPoints collinear = new BruteCollinearPoints(points);
		System.out.println(sw.elapsedTime());
		for (LineSegment segment : collinear.segments()) {

				StdOut.println(segment);
				segment.draw();				
		}
		StdDraw.show();
	}
}
