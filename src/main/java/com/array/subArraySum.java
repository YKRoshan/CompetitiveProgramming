package com.array;

import java.util.HashMap;
import java.util.Map;

public class subArraySum {
	public static void main(String[] args) {
		int[] arr = new int[]{3, 4, 13, 14, 6, 15, 5};
		System.out.println(finSubArraySum( arr,20));
		System.out.println(finSubArraySum( arr,20));
	}

	/*
	 * Given an unsorted array of non-negative integers,
	 * find the number of continuous sub-array which adds to a given number.
	 * */
	private static int finSubArraySum(int[] arr, int k) {
		int start = 0, end = 0, wSum = 0, count = 0;
		while (end < arr.length) {
			wSum += arr[end];
			while (start <= end && wSum >= k) {
				if (wSum == k) {
					count++;
				}
				wSum -= arr[start++];
			}
			end++;
		}
		return count;
	}

	/*
	 * Given an unsorted array of integers(non-negative and negative),
	 * find the number of continuous sub-array which adds to a given number.
	 * */
	static int findSubArraySum(int arr[], int k) {
		int count = 0, currSum = 0;
		Map<Integer, Integer> prevSum = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			currSum += arr[i];
			if (currSum == k) {
				count++;
			}
			if (prevSum.containsKey(currSum - k)) {
				count += prevSum.get(currSum - k);
			}
			prevSum.put(currSum, prevSum.get(currSum) == null ? 1 : prevSum.get(currSum) + 1);
		}
		return count;
	}
}