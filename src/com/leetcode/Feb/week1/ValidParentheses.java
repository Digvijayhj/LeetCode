package com.leetcode.Feb.week1;
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

        An input string is valid if:

        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.


        Example 1:

        Input: s = "()"
        Output: true
        Example 2:

        Input: s = "()[]{}"
        Output: true
        Example 3:

        Input: s = "(]"
        Output: false
*/
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    static Map<Character, Character> map = new HashMap<>();
    static {
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c))
                stack.push(map.get(c)); // push closing braces
            else if (map.containsValue(c))
                if (stack.empty() || stack.pop() != c)
                    return false;
        }
        return stack.empty();
    }
}
