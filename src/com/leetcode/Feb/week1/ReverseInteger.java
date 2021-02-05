package com.leetcode.Feb.week1;

public class ReverseInteger {
    public static void main(String[] args) {
        reverse();
    }
    public static void reverse() {
        int x = 1534236469;
        String reversed = new StringBuilder().append(Math.abs(x)).reverse().toString();
        try {
            if ((x < 0)) {
                Integer.parseInt(reversed);
            } else {
                Integer.parseInt(reversed);
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println(0);
        }

    }
}
