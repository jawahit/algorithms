/**
 * 
 */
package com.problems.algorithms.week2.sorting;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.problems.algorithms.week3.mergesort.MergeSort;
import com.problems.algorithms.week3.sorting.assignment.LineSegment;
import com.problems.algorithms.week3.sorting.assignment.Point;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

/**
 * @author Thangaraj Jawahar
 *
 */
public class ConvexHull {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		In in = new In("C:\\Users\\thangj3\\Desktop\\pers\\Alg1\\collinear\\convexhull.txt");
		int n = in.readInt();
		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
			int x = in.readInt();
			int y = in.readInt();
			points[i] = new Point(x, y);
		}

		// draw the points
		StdDraw.enableDoubleBuffering();
		StdDraw.setXscale(0, 36000);
		StdDraw.setYscale(0, 36000);
		StdDraw.setPenRadius(.010);
		for (Point p : points) {
			p.draw();
		}
		StdDraw.show();
		drawConvexHullPoints(points);
	}

	public static void drawConvexHullPoints(Point[] points) {
		MergeSort.sort(points, null);
		print(points);
		System.out.println("Identify fencing points---->");
		MergeSort.sort(points, points[0].slopeOrder());
		print(points);
		Stack<Point> pointStack = new Stack<>();
		pointStack.push(points[0]);
		pointStack.push(points[1]);
		for (int i = 2; i < points.length; i++) {
			Point midPoint = pointStack.pop();
//			while (pointStack.size() >= 1 && !points[i].isCCW(midPoint, pointStack.peek())) {
//				midPoint = pointStack.pop();
//			}
			while (pointStack.size() >= 1 && Point.isCCW(pointStack.peek(), midPoint, points[i]) <= 0) {
				midPoint = pointStack.pop();
			}
			pointStack.push(midPoint);
			pointStack.push(points[i]);
		}
		Point lastPoint = pointStack.pop();
		Point originPoint = points[0];
		List<LineSegment> lineSegments = new ArrayList<>();
		lineSegments.add(new LineSegment(originPoint, lastPoint));
		Point nextPoint = null;
		while (!pointStack.isEmpty()) {
			nextPoint = pointStack.pop();
			lineSegments.add(new LineSegment(nextPoint, lastPoint));
			lastPoint = nextPoint;
		}
		//lineSegments.add(new LineSegment(originPoint, lastPoint));
		System.out.println("drawing line with fencing points ----->");
		StdDraw.setPenRadius(.004);
		StdDraw.setPenColor(Color.magenta);
		for (LineSegment ls : lineSegments) {
			ls.draw();
		}
		StdDraw.show();
	}

	private static void print(Point[] points) {
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i]);
		}
	}

}
