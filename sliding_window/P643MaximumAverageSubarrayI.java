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

Since every subarray contains exactly `k` elements, the subarray with the
maximum average is also the subarray with the maximum sum.

The idea is to find the maximum sum of any subarray of size `k` and then divide
that sum by `k` to get the maximum average.
*/

/*
Approach 1
Brute Force

Consider every possible subarray of size `k`.

For each starting position, calculate the sum of the next `k` elements and
keep track of the maximum sum.

Finally, divide the maximum sum by `k` to get the maximum average.

Time: O(n* k)
Space: O(1)
*/

/*
Approach 2
Sliding Window

First, calculate the sum of the first `k` elements and use it as the maximum
window sum.

Then slide the window through the array by adding the new element entering the
window and removing the element leaving the window.

Update the maximum window sum after each slide.

Finally, divide the maximum window sum by `k` to get the maximum average.

Time: O(n)
Space: O(1)
*/

package sliding_window;

public class P643MaximumAverageSubarrayI {

    // Brute Force
    // int maxSum = Integer.MIN_VALUE;
    // for (int i = 0; i <= nums.length - k; i++) {
    //     int sum = 0;
    //     for (int j = i; j < i + k; j++) {
    //         sum += nums[j];
    //     }
    //     maxSum = Math.max(maxSum, sum);
    // }
    // return (double) maxSum / k;

    // Optimised - Sliding Window
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        long maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum / (double) k;
    }
}