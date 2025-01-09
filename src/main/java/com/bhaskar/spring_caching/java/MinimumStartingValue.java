package com.bhaskar.spring_caching.java;

public class MinimumStartingValue {

    public static int minimumStartingValue(int[] arr) {
        // Initialize variables to track the running sum and the minimum sum encountered
        int runningSum = 0;
        int minRunningSum = 0;

        // Calculate the running sum and track the minimum running sum
        for (int num : arr) {
            runningSum += num;
            minRunningSum = Math.min(minRunningSum, runningSum);
        }

        // To ensure the running sum is at least 1 at all times, the minimum starting value
        // needs to compensate for the lowest running sum.
        // If the minimum running sum is >= 0, then x can be 1.
        return 1 - minRunningSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -4, 5};
        int result = minimumStartingValue(arr);
        System.out.println("Minimum starting value: " + result);
    }
}