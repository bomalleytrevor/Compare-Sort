package com.sort.compare;

public class StudentSort implements Sort {

	public String getName() {
		// CODE IN HERE
		return "Bubble";
		// CODE IN HERE
	}
	
	/**
	 * Try different sorts here
	 */
	public int[] sort(int[] arr) {
		
		// CODE IN HERE
		int n = arr.length;
		int temp = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		// CODE IN HERE
		
		return arr;
	}
}
