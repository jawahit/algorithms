package com.problems.algorithms.week1.union.find.assignment;

 

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.Font;

public class PercolationVisualizer {

    // delay in miliseconds (controls animation speed)
    private static final int DELAY = 10;

    // draw n-by-n percolation system
    public static void draw(Percolation perc, int n) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setXscale(-0.05 * n, 1.05 * n);
        StdDraw.setYscale(-0.05 * n, 1.05 * n);   // leave a border to write text
        StdDraw.filledSquare(n / 2.0, n / 2.0, n / 2.0);

        // draw n-by-n grid
        int opened = 0;
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                if (perc.isFull(row, col)) {
                    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                    opened++;
                }
                else if (perc.isOpen(row, col)) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    opened++;
                }
                else
                    StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledSquare(col - 0.5, n - row + 0.5, 0.45);
            }
        }

        // write status text
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 12));
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(0.25 * n, -0.025 * n, opened + " open sites");
        if (perc.percolates()) StdDraw.text(0.75 * n, -0.025 * n, "percolates");
        else StdDraw.text(0.75 * n, -0.025 * n, "does not percolate");

    }

    public static void main(String[] args) {
        In in = new In("/home/jawahar/dev/codes/algorithms/princenton-assigments/percolation/wayne98.txt");      // input file
        int n = in.readInt();         // n-by-n percolation system

        // turn on animation mode
        StdDraw.enableDoubleBuffering();

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(n);
        draw(perc, n);
        StdDraw.show();
        StdDraw.pause(DELAY);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
            draw(perc, n);
            StdDraw.show();
            StdDraw.pause(DELAY);
        }
    }
}

