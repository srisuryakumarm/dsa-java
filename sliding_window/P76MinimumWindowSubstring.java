/**
* ============================================================
* Problem    : 76. Minimum Window Substring
* Platform   : LeetCode
* Difficulty : Hard
*
* Topics     : String, Hash Table, Sliding Window
* Pattern    : Sliding Window
*
* Link       : https://leetcode.com/problems/minimum-window-substring
* ============================================================
*/

/*
Intuition

We need to find the smallest substring of `s` that contains every character
from `t` with at least the required frequency.

The idea is to maintain a sliding window and keep track of the frequency of
characters from `t` inside the current window.

Expand the window until it contains all required characters. Then shrink the
window from the left while it remains valid, keeping track of the smallest
valid window found.
*/

/*
Approach
Sliding Window + HashMap

First, store the required frequency of each character from `t` in a HashMap.

Maintain another HashMap for the character frequencies inside the current
window of `s`.

Track how many distinct characters have reached their required frequency.

Expand the window by moving the right pointer. When all required characters
are present with the required frequencies, shrink the window from the left
while keeping it valid.

Whenever a smaller valid window is found, store its starting index and length.

Time: O(s + t)
Space: O(s + t)
*/

package sliding_window;

public class P76MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tmap.merge(t.charAt(i), 1, Integer::sum);
        }
        int l = 0, bs = 0, b = Integer.MAX_VALUE, f = 0;
        for (int r = 0; r < s.length(); r++) {
            smap.merge(s.charAt(r), 1, Integer::sum);
            if (tmap.containsKey(s.charAt(r))
                    && smap.get(s.charAt(r)).intValue() == tmap.get(s.charAt(r)).intValue()) {
                f++;
            }
            while (f == tmap.size()) {
                if (r - l + 1 < b) {
                    b = r - l + 1;
                    bs = l;
                }
                smap.put(s.charAt(l), smap.get(s.charAt(l)) - 1);
                if (tmap.containsKey(s.charAt(l))
                        && smap.get(s.charAt(l)) < tmap.get(s.charAt(l))) {
                    f--;
                }
                l++;
            }
        }
        return b == Integer.MAX_VALUE ? "" : s.substring(bs, bs + b);
    }
}