package com.problems.algorithms.week5.kdtrees.assignment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

/**
 * 
 */

/**
 * @author Thangaraj Jawahar
 *
 */
public class PointSET {

	private TreeSet<Point2D> root = new TreeSet<>();

	public PointSET() {

	}

	public boolean isEmpty() {
		return this.root.isEmpty();
	}

	public int size() {
		return this.root.size();
	}

	public void insert(Point2D p) {
		if(p == null)
		throw new IllegalArgumentException("argument can't be null");
		this.root.add(p);
	}

	public boolean contains(Point2D p) {
		if(p == null)
			throw new IllegalArgumentException("argument can't be null");
		return this.root.contains(p);
	}

	public void draw() {
		Iterator<Point2D> iterator = this.root.iterator();
		while (iterator.hasNext()) {
			Point2D point2d = iterator.next();
			point2d.draw();
		}
	}

	// all points that are inside the rectangle (or on the boundary)
	public Iterable<Point2D> range(RectHV rect) {
		if(rect == null)
			throw new IllegalArgumentException("argument can't be null");
		Set<Point2D> pInsideBox = new TreeSet<Point2D>();
		Point2D left = new Point2D(rect.xmin(), rect.ymin());
		Point2D right = new Point2D(rect.xmax(), rect.ymax());
		pInsideBox = this.root.subSet(left, true, right, true);
		Iterator<Point2D> pIterator = pInsideBox.iterator();
		List<Point2D> finalPoints = new ArrayList<Point2D>();
		while(pIterator.hasNext()) {
			Point2D point = pIterator.next();
			if(rect.distanceSquaredTo(point)==0.00) finalPoints.add(point);
		}
		return finalPoints;
	}

	// a nearest neighbor in the set to point p; null if the set is empty
	public Point2D nearest(Point2D p) {
		if(p == null)
			throw new IllegalArgumentException("argument can't be null");
		return nearest(root, p);
	}
	
	private Point2D nearest(TreeSet<Point2D> root,Point2D p) {
		Iterator<Point2D> iterator = this.root.iterator();
		Point2D nearest = iterator.next();
		while (iterator.hasNext()) {
			Point2D point2d = iterator.next();
			if(point2d.distanceSquaredTo(p) < nearest.distanceSquaredTo(p)) {
				nearest = point2d;
			}
		}
		return nearest;
	}

	public static void main(String[] args) {

	}

}
