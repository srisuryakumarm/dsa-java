/**
* ============================================================
* Problem    : 53. Maximum Subarray
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Dynamic Programming
* Pattern    : Kadane's Algorithm
*
* Link       : https://leetcode.com/problems/maximum-subarray
* ============================================================
*/

/*
Intuition

We need to find the contiguous subarray with the largest sum.

The idea is to keep track of the maximum sum of a subarray ending at the
current position.

For each element, we can either start a new subarray from the current element
or extend the previous subarray.

The maximum subarray sum found so far is updated at every position.
*/

/*
Approach
Kadane's Algorithm

Maintain `currentSum` as the maximum sum of a subarray ending at the current
index.

For each element, compare the current element with the sum of the current
element and the previous `currentSum`, and keep the larger value.

Update `maxSum` with the maximum value of `currentSum`.

Time: O(n)
Space: O(1)
*/

package prefix_sum_kadanes;

public class P53MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}