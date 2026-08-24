/**
* ============================================================
* Problem    : 438. Find All Anagrams in a String
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : String, Sliding Window, Hash Table
* Pattern    : Sliding Window
*
* Link       : https://leetcode.com/problems/find-all-anagrams-in-a-string
* ============================================================
*/

/*
Intuition

An anagram of `p` must contain the same characters with the same frequencies.

The idea is to maintain a fixed-size window in `s` with the same length as `p`.
For each window, compare its character frequencies with the frequencies of `p`.

If both frequency arrays are equal, the current window is an anagram of `p`.
*/

/*
Approach
Fixed Sliding Window + Frequency Counting

Create two frequency arrays: one for the characters in `p` and one for the
current window in `s`.

Initialize the first window with the same length as `p`.

Then slide the window through `s` by adding the new character entering the
window and removing the character leaving the window.

Compare the frequency arrays after each window update. If they are equal,
add the starting index of the window to the result.

Time: O(n)
Space: O(1)
*/

package sliding_window;

public class P438FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        int[] scount = new int[26];
        int[] pcount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            scount[s.charAt(i) - 'a']++;
            pcount[p.charAt(i) - 'a']++;
        }
        if (isValidAnagram(scount, pcount)) {
            list.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            scount[s.charAt(i) - 'a']++;
            scount[s.charAt(i - p.length()) - 'a']--;
            if (isValidAnagram(scount, pcount)) {
                list.add(i - p.length() + 1);
            }
        }
        return list;
    }

    public boolean isValidAnagram(int[] s, int[] p) {
        for (int i = 0; i < 26; i++) {
            if (s[i] != p[i]) {
                return false;
            }
        }
        return true;
    }
}