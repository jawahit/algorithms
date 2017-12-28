package com.problems.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/* DONE 
 * Please refer https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
 * 
 *  Problem Statement :
 *  
 *  Sherlock considers a string, , to be valid if either of the following conditions are satisfied:

		All characters in  have the same exact frequency (i.e., occur the same number of times). For example,  is valid, but  is not valid.
		Deleting exactly  character from  will result in all its characters having the same frequency. For example,  and  are valid because all their letters will have the same frequency if we remove  occurrence of c, but  is not valid because we'd need to remove  characters.
		Given , can you determine if it's valid or not? If it's valid, print YES on a new line; otherwise, print NO instead.
 * 
 * Sample Input :
 *   
 *   aabbcd
 *   
 * Sample Output :
 * 
 *    NO
 *    
 * Explanation :

  We would need to remove two characters from s="aabbcd"  
  to make it valid, because a and b both have a frequency of 2 and c and d both have a frequency of 1.
  This means  is invalid because we'd need to remove more than 1 character
   to make all its letters have the same frequency, so we print NO as our answer.
 * 
 * 
 * 
 */


public class SherlockValidString {

	public static void main(String[] args) {
		String s = "bbccccdd";
		System.out.println(isValid(s));
	}

	public static String isValid(String s) {
		char[] charArray = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (char c : charArray) {
			Integer val = map.get(c);
			if (val != null) {
				map.put(c, val + 1);
			} else {
				map.put(c, new Integer(1));
			}
		}
		Integer[] arr = map.values().toArray(new Integer[map.size()]);
		Arrays.sort(arr);
		int irregularCount = 0;
		int arrLength = arr.length;
		int max = arr[arrLength - 1];
		for (int i = 0; i < arrLength; i++) {
			int diff = max - arr[i];
			if (diff == 1) {
				irregularCount++;
				continue;
			} else if (diff == 0) {
				break;
			} else if (diff > 1) {
				if (i == 0 && arr[i] == 1) {
					continue;
				}
				return "NO";
			}
		}

		if (irregularCount == arrLength - 1) {
			return "YES";
		} else if (irregularCount > 1) {
			return "NO";
		}

		return "YES";

	}

}
