/**
* ============================================================
* Problem    : 567. Permutation in String
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Strings, Sliding Window, Hash Table
* Pattern    : Sliding Window
*
* Link       : https://leetcode.com/problems/permutation-in-string
* ============================================================
*/

/*
Intuition

A permutation of `s1` must have exactly the same character frequencies as `s1`.

Therefore, we need to find a substring in `s2` whose length is equal to the
length of `s1` and whose character frequencies match the frequencies of `s1`.

The idea is to maintain a fixed-size sliding window in `s2` and compare its
character frequencies with those of `s1`.
*/

/*
Approach 1
Frequency Counting + Fixed Sliding Window

Create frequency arrays for `s1` and the current window in `s2`.

Traverse `s2` while maintaining a window whose size is equal to the length of
`s1`.

Add the new character entering the window and remove the character leaving the
window.

If the frequency arrays are equal, the current window is a permutation of
`s1`.

Time: O(n* 26)
Space: O(1)
*/

/*
Approach 2
Frequency Counting + Fixed Sliding Window

Create two frequency arrays and initialize them using the first window of
`s2`, whose size is equal to the length of `s1`.

Then slide the window through `s2`.

Before moving the window, check whether the current window has the same
frequency as `s1`.

After checking, add the new character entering the window and remove the
character leaving the window.

Finally, check the last window after the loop.

Time: O(n* 26)
Space: O(1)
*/

package sliding_window;

public class P567PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        // int[] count1 = new int[26];
        // int[] count2 = new int[26];
        // for (int i = 0; i < s1.length(); i++) {
        //     count1[s1.charAt(i) - 'a']++;
        // }
        // for (int r = 0; r < s2.length(); r++) {
        //     count2[s2.charAt(r) - 'a']++;
        //     if (r >= s1.length()) {
        //         count2[s2.charAt(r - s1.length()) - 'a']--;
        //     }
        //     if (r >= s1.length() - 1 && Arrays.equals(count1, count2)) {
        //         return true;
        //     }
        // }
        // return false;

        // Another Approach
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            if (Arrays.equals(count1, count2)) {
                return true;
            }
            count2[s2.charAt(i) - 'a']++;
            count2[s2.charAt(i - s1.length()) - 'a']--;
        }
        return Arrays.equals(count1, count2);
    }
}