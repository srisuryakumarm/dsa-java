/**
* ============================================================
* Problem    : 340. Longest Substring with At Most K Distinct Characters
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : String, Hash Table, Sliding Window
* Pattern    : Sliding Window
*
* Link       : https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters
* ============================================================
*/

/*
Intuition

We need to find the longest substring that contains at most `k` distinct
characters.

The idea is to maintain a sliding window and keep track of the frequency of
each character inside the window.

When the window contains more than `k` distinct characters, shrink it from the
left until it becomes valid again.
*/

/*
Approach
Sliding Window + HashMap

Use a HashMap to store the frequency of each character in the current window.

Expand the window by moving the right pointer and increasing the frequency of
the current character.

If the number of distinct characters becomes greater than `k`, move the left
pointer forward and decrease the frequency of the characters leaving the
window. Remove a character from the HashMap when its frequency becomes zero.

After the window becomes valid, update the maximum window length.

Time: O(n)
Space: O(n)
*/

package sliding_window;

public class P340LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int l = 0, b = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            map.merge(s.charAt(r), 1, Integer::sum);
            while (map.size() > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0) {
                    map.remove(s.charAt(l));
                }
                l++;
            }
            b = Math.max(b, r - l + 1);
        }
        return b;
    }
}