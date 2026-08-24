/**
* ============================================================
* Problem    : 424. Longest Repeating Character Replacement
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : String, Hash Table, Sliding Window
* Pattern    : Sliding Window
*
* Link       : https://leetcode.com/problems/longest-repeating-character-replacement
* ============================================================
*/

/*
Intuition

We need to find the longest substring that can be made to contain the same
character by replacing at most `k` characters.

For any window, the minimum number of replacements required is the window
length minus the frequency of the most frequent character in that window.

If the number of required replacements becomes greater than `k`, shrink the
window from the left until it becomes valid again.
*/

/*
Approach
Sliding Window + Frequency Counting

Use a frequency array to count the characters inside the current window.

For every character added to the window, update its frequency and keep track of
the highest frequency of any character in the window.

The number of characters that need to be replaced is:

window length - maximum character frequency

If this value becomes greater than `k`, move the left pointer forward and
decrease the frequency of the character leaving the window.

Track the maximum valid window length throughout the traversal.

Time: O(n)
Space: O(1)
*/

package sliding_window;

public class P424LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int l = 0, b = 0, maxFreq = 0;
        int[] freq = new int[26];
        for (int r = 0; r < s.length(); r++) {
            freq[s.charAt(r) - 'A']++;
            maxFreq = Math.max(
                    maxFreq,
                    freq[s.charAt(r) - 'A']
            );
            if ((r - l + 1) - maxFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            b = Math.max(b, r - l + 1);
        }
        return b;
    }
}