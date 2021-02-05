package com.leetcode.Feb.week1;

import java.util.HashMap;

import static java.lang.System.*;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum sum = new TwoSum();
        int[] res = sum.twoSum(new int[]{2,7,11,5},12);
        for (int ele: res)
            out.println(ele);
    }

    // Hash map approach
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i< nums.length;i++)
        {
            int diff = target - nums[i];
            if(map.containsKey(diff))
                return new int[] {i,map.get(diff)};
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No Match Found");
    }

}
