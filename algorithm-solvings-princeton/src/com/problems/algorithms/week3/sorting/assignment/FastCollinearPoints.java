package com.problems.algorithms.week3.sorting.assignment;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 
 */

/**
 * @author Thangaraj Jawahar
 *
 */
public class FastCollinearPoints {

	private LineSegment[] lineSegments = null;
	private List<LineSegment> lineSegmentsList = null;

	public FastCollinearPoints(final Point[] points) {
		if (points == null) {
			throw new java.lang.IllegalArgumentException("points shouldn't be null");
		}
		lineSegmentsList = new ArrayList<>();
		Point[] aux = new Point[points.length];
		copyArray(points, aux, 0, points.length - 1);
		sort(points, null);
		Point src = null;
		for (int i = 0; i <= (points.length - 1); i++) {
			if (src != null && points[i].compareTo(src) == 0) {
				throw new java.lang.IllegalArgumentException("duplicate is not allowed");
			}
			src = points[i];
			sort(aux, src.slopeOrder());
			int srcI = 1;
			while (srcI <= (aux.length - 1)) {
				Point yMax = src;
				Point yLow = src;
				double slope = src.slopeTo(aux[srcI]);
				int count = 0;
				while (srcI <= (aux.length - 1) && slope == src.slopeTo(aux[srcI])) {
					if (yMax.compareTo(aux[srcI]) < 1) {
						yMax = aux[srcI];
					}
					if (yLow.compareTo(aux[srcI]) == 1) {
						yLow = aux[srcI];
					}
					count++;
					srcI++;
				}
				if (count >= 3 && src.compareTo(yLow) == 0 && yLow.compareTo(yMax) != 0) {
					this.lineSegmentsList.add(new LineSegment(yLow, yMax));
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

	private void sort(Point[] c, Comparator<Point> comp) {
		Point[] dest = new Point[c.length];
		copyArray(c, dest, 0, c.length - 1);
		if (comp == null) {
			divideAndConquer(dest, c, 0, c.length - 1);
		} else {
			divideAndConquerWithComparator(dest, c, 0, c.length - 1, comp);
		}
	}

	private void divideAndConquerWithComparator(Point[] src, Point[] dest, int start, int end, Comparator<Point> comp) {
		if (start == end) {
			return;
		}
		int mid = (start + end) >>> 1;
		// mind twisting part :) thanks to Robert Sedgewick for saving array copy time
		divideAndConquerWithComparator(dest, src, start, mid, comp);
		divideAndConquerWithComparator(dest, src, mid + 1, end, comp);
		merge(src, dest, start, mid + 1, end, comp);
	}

	private void merge(Point[] src, Point[] dest, int start, int mid, int end, Comparator<Point> comp) {
		for (int startPoint = start, midPoint = mid, destIndex = startPoint; destIndex <= end; destIndex++) {
			if (startPoint >= mid || (midPoint <= end && comp.compare(src[startPoint], (src[midPoint])) > 0)) {
				dest[destIndex] = src[midPoint++];
			} else {
				dest[destIndex] = src[startPoint++];
			}
		}
	}

	private void divideAndConquer(Point[] src, Point[] dest, int start, int end) {
		if (start == end) {
			return;
		}
		int mid = (start + end) >>> 1;
		// mind twisting part :) thanks to Robert Sedgewick for saving array copy time
		divideAndConquer(dest, src, start, mid);
		divideAndConquer(dest, src, mid + 1, end);
		merge(src, dest, start, mid + 1, end);
	}

	private void merge(Point[] src, Point[] dest, int start, int mid, int end) {
		for (int startPoint = start, midPoint = mid, destIndex = startPoint; destIndex <= end; destIndex++) {
			if (startPoint >= mid || (midPoint <= end && (src[startPoint]).compareTo(src[midPoint]) > 0)) {
				dest[destIndex] = src[midPoint++];
			} else {
				dest[destIndex] = src[startPoint++];
			}
		}
	}

	private void copyArray(Point[] src, Point[] dest, int start, int end) {
		for (int i = start; i <= end; i++) {
			if (src[i] == null) {
				throw new java.lang.IllegalArgumentException("points shouldn't be null");
			}
			dest[i] = src[i];
		}
	}

}
