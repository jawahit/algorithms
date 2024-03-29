/**
 * 
 */
package com.problems.algorithms.week5.kdtrees.assignment;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

/**
 * @author Thangaraj Jawahar
 *
 * Dec 28, 2019
 * 
 *
 */
public class RangeSearchVisualizer {
	
	 public static void main(String[] args) {

	        // initialize the data structures from file
	        String filename = "/home/jawahar/dev/codes/algorithms/algorithm-solvings-princeton/resources/week5/input100K.txt";
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
	        System.out.println(kdtree.contains(new Point2D(0.875, 0.5625)));

	        double x0 = 0.0, y0 = 0.0;      // initial endpoint of rectangle
	        double x1 = 0.0, y1 = 0.0;      // current location of mouse
	        boolean isDragging = false;     // is the user dragging a rectangle

	        // draw the points
	        StdDraw.clear();
	        StdDraw.setPenColor(StdDraw.BLACK);
	        StdDraw.setPenRadius(0.01);
	        brute.draw();
	        StdDraw.show();

	        // process range search queries
	        StdDraw.enableDoubleBuffering();
	        while (true) {

	            // user starts to drag a rectangle
	            if (StdDraw.isMousePressed() && !isDragging) {
	                x0 = x1 = StdDraw.mouseX();
	                y0 = y1 = StdDraw.mouseY();
	                isDragging = true;
	            }

	            // user is dragging a rectangle
	            else if (StdDraw.isMousePressed() && isDragging) {
	                x1 = StdDraw.mouseX();
	                y1 = StdDraw.mouseY();
	            }

	            // user stops dragging rectangle
	            else if (!StdDraw.isMousePressed() && isDragging) {
	                isDragging = false;
	            }

	            // draw the points
	            StdDraw.clear();
	            StdDraw.setPenColor(StdDraw.BLACK);
	            StdDraw.setPenRadius(0.01);
	            brute.draw();

	            // draw the rectangle
	            RectHV rect = new RectHV(Math.min(x0, x1), Math.min(y0, y1),
	                                     Math.max(x0, x1), Math.max(y0, y1));
	            StdDraw.setPenColor(StdDraw.BLACK);
	            StdDraw.setPenRadius();
	            rect.draw();

	            // draw the range search results for brute-force data structure in red
	            StdDraw.setPenRadius(0.03);
	            StdDraw.setPenColor(StdDraw.RED);
	            for (Point2D p : brute.range(rect))
	                p.draw();

	            // draw the range search results for kd-tree in blue
	            StdDraw.setPenRadius(0.02);
	            StdDraw.setPenColor(StdDraw.BLUE);
	            for (Point2D p : kdtree.range(rect))
	                p.draw();

	            StdDraw.show();
	            StdDraw.pause(20);
	            
	           
	        }
	    }

}
