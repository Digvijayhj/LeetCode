package com.leetcode.May;

import java.util.*;

public class StockBuyAndSellSolution {

    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};

        int maxPro = maxProfit(arr);
        System.out.println("Max profit is: " + maxPro);

    }
    static int maxProfit(int[] arr) {
        int MAX_VALUE = Integer.MIN_VALUE;
        int min_value = Integer.MAX_VALUE;
        for (int i=0; i<arr.length; i++) {
            min_value = Math.min(min_value, arr[i]);
            MAX_VALUE = Math.max(MAX_VALUE, arr[i] - min_value);
        }
        return MAX_VALUE;
    }
}

