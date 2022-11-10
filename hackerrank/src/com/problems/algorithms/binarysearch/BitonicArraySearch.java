/**
 * 
 */
package com.problems.algorithms.binarysearch;



/**
 * @author Thangaraj Jawahar
 *
 * Mar 25, 2022
 * 
 * Search element in Distinct Bitonic Array, i.e., Array shape is like a mountain
 * 
 * Time complexity: Worst case = O(3 Logn)
 * 
 *
 */
public class BitonicArraySearch {
	
	
	public static int findMidPoint(int[] arr){
		int mid;
		int lo = 0;
		int hi = arr.length -1;
		int size = arr.length -1;
		
		if(size <= 1) {
			throw new IllegalArgumentException("For Bitonic Array, Length should be minimum 3");
		}
		
		while (lo <= hi) {
			mid = lo + (hi -lo) /2;
			
			if((mid-1) < 0 || (mid+1) > size) break;
			
			if (arr[mid] > arr [mid-1] && arr[mid] > arr[mid+1]) {
				return mid;
			} else if (arr[mid - 1] < arr[mid]) {
				lo = mid + 1;
			} else { // mid-1 > mid
				hi = mid - 1;
			}
		}
		return -1;
	}
	
	/**
	 * this will not work for if given array is not bitonic
	 *
	 *int
	 * @param arr
	 * @return
	 */
	/*public static int findMidPoint(int[] arr){
		int mid;
		int lo = 0;
		int hi = arr.length -1;
		int size = arr.length -1;
		
		if(size <= 1) {
			throw new IllegalArgumentException("For Bitonic Array, Length should be minimum 3");
		}
		
		return findMidPointBest(arr, lo, hi);
	}
	
	public static int findMidPointBest(int[] arr, int l, int r) {
		int mid = l+(r-l)/2;
		if((mid-1) < 0 || (mid+1) > (arr.length-1)) return -1;
		if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
			return mid;
			// in ascending way
		} else if (arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]) {
			return findMidPointBest(arr, mid, r);
			// in descending way
		} else if (arr[mid] < arr[mid-1] && arr[mid] > arr[mid+1]) {
			return findMidPointBest(arr, l, mid);
		} else {
			return -1;
		}
	}*/
	
	private static int ascSearch(int[] arr, int mid, int k) {
		int lo = 0;
		int hi = mid;

		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			if (k < arr[mid]) {
				hi = mid - 1;
			} else if (k > arr[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	private static int descSearch(int[] arr, int mid, int k) {
		int lo = mid;
		int hi = arr.length-1;

		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			if (k < arr[mid]) {
				lo = mid + 1;
			} else if (k > arr[mid]) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	public static int findElemIndex(int[] arr, int k) {
		int mid = findMidPoint(arr);
		System.out.println("mid: " + mid);
		int outIndex = -1;
		if (mid == -1) {
			System.out.println("Given array is not bitonic !!!");
			return outIndex;
		} else if (arr[mid] == k) {
			outIndex = mid;
		}
		int ascOut = ascSearch(arr, mid, k);
		if (ascOut == -1) {
			outIndex = descSearch(arr, mid, k);
		} else {
			outIndex = ascOut;
		}
		return outIndex;
	}
	
	

	/**
	 *
	 *void
	 * @param args
	 * @throws InvalidDataException 
	 */
	public static void main(String[] args)  {
		//int[] arr = {10,19,20,25,26,1,0,-1};
		int[] arr = {10,19,20,25,26,15,13,12};
		int search = 25;
		int output = findElemIndex(arr, search);
		System.out.println("search for: " + search + ", output:" +output);
	}

}
