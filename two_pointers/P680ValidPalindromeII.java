/**
* ============================================================
* Problem    : 680. Valid Palindrome II
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : String, Two Pointers
* Pattern    : Two Pointers
*
* Link       : https://leetcode.com/problems/valid-palindrome-ii
* ============================================================
*/

/*
Intuition

A string can become a palindrome by removing at most one character.

The idea is to compare characters from both ends of the string. When the first
mismatch is found, try skipping either the left or the right character and
check whether the remaining substring forms a palindrome.
*/

/*
Approach 1
Two Pointers

Initialize one pointer at the beginning of the string and another at the end.

Compare the characters at both pointers while moving towards the center.

If a mismatch occurs, check whether the substring obtained by skipping either
the left character or the right character is a palindrome.

If either substring is a palindrome, return true. Otherwise, return false.

Time: O(n)
Space: O(1)
*/

package two_pointers;

public class P680ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindromeRange(s, left + 1, right) || isPalindromeRange(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRange(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}