package com.leetcode.May;

public class MaxSumSubArray {

    public static int maxSubArray(int[] nums) {

        if(nums.length==1)
            return nums[0];

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=0; i<nums.length; i++) {

            sum += nums[i];

            max = Math.max(max, sum);

            if (sum<0)
                sum =0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        int maxSum = maxSubArray(arr);
        System.out.println("The maximum subarray sum is: " + maxSum);
    }
}
