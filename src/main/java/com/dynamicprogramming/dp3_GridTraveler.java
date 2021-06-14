package com.dynamicprogramming;

public class dp3_GridTraveler {
    public static int gridTraveler(int n, int m) {
        if (n == 0 || m == 0)
            return 0;
        if (n == 1 && m == 1)
            return 1;
        return gridTraveler(n - 1, m) + gridTraveler(n, m - 1);
    }

    public static void main(String[] args) {
        System.out.println(gridTraveler(2, 2));
        System.out.println(gridTraveler(3, 2));
        System.out.println(gridTraveler(5, 5));
        System.out.println(gridTraveler(50,50));//It will take lots of time to execute
    }
}

