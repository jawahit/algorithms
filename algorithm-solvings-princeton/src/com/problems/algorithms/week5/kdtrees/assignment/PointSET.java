/**
 * 
 */
package com.problems.algorithms.week5.kdtrees.assignment;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

/**
 * @author Thangaraj Jawahar
 *
 *         Dec 28, 2019
 * 
 *
 */
public class PointSET {

	private TreeSet<Point2D> root = new TreeSet<Point2D>();

	public PointSET() {

	}

	public boolean isEmpty() {
		return this.root.isEmpty();
	}

	public int size() {
		return this.root.size();
	}

	public void insert(Point2D p) {
		if (p == null)
			throw new IllegalArgumentException("parameter can't be null");
		this.root.add(p);
	}

	public boolean contains(Point2D p) {
		if (p == null)
			throw new IllegalArgumentException("parameter can't be null");
		return this.root.contains(p);
	}

	public void draw() {
		Iterator<Point2D> iterator = this.root.iterator();
		while (iterator.hasNext()) {
			iterator.next().draw();
		}
	}

	// all points that are inside the rectangle (or on the boundary)
	public Iterable<Point2D> range(RectHV rect) {
		if (rect == null)
			throw new IllegalArgumentException("parameter can't be null");
		Point2D left = new Point2D(rect.xmin(), rect.ymin());
		Point2D right = new Point2D(rect.xmax(), rect.ymax());
		Set<Point2D> rangeSet = this.root.subSet(left, true, right, true);
		Iterator<Point2D> iterator = rangeSet.iterator();
		Set<Point2D> pInsideBox = new HashSet<Point2D>();
		while (iterator.hasNext()) {
			Point2D point = iterator.next();
			if (rect.distanceSquaredTo(point) == 0)
				pInsideBox.add(point);
		}
		return pInsideBox;
	}

	// a nearest neighbor in the set to point p; null if the set is empty
	public Point2D nearest(Point2D p) {
		if (p == null)
			throw new IllegalArgumentException("parameter can't be null");
		Point2D floor = this.root.floor(p);
		Point2D ceiling = this.root.ceiling(p);
		if(floor!=null && floor.x()<ceiling.x()) {
			return floor;
		}
		return ceiling;
	}

	public static void main(String[] args) {
	}

}
