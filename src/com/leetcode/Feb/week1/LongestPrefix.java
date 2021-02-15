package com.leetcode.Feb.week1;

public class LongestPrefix {
    public String solution(String[] str)
    {
        String prefix = str[0];
        if (str.length==0) return "";

        for(int i=1; i<str.length; i++)
        {
            while(str[i].indexOf(prefix) != 0)
            {
                prefix = prefix.substring(0, prefix.length() -1);
                if (prefix.isEmpty())   return "";
            }
        }
        return prefix;
    }

//    public static void main(String[] args) {
//        try {
//            LongestPrefix longestPrefix = new LongestPrefix();
//            String[] strs = new String[]{"flower", "flow", "flight"};
//            String prefix = longestPrefix.solution(strs);
//            System.out.println(prefix);
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
//    }
}
