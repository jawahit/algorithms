package com.problems.algorithms.week3.sorting.assignment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */

/**
 * @author Thangaraj Jawahar
 *
 */
public class BruteCollinearPoints {

	private LineSegment[] lineSegments = null;
	private List<LineSegment> lineSegmentsList = null;

	public BruteCollinearPoints(final Point[] points) {
		if (points == null) {
			throw new java.lang.IllegalArgumentException("points shouldn't be null");
		}
		lineSegmentsList = new ArrayList<>();
		Arrays.sort(points);
		Point src = null;
		for (int p = 0; p <= (points.length - 1); p++) {
			if (points[p] == null) {
				throw new java.lang.IllegalArgumentException("points shouldn't be null");
			}
			if (src != null && points[p].compareTo(src) == 0) {
				throw new java.lang.IllegalArgumentException("duplicate is not allowed");
			}
			src = points[p];
			for (int q = p + 1; q <= (points.length - 1); q++) {
				double s1 = src.slopeTo(points[q]);
				for (int r = q + 1; r <= (points.length - 1); r++) {
					double s2 = src.slopeTo(points[r]);
					if (s1 == s2) {
						for (int s = r + 1; s <= (points.length - 1); s++) {
							double s3 = src.slopeTo(points[s]);
							if (s2 == s3 && src.compareTo(points[s])!=0) {						
								this.lineSegmentsList.add(new LineSegment(src, points[s]));
							}
						}
					}
				}
			}
		}
		copy();
	}

	private void copy() {
		this.lineSegments = new LineSegment[this.lineSegmentsList.size()];
		for (int i = 0; i < this.lineSegmentsList.size(); i++) {
			lineSegments[i] = this.lineSegmentsList.get(i);
		}
	}

	public int numberOfSegments() {
		return this.lineSegments.length;
	}

	public LineSegment[] segments() {
		return lineSegments;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
