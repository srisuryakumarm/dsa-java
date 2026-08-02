/**
* ============================================================
* Problem    : 125. Valid Palindrome
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : String, Two Pointers
* Pattern    : Two Pointers
*
* Link       : https://leetcode.com/problems/valid-palindrome
* ============================================================
*/

/*
Intuition

A palindrome reads the same from both ends.

The idea is to compare characters from the beginning and the end while
ignoring non-alphanumeric characters and treating uppercase and lowercase
letters as equal.
*/

/*
Approach 1
Cleaned String

Create a new string containing only lowercase alphanumeric characters.

Use two pointers to compare characters from both ends of the cleaned string.
If all corresponding characters match, the string is a palindrome.

Time: O(n)
Space: O(n)
*/

/*
Approach 2
Optimised

Use two pointers, one starting from the beginning and the other from the end
of the string.

Skip all non-alphanumeric characters and compare the remaining characters
after converting them to the same case.

If every corresponding pair of characters matches, the string is a palindrome.

Time: O(n)
Space: O(1)
*/

package two_pointers;

public class P125ValidPalindrome {
    // Cleaned String
    public boolean isPalindrome(String s) {
         StringBuilder cleaned = new StringBuilder();
         for (char c : s.toCharArray()) {
             if (Character.isLetterOrDigit(c)) {
                 cleaned.append(Character.toLowerCase(c));
             }
         }
         int left = 0, right = cleaned.length() - 1;
         while (left < right) {
             if (cleaned.charAt(left) != cleaned.charAt(right)) {
                 return false;
             }
             left++;
             right--;
         }
         return true;
    }

    // Optimised
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}