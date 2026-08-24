/**
* ============================================================
* Problem    : 1004. Max Consecutive Ones III
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Sliding Window
* Pattern    : Sliding Window
*
* Link       : https://leetcode.com/problems/max-consecutive-ones-iii
* ============================================================
*/

/*
Intuition

We need to find the longest subarray containing at most `k` zeroes.

The idea is to maintain a sliding window and keep track of the number of zeroes
inside it.

If the window contains more than `k` zeroes, move the left pointer forward until
the window becomes valid again.

At every step, keep track of the maximum valid window length.
*/

/*
Approach
Sliding Window

Use two pointers to maintain a sliding window.

Expand the window by moving the right pointer and count the number of zeroes
inside the window.

If the number of zeroes becomes greater than `k`, move the left pointer forward
and decrease the zero count whenever a zero leaves the window.

After the window becomes valid, update the maximum window length.

Time: O(n)
Space: O(1)
*/

package sliding_window;

public class P1004MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int l = 0, b = 0, z = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                z++;
            }
            while (z > k) {
                if (nums[l] == 0) {
                    z--;
                }
                l++;
            }
            b = Math.max(b, r - l + 1);
        }
        return b;
    }
}