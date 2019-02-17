package com.sort.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortWithMetrics {
	
	public static List<SortMetric> compileSortResults(Difficulty difficulty) throws Exception {

		int[] numberPool = new int[10000000];

		Random rand = new Random();
		
		System.out.println("Generating random numbers...");
		
		for (int i = 0; i < 100000; i++) {
			numberPool[i] = rand.nextInt(1000000);
		}
		
		List<Sort> sorts = Arrays.asList(new MergeSort(), new StudentSort());
		
		List<SortMetric> sortResults = new ArrayList<SortMetric>();

		for (Sort sort : sorts) {
			
			System.out.println("Running " + sort.getName() + "...");

			for (Integer setSize : SortWithMetrics.getSetSizes(difficulty)) {
				
				System.out.println("Running sort on " + setSize + " values...");
				
				int[] toSort = new int[setSize];
				
				System.arraycopy(numberPool, 0, toSort, 0 , setSize);

				// Sort 1
				long startTime = System.currentTimeMillis();
	
				int[] sorted = sort.sort(toSort);

				long elapsedTime = System.currentTimeMillis() - startTime;
				
				SortWithMetrics.testSort(sorted);
				
				SortMetric sortMetric = new SortMetric();
				sortMetric.setSpeedInMs(elapsedTime);
				sortMetric.setItemCount(setSize);
				sortMetric.setSortType(sort.getName());

				sortResults.add(sortMetric);
			}
		}

		return sortResults;
	}
	
	private static void testSort(int[] arr) throws Exception {
		int prevVal = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(prevVal>arr[i]) {
				throw new Exception("Sort failed to put list in order");
			}
		}
	}

	private static List<Integer> getSetSizes(Difficulty difficulty) {
		
		int seqAmount = 0;
		
		if (difficulty == Difficulty.EASY) {
			
			seqAmount = 4000;
			
		} else if(difficulty == Difficulty.MEDIUM) {
			
			seqAmount = 50000;
			
		} else if(difficulty == Difficulty.HARD) {
			
			seqAmount = 1000000;
			
		} else {
			
			// Unimplemented
		}
		
		List<Integer> setSizes = new ArrayList<Integer>();
		
		for(int i=1; i<7; i++) {
			
			setSizes.add(i*seqAmount);
		}
		
		return setSizes;
	}
}
