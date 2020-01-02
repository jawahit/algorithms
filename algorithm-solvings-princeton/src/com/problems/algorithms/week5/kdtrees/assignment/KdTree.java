import java.util.Iterator;

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

	public KdTree() {

	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return size;
	}

	public void insert(Point2D point) {
		this.root = insert(this.root, point, true, new Point2D(0.00, 1.00));
	}

	public boolean contains(Point2D point) {
		return contains(this.root, point, true);
	}

	public void draw() {
		StdDraw.enableDoubleBuffering();
		draw(this.root,0.0,1.0);
	}
	public Iterable<Point2D> range(RectHV rect) {
		return null;
		
	}
	private void draw(Node x,double xx, double yy) {		
		if(x != null) {
			x.point.draw();
			//StdDraw.clear();
			if(x.isVertical()) {
				StdDraw.setPenColor(StdDraw.RED);
				StdDraw.setPenRadius(0.01);
				StdDraw.line(x.getRectHV().xmin(), x.getRectHV().ymin(), x.getRectHV().xmax(), x.rectHV.ymax());				
			}else {
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.setPenRadius(0.01);
				StdDraw.line(x.getRectHV().xmin(), x.getRectHV().ymin(), x.getRectHV().xmax(), x.rectHV.ymax());
			}
		}else return;
		draw(x.left,x.point.x(),x.point.y());
		draw(x.right,x.point.x(),x.point.y());
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

	private Node insert(Node x, Point2D point, boolean vertical,Point2D parentPoint) {
		if (x == null) {
			x = new Node(point, vertical);
			if(vertical)
				x.setRectHV(new RectHV(point.x(), parentPoint.x(), point.x(), parentPoint.y()));
			else
				x.setRectHV(new RectHV(point.x() < parentPoint.x() ? 0.00 : parentPoint.x(), point.y(), parentPoint.x(), point.y()));	
			size++;
			return x;
		}
		if (vertical) {
			if (point.x() < x.point.x()) {
				x.left = insert(x.left, point, false, x.point);
			} else {
				x.right = insert(x.right, point, false, x.point);
			}
		} else {
			if (point.y() < x.point.y()) {
				x.left = insert(x.left, point, true, x.point);
			} else {
				x.right = insert(x.right, point, true, x.point);
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
