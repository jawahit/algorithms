/**
 * 
 */
package com.problems.algorithms.week5.kdtrees.assignment;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

/**
 * @author Thangaraj Jawahar
 *
 * Dec 28, 2019
 * 
 *
 */
public class NearestNeighborVisualizer {
	
	public static void main(String[] args) {

        // initialize the two data structures with point from file
		String filename = "/home/jawahar/dev/codes/algorithms/algorithm-solvings-princeton/resources/week5/sample-input.txt";
        In in = new In(filename);
        PointSET brute = new PointSET();
       KdTree kdtree = new KdTree();
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            kdtree.insert(p);
            brute.insert(p);
        }

        // process nearest neighbor queries
        StdDraw.enableDoubleBuffering();
        while (true) {

            // the location (x, y) of the mouse
            double x = StdDraw.mouseX();
            double y = StdDraw.mouseY();
            Point2D query = new Point2D(x, y);

            // draw all of the points
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setPenRadius(0.01);
            brute.draw();

            // draw in red the nearest neighbor (using brute-force algorithm)
            StdDraw.setPenRadius(0.03);
            StdDraw.setPenColor(StdDraw.RED);
            Point2D nearestBrute = brute.nearest(query);
            if(nearestBrute != null)nearestBrute.draw();
            StdDraw.setPenRadius(0.02);

            // draw in blue the nearest neighbor (using kd-tree algorithm)
           StdDraw.setPenColor(StdDraw.BLUE);
           Point2D nearestKd = kdtree.nearest(query);
           if(nearestKd != null)nearestKd.draw();
            StdDraw.show();
            StdDraw.pause(40);
        }
    }

}
