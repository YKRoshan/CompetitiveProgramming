package com.dynamicprogramming;

public class dp18_GridTravelerUsingTabulation {
    public static Long gridTraveler(int m, int n) {
        Long table[][] = new Long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = Long.valueOf(0);
            }
        }
        table[0][0] = Long.valueOf(1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Long value = Long.valueOf(table[i][j]);
                if (i < m - 1) {
                    table[i + 1][j] += value;
                }
                if (j < n - 1) {
                    table[i][j + 1] += value;
                }
            }
        }
        return table[m - 1][n - 1];
    }

    public static void main(String[] args) {
        // System.out.println(gridTraveler(2, 2));
        //System.out.println(gridTraveler(3, 2));
        System.out.println(gridTraveler(10, 10));
        //System.out.println(gridTraveler(50, 50));
    }
}
