/**
* ============================================================
* Problem    : 1047. Remove All Adjacent Duplicates In String
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : String, Stack
* Pattern    : Stacks
*
* Link       : https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string
* ============================================================
*/

/*
Intuition

Whenever two adjacent characters are the same, they are removed.

Removing one pair may create a new adjacent duplicate, so the remaining
characters must be checked again.

Since we only need to compare the current character with the most recently
processed character, a Stack (LIFO) is the appropriate data structure.
*/

/*
Approach 1
Brute Force

Repeatedly traverse the string and remove every adjacent duplicate pair.

Continue this process until no adjacent duplicates remain.

Time: O(n²)
Space: O(n)
*/

/*
Approach 2
Optimal

Use a StringBuilder as a stack.

Iterate through each character in the string:
- If the current character matches the last character stored in the stack,
  remove the last character.
- Otherwise, append the current character to the stack.

After processing all the characters, the remaining characters form the final
string.

Time: O(n) - Iterate through the string once
Space: O(n) - In the worst case, all characters are stored in the stack
*/

package stacks;

public class P1047RemoveAllAdjacentDuplicatesInString{
    public static void main(String[] args){}

    // Optimised
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            int lastIndex = stack.length() - 1;
            if (lastIndex >= 0 && stack.charAt(lastIndex) == c) {
                stack.deleteCharAt(lastIndex);
            } else {
                stack.append(c);
            }
        }
        return stack.toString();
    }
}