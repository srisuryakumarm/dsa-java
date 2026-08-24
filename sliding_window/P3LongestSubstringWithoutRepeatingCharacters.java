/**
* ============================================================
* Problem    : 3. Longest Substring Without Repeating Characters
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Strings, Hash Table, Sliding Window
* Pattern    : Sliding Window
*
* Link       : https://leetcode.com/problems/longest-substring-without-repeating-characters
* ============================================================
*/

/*
Intuition

We need to find the longest substring that contains no repeating characters.

The idea is to maintain a sliding window containing only unique characters.

When a duplicate character is found, move the left pointer forward and remove
characters from the Set until the duplicate character is removed.

At every step, keep track of the maximum window length.
*/

/*
Approach
Sliding Window + HashSet

Use a HashSet to store the characters currently present in the sliding window.

Move the right pointer through the string and add each character to the Set.

If the current character already exists in the Set, move the left pointer forward
and remove characters from the Set until the duplicate character is removed.

Then add the current character to the Set and update the maximum window length.

Time: O(n)
Space: O(n)
*/

package sliding_window;

public class P3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, b = 0;
        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            b = Math.max(b, r - l + 1);
        }
        return b;
    }
}