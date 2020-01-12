import java.awt.Font;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

/**
 * 
 */

/**
 * @author Thangaraj Jawahar
 *
 */
public class KdTree {

	private Node root = null;
	private int size = 0;
	private static DecimalFormat df = new DecimalFormat("0.00");

	public KdTree() {

	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return size;
	}

	public void insert(Point2D point) {
		this.root = insert(this.root, point, true, 0.00, 1.00);
	}

	public boolean contains(Point2D point) {
		return contains(this.root, point, true);
	}

	public void draw() {
		StdDraw.enableDoubleBuffering();
		draw(this.root);
	}

	public Iterable<Point2D> range(RectHV rect) {
		Set<Point2D> points = new HashSet<>();
		if (rect.xmin() != 0.00 && rect.xmax() != 0.00) {
			if (rect.xmin() < this.root.point.x() && rect.xmax() <= this.root.point.x()) {
				if (rect.distanceSquaredTo(this.root.point) == 0.00)
					points.add(this.root.point);
				range(this.root.left, rect, points);
			} else if (rect.xmin() >= this.root.point.x()) {
				if (rect.distanceSquaredTo(this.root.point) == 0.00)
					points.add(this.root.point);
				range(this.root.right, rect, points);
			} else {
				range(this.root, rect, points);
			}
		}
		return points;
	}

	private void range(Node x, RectHV rect, Set<Point2D> points) {
		if (x == null)
			return;
		if (rect.intersects(x.rectHV)) {
			if (rect.distanceSquaredTo(x.point) == 0.00)
				points.add(x.point);
		}
		range(x.left, rect, points);
		range(x.right, rect, points);
	}

	public Point2D nearest(Point2D queryP) {
		if (queryP == null)
			throw new IllegalArgumentException("argument can't be null");
		if (queryP.x() != 0.00 && queryP.y() != 0.00) {
			return nearest(this.root, queryP, this.root.point);
		}
		return null;
	}

	private Point2D nearest(Node x, Point2D queryP, Point2D nearest) {
		if (x == null)
			return null;
		if (nearest != null && x.rectHV.distanceSquaredTo(queryP) < queryP.distanceSquaredTo(nearest)) {
			if (x.point.distanceSquaredTo(queryP) < queryP.distanceSquaredTo(nearest)) {
				nearest = x.point;
				return nearest;
			}
		}
		nearest = nearest(x.left, queryP, nearest);
		nearest = nearest(x.right, queryP, nearest);
		return nearest;
	}

	private void draw(Node x) {
		if (x != null) {
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.setPenRadius(0.01);
			x.point.draw();
//			StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 12));
//			StdDraw.textRight(x.point.x(), x.point.y(),
//					"(" + df.format(x.point.x()) + "," + df.format(x.point.y()) + ")");
			// StdDraw.clear();
			if (x.isVertical()) {
				StdDraw.setPenColor(StdDraw.RED);
				StdDraw.setPenRadius(0.001);
				StdDraw.line(x.getRectHV().xmin(), x.getRectHV().ymin(), x.getRectHV().xmax(), x.rectHV.ymax());
//				StdDraw.text(x.getRectHV().xmin(), x.getRectHV().ymin(),
//						"(" + df.format(x.getRectHV().xmin()) + "," + df.format(x.getRectHV().ymin()) + ")", 90);
//				StdDraw.text(x.getRectHV().xmax(), x.getRectHV().ymax(),
//						"(" + df.format(x.getRectHV().xmax()) + "," + df.format(x.getRectHV().ymax()) + ")", 90);
			} else {
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.setPenRadius(0.001);
				StdDraw.line(x.getRectHV().xmin(), x.getRectHV().ymin(), x.getRectHV().xmax(), x.rectHV.ymax());
//				StdDraw.text(x.getRectHV().xmin(), x.getRectHV().ymin(),
//						"(" + df.format(x.getRectHV().xmin()) + "," + df.format(x.getRectHV().ymin()) + ")", 90);
//				StdDraw.text(x.getRectHV().xmax(), x.getRectHV().ymax(),
//						"(" + df.format(x.getRectHV().xmax()) + "," + df.format(x.getRectHV().ymax()) + ")", 90);
			}
		} else
			return;
		draw(x.left);
		draw(x.right);
	}

	private boolean contains(Node x, Point2D point, boolean vertical) {
		if (x == null)
			return false;
		if (x.point == point)
			return true;
		if (vertical) {
			if (point.x() < x.point.x()) {
				contains(x.left, point, false);
			} else {
				contains(x.right, point, false);
			}
		} else {
			if (point.y() < x.point.y()) {
				contains(x.left, point, true);
			} else {
				contains(x.right, point, true);
			}
		}
		return false;
	}

	private Node insert(Node x, Point2D point, boolean vertical, double min, double max) {
		if (x == null) {
			x = new Node(point, vertical);
			if (vertical)
				x.setRectHV(new RectHV(point.x(), min, point.x(), max));
			else
				x.setRectHV(new RectHV(min, point.y(), max, point.y()));
			size++;
			return x;
		}
		if (vertical) {
			if (point.x() < x.point.x()) {
				x.left = insert(x.left, point, false, 0.0, x.point.x());
			} else {
				x.right = insert(x.right, point, false, x.point.x(), 1.0);
			}
		} else {
			if (point.y() < x.point.y()) {
				x.left = insert(x.left, point, true, 0.0, x.point.y());
			} else {
				x.right = insert(x.right, point, true, x.point.y(), 1.0);
			}
		}
		return x;
	}

	class Node {
		Node left;
		Node right;
		Point2D point;
		boolean vertical;
		RectHV rectHV;

		public Node(Point2D point, boolean vertical) {
			this.point = point;
			this.vertical = vertical;
		}

		/**
		 * @return the left
		 */
		public Node getLeft() {
			return left;
		}

		/**
		 * @param left the left to set
		 */
		public void setLeft(Node left) {
			this.left = left;
		}

		/**
		 * @return the right
		 */
		public Node getRight() {
			return right;
		}

		/**
		 * @param right the right to set
		 */
		public void setRight(Node right) {
			this.right = right;
		}

		/**
		 * @return the point
		 */
		public Point2D getPoint() {
			return point;
		}

		/**
		 * @param point the point to set
		 */
		public void setPoint(Point2D point) {
			this.point = point;
		}

		/**
		 * @return the vertical
		 */
		public boolean isVertical() {
			return vertical;
		}

		/**
		 * @param vertical the vertical to set
		 */
		public void setVertical(boolean vertical) {
			this.vertical = vertical;
		}

		/**
		 * @return the rectHV
		 */
		public RectHV getRectHV() {
			return rectHV;
		}

		/**
		 * @param rectHV the rectHV to set
		 */
		public void setRectHV(RectHV rectHV) {
			this.rectHV = rectHV;
		}

	}

}
