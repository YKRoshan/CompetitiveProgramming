package com.dynamicprogramming.problems;

public class pb4_CountSubsetSum {

	static int CountSubsetSum(int n, int arr[], int sum) {
		if (sum == 0 )
			return 1;
		if (n==0)return 0;
		if (arr[n - 1] <= sum) {
			int count= CountSubsetSum(n - 1, arr, sum - arr[n - 1]) +
				CountSubsetSum(n - 1, arr, sum);
			return count;
		} else {
			int count= CountSubsetSum(n - 1, arr, sum);
			return count;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1, 25, 10, 24, 15};

		System.out.println(CountSubsetSum(5, arr, 25));
	}
}
