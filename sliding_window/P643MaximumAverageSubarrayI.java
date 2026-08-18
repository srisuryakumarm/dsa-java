/**
* ============================================================
* Problem    : 643. Maximum Average Subarray I
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Arrays, Sliding Window
* Pattern    : Sliding Window
*
* Link       : https://leetcode.com/problems/maximum-average-subarray-i
* ============================================================
*/

/*
Intuition

We need to find the subarray of length `k` with the maximum average.

Since every subarray has the same length `k`, the subarray with the maximum
average is also the subarray with the maximum sum.

The idea is to maintain the sum of a window of size `k` and slide the window
through the array by adding the new element and removing the element that is no
longer part of the window.
*/

/*
Approach
Sliding Window

First, calculate the sum of the first `k` elements and use it as the maximum
window sum.

Then slide the window one position at a time. Add the new element entering
the window and subtract the element leaving the window.

Update the maximum window sum after each slide.

Finally, divide the maximum window sum by `k` to get the maximum average.

Time: O(n)
Space: O(1)
*/

package sliding_window;

public class P643MaximumAverageSubarrayI {


    public double findMaxAverage(int[] nums, int k) {
        long sum = 0, maxSum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum / (double) k;
    }
}