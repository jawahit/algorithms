/**
 * 
 */
package com.problems.algorithms.week5.kdtrees.assignment;

import java.util.Arrays;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Thangaraj Jawahar
 *
 * Dec 24, 2019
 * 
 *
 */
public class Test {

	/**
	 *
	 *void
	 * @param args
	 */
	public static void main(String[] args) {
		RectHV hv = new RectHV(2, 2, 4, 4);
		hv.draw();
        //drawPoint2D("50", "50", "5");

	}
	
	public static void drawPoint2D(String x1, String y1, String m) {
		int x0 = Integer.parseInt(x1);
        int y0 = Integer.parseInt(y1);
        int n = Integer.parseInt(m);

        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        StdDraw.setPenRadius(0.005);
        StdDraw.enableDoubleBuffering();

        Point2D[] points = new Point2D[n];
        for (int i = 0; i < n; i++) {
            int x = StdRandom.uniform(100);
            int y = StdRandom.uniform(100);
            points[i] = new Point2D(x, y);
            points[i].draw();
        }

        // draw p = (x0, x1) in red
        Point2D p = new Point2D(x0, y0);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.02);
        p.draw();


        // draw line segments from p to each point, one at a time, in polar order
        StdDraw.setPenRadius();
        StdDraw.setPenColor(StdDraw.BLUE);
        Arrays.sort(points, p.polarOrder());
        for (int i = 0; i < n; i++) {
            p.drawTo(points[i]);
            StdDraw.show();
            StdDraw.pause(100);
        }
    }


}
