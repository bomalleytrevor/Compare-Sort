package com.sort.compare;

public class MergeSort implements Sort {
	
    private int[] numbers;
    private int[] helper;

    private int number;

    private void mergesort(int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
    }

	public int[] sort(int[] arr) {
		this.numbers = arr;
        number = arr.length;
        this.helper = new int[number];
        mergesort(0, number - 1);		
        return arr;
	}

	public String getName() {
		return "Merge";
	}
}
