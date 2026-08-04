/**
* ============================================================
* Problem    : 392. Is Subsequence
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : String, Two Pointers
* Pattern    : Two Pointers
*
* Link       : https://leetcode.com/problems/is-subsequence
* ============================================================
*/

/*
Intuition

A string is a subsequence if all its characters appear in the same relative
order within another string.

The idea is to traverse the larger string while matching the characters of the
smaller string in sequence.
*/

/*
Approach 1
Recursion

Compare the current characters of both strings.

If they match, move to the next character in both strings. Otherwise, move
only to the next character in the second string.

If all characters in the first string are matched, return true. If the second
string is exhausted first, return false.

Time: O(s + t)
Space: O(s + t)
*/

/*
Approach 2
Two Pointers

Initialize one pointer for each string.

Traverse the second string while matching the current character of the first
string. Whenever the characters match, move both pointers. Otherwise, move
only the pointer of the second string.

If all characters of the first string are matched, it is a subsequence.

Time: O(s + t)
Space: O(1)
*/

package two_pointers;

public class P392IsSubsequence {
    // Brute Force
     public boolean isSubsequenceBrute(String s, String t) {
         return helper(s, t, 0, 0);
     }

     public static boolean helper(String s, String t, int i, int j) {
         if (i == s.length()) {
             return true;
         }
         if (j == t.length()) {
             return false;
         }
         if (s.charAt(i) == t.charAt(j)) {
             return helper(s, t, i + 1, j + 1);
         }
         return helper(s, t, i, j + 1);
     }

    // Optimised - Two Pointers
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}