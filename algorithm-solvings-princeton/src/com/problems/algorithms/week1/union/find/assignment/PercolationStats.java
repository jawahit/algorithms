package com.problems.algorithms.week1.union.find.assignment;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * The {@code PercolationStats} class produces the statistical report for
 * {@code Percolation} which provides Mean, Standard Deviation
 * 
 * @author Thangaraj Jawahar
 * Feb 11, 2019
 *
 */
public class PercolationStats {

	private int[] openSitesValuesList;
	private final static double ONE_POINT_NINETY_SIX = 1.96;
	private final int trials;
	private final int squaredOfN;
	private final double meanValue;
	private final double stddevValue;
	private final double secondPartValue;

	/**
	 * 
	 * @param n
	 * @param trials
	 */
	public PercolationStats(int n, int trials) {
		validate(n);
		validate(trials);
		this.trials = trials;
		this.squaredOfN = n * n;
		openSitesValuesList = new int[trials];
		int endRange = n + 1;
		for (int i = 0; i < trials; i++) {
			Percolation p = new Percolation(n);
			while (!p.percolates()) {
				p.open(StdRandom.uniform(1, endRange), StdRandom.uniform(1, endRange));
			}
			openSitesValuesList[i] = p.numberOfOpenSites();
		}
		this.meanValue = StdStats.mean(openSitesValuesList) / squaredOfN;
		this.stddevValue = StdStats.stddev(openSitesValuesList) / squaredOfN;
		this.secondPartValue = secondPartCalculation();
	}

	/**
	 * validate the size is greater than zero if it's not throw error
	 * 
	 * @param n
	 */
	private void validate(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("value should be greater than zero but it's" + n);
		}
	}

	/**
	 * this method outputs the mean value of numberOfOpensites of all trials
	 * 
	 * @return estimate of the percolation threshold
	 */
	public double mean() {
		return this.meanValue;
	}

	/**
	 * this method outputs the standard deviation value of numberOfOpensites of all trials
	 * 
	 * @return  standard deviation of the estimation of the percolation threshold
	 */
	public double stddev() {
		return this.stddevValue;
	}

	/**
	 * low endpoint of 95% confidence interval
	 * 
	 * @return
	 */
	public double confidenceLo() {

		return this.meanValue - this.secondPartValue;
	}

	/**
	 * High endpoint of 95% confidence interval
	 * 
	 * @return
	 */
	public double confidenceHi() {
		return this.meanValue + this.secondPartValue;

	}

	/**
	 * @return
	 */
	private double secondPartCalculation() {
		return ((ONE_POINT_NINETY_SIX * stddev()) / Math.sqrt(this.trials));
	}

	public static void main(String[] args) {
		int n = StdIn.readInt();
		int t = StdIn.readInt();
		PercolationStats stats = new PercolationStats(n, t);
		StdOut.println("mean\t\t\t = " + stats.mean());
		StdOut.println("stddev\t\t\t = " + stats.stddev());
		StdOut.println("95% confidence interval  = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
	}

}
