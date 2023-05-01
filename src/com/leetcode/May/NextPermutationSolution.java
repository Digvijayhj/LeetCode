package com.leetcode.May;

import java.util.*;

public class NextPermutationSolution {
    public static void nextPermutation(int[] nums) {
        int n =  nums.length;
        int index = -1;
        // find break point
        for(int i=n-2; i>=0; i--) {
            if(nums[i]<nums[i+1])
            {
                index = i;
                break;
            }
        }
        // if no permutation is found return ASC order array
        if(index == -1) {
            Arrays.sort(nums);
            return;
        }

        //swap next greater number and break
        for(int i=n-1; i>index; i--) {
            if(nums[i]>nums[index])
            {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }
//        System.out.println(Arrays.toString(nums));
        //sort remaining sub array to get next greater permutation
        Arrays.sort(nums, index+1, n);

    }

    public static void main(String[] args) {
        var ans = new int[] {1,2,3};
        nextPermutation(ans);

        System.out.print("The next permutation is: [");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println("]");
    }
}
