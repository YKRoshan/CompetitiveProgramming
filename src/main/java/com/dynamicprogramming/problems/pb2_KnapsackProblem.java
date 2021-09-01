package com.dynamicprogramming.problems;

import java.util.HashMap;

public class pb2_KnapsackProblem {
	static int knapsackUsingRecursion(int wt[], int val[], int weight, int n) {
		//Base Condition
		if (weight == 0 || n == 0)
			return 0;
		//If weight is less than wt[n-1]
		if (wt[n - 1] <= weight)
			return Math.max(val[n - 1] + knapsackUsingRecursion(wt, val, weight - wt[n - 1], n - 1),
				knapsackUsingRecursion(wt, val, weight, n - 1));
		else
			return knapsackUsingRecursion(wt, val, weight, n - 1);
	}

	static int knapsackUsingMemoization(int wt[], int val[], int weight, int n, HashMap<Integer, Integer> memo) {

		if (weight == 0 || n == 0)
			return 0;
		if (memo.containsKey(weight)) {
			return memo.get(weight);
		}
		if (wt[n - 1] <= weight) {

			int ans = Math.max(val[n - 1] + knapsackUsingMemoization(wt, val, weight - wt[n - 1],
				n - 1, memo), knapsackUsingMemoization(wt, val, weight, n - 1, memo));
			memo.put(weight, ans);
			return memo.get(weight);
		} else {
			int ans = knapsackUsingMemoization(wt, val, weight, n - 1, memo);
			memo.put(weight, ans);
			return memo.get(weight);
		}
	}

	static int knapsackUsingTabulation(int w, int wt[], int val[], int n) {
		int[][] dp = new int[n + 1][w + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < w + 1; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
			}
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < w + 1; j++) {
				//If current weight is greater than (i-1)th wt element
				if (wt[i - 1] <= j) {
					//dp[i][j] = Max of (include (i-1)th wt element,
					// exclude (i-1)th wt element)
					dp[i][j] = Math.max(val[i - 1] +
						dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
				} else
					dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[n][w];
	}

	public static void main(String[] args) {
		int[] wt = new int[]{4, 8, 2, 6, 5};
		int[] val = new int[]{10, 8, 10, 24, 15};
		System.out.println(knapsackUsingRecursion(wt, val, 12, 5));

		HashMap<Integer, Integer> memo = new HashMap<>();
		System.out.println(knapsackUsingMemoization(wt, val, 12, 5, memo));

		System.out.println(knapsackUsingTabulation(12, wt, val, 5));
	}
}
