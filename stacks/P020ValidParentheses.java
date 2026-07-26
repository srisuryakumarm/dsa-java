/**
* ============================================================
* Problem    : 020. Valid Parentheses
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : String, Stack
* Pattern    : Stacks
*
* Link       : https://leetcode.com/problems/valid-parentheses
* ============================================================
*/

/*
Intuition

A string is considered valid only when every opening bracket is closed by the
corresponding closing bracket in the correct order.

Since we always need to evaluate the most recently inserted opening bracket,
a Stack (LIFO) is the appropriate data structure.
*/

/*
Approach 1
Brute Force

As a brute force approach, we repeatedly replace the valid bracket pairs
"()", "{}", and "[]" with empty strings ("").

If the input string becomes empty after all possible replacements,
the parentheses are valid. Otherwise, the string is invalid.

Time: O(n²) - Number of iterations × cost of each replacement
Space: O(n) - A new string is created during each replacement operation
*/

/*
Approach 2
Optimal

Use a stack to keep track of opening brackets.

Push every opening bracket onto the stack.
Whenever a closing bracket is encountered, pop the top element and verify that
it matches the corresponding opening bracket.

If a mismatch occurs or the stack is empty when processing a closing bracket,
the string is invalid.

After processing the entire string, the stack must be empty for the string to
be valid.

Time: O(n) - Iterate through the string once
Space: O(n) - In the worst case, all opening brackets are stored in the stack
*/

package stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class P020ValidParantheses{
    public static void main(String[] args){}

    //Brute Force
    public static boolean isValidParenthesesBrute(String s){
        boolean removeSomething = true;
        while(removeSomething){
            String before = s;
            s = s.replace("()","").replace("{}","").replace("[]","");
            removeSomething = !s.equals(before);
        }
        return s.isEmpty();
    }

    //Optimized
    public static boolean isValidParentheses(String s){
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                boolean mismatch = (c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[');
                if (mismatch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}