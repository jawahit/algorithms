/**
 * 
 */
package com.problems.algorithms.week6.hashtable;

import java.util.Iterator;

import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;

/**
 * @author Thangaraj Jawahar
 *
 *         Nov 18, 2019
 * 
 *
 */
public class Concordance {

	/**
	 *
	 * void
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] words = StdIn.readLine().split("\\s+");
		ST<String, SET<Integer>> st = new ST<String, SET<Integer>>();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (!st.contains(word))
				st.put(word, new SET<Integer>());
			SET<Integer> pagedIndexes = st.get(word);
			pagedIndexes.add(i);
		}

		while (!StdIn.isEmpty()) {
			String query = StdIn.readString();
			SET<Integer> pages = st.get(query);
			Iterator<Integer> it = pages.iterator();
			while (it.hasNext()) {
				Integer i = it.next();
				int lesser = (i - 4) < 0 ? 0 : i - 4;
				if (lesser >= 0) {
					while (lesser != i) {
						System.out.print(words[lesser++] + " ");
					}
				}
				int greater = (i + 4) > words.length ? words.length : i + 4;
				if (greater >= 0 && greater <= words.length) {
					while (greater != i) {
						System.out.print(words[i++] + " ");
					}
				}
			}
		}

	}

}
