package com.problems.datastructures.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/* After i have resolved the problem with normal hashmap
 * got in to the editorial section and comes to know needs to 
 * solve without hashmap so created twoarrays to hold count values*/
public class SparseArrays {

	private static final Scanner scanner = new Scanner(System.in);
	static String[] strings;
	static int size = 0;
	static int[] counts;

	public static void add(String s) {
		for (int i = 0; i < size; i++) {
			if (strings[i].equals(s)) {
				counts[i] += 1;
				return;
			}
		}
		strings[size] = s;
		counts[size++] = 1;
	}

	public static int askCount(String q) {
		for (int i = 0; i < size; i++) {
			if (strings[i].equals(q)) {
				return counts[i];
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int stringsCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
		strings = new String[stringsCount];
		counts = new int[stringsCount];
		for (int stringsItr = 0; stringsItr < stringsCount; stringsItr++) {
			String stringsItem = scanner.nextLine();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
			add(stringsItem);
		}

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		for (int qItr = 0; qItr < q; qItr++) {
			String queryString = scanner.nextLine();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

			int res = askCount(queryString);
			bufferedWriter.write(String.valueOf(res));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
