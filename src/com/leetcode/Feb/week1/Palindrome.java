package com.leetcode.Feb.week1;

public class Palindrome {
    public boolean isPalindrome(int x) {
        String rev = new StringBuilder().append(x).reverse().toString();
        String org = String.valueOf(x);
        if(rev.equals(org))
            return true;
        else
            return false;
    }
}
