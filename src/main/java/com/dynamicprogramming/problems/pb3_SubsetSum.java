package com.dynamicprogramming.problems;

public class pb3_SubsetSum {

	static Boolean isSubsetSum(int n, int arr[], int sum) {
		boolean[][] dp = new boolean[n + 1][sum + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0)
					dp[i][j] = false;
				if (j == 0)
					dp[i][j] = true;
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				//If current sum (j) is less than arr[i-1]
				if (arr[i - 1] <= j) {
					//dp[i][j] = After including arr[i-1] || After excluding arr[i-1]
					dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][sum];
	}

	public static void main(String[] args) {
		int[] arr = new int[]{10, 8, 10, 24, 15};

		System.out.println(isSubsetSum(5, arr, 25));
	}
}
