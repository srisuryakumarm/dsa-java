/**
* ============================================================
* Problem    : 209. Minimum Size Subarray Sum
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Sliding Window
* Pattern    : Sliding Window
*
* Link       : https://leetcode.com/problems/minimum-size-subarray-sum
* ============================================================
*/

/*
Intuition

We need to find the smallest subarray whose sum is greater than or equal to
the target.

Since all elements in the array are positive, expanding the window increases
its sum, while shrinking the window decreases its sum.

The idea is to expand the window until its sum reaches the target, then shrink
it from the left as much as possible while keeping the sum greater than or
equal to the target.
*/

/*
Approach
Sliding Window

Use two pointers to maintain a sliding window.

Move the right pointer through the array and add each element to the current
sum.

Whenever the sum becomes greater than or equal to the target, update the
minimum window length and move the left pointer forward while the window still
satisfies the condition.

If no valid subarray is found, return 0.

Time: O(n)
Space: O(1)
*/

package sliding_window;

public class P209MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, sum = 0, b = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                b = Math.min(b, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return b == Integer.MAX_VALUE ? 0 : b;
    }
}