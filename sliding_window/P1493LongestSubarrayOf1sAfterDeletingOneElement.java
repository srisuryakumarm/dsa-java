/**
* ============================================================
* Problem    : 1493. Longest Subarray of 1's After Deleting One Element
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Sliding Window
* Pattern    : Sliding Window
*
* Link       : https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element
* ============================================================
*/

/*
Intuition

We need to find the longest subarray of 1s after deleting exactly one element.

The idea is to maintain a sliding window containing at most one zero. Since one
element must be deleted, the length of the valid result is the current window
length minus one.

When the window contains more than one zero, move the left pointer forward until
the window contains at most one zero again.
*/

/*
Approach
Sliding Window

Use two pointers to maintain a window containing at most one zero.

Move the right pointer through the array and count the number of zeroes in the
current window.

If the number of zeroes becomes greater than one, move the left pointer forward
and decrease the zero count whenever a zero leaves the window.

Since one element must always be deleted, use the window length minus one as
the candidate result.

Time: O(n)
Space: O(1)
*/

package sliding_window;

public class P1493LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int l = 0, b = 0, z = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                z++;
            }
            while (z > 1) {
                if (nums[l] == 0) {
                    z--;
                }
                l++;
            }
            b = Math.max(b, r - l);
        }
        return b;
    }
}