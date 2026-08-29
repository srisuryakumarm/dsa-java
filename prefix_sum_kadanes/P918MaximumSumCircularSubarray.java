/**
* ============================================================
* Problem    : 918. Maximum Sum Circular Subarray
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Kadane's Algorithm
* Pattern    : Kadane's Algorithm
*
* Link       : https://leetcode.com/problems/maximum-sum-circular-subarray
* ============================================================
*/

/*
Intuition

The maximum subarray in a circular array can be either a normal subarray that
does not wrap around the end of the array or a subarray that wraps around the
end.

For a normal subarray, we can use Kadane's Algorithm to find the maximum sum.

For a wrapping subarray, instead of directly finding the maximum wrapping
subarray, find the minimum subarray and remove it from the total sum.

The wrapping sum can then be calculated as:

total sum - minimum subarray sum

Finally, take the maximum of the normal maximum subarray sum and the wrapping
subarray sum.
*/

/*
Approach
Kadane's Algorithm

Maintain the total sum of the array along with the maximum and minimum
subarray sums using Kadane's Algorithm.

For every element:
- Update the maximum subarray sum.
- Update the minimum subarray sum.
- Add the element to the total sum.

The maximum circular subarray sum is the maximum of:
- The maximum normal subarray sum.
- `totalSum - minSum`, which represents the maximum wrapping subarray sum.

If all elements are negative, return `maxSum` directly because `totalSum -
minSum` would incorrectly represent an empty subarray.

Time: O(n)
Space: O(1)
*/

package prefix_sum_kadanes;

public class P918MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int currentMin = 0;
        int currentMax = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        for (int num : nums) {
            totalSum += num;
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);
        }
        if (maxSum < 0) {
            return maxSum;
        }
        return Math.max(maxSum, totalSum - minSum);
    }
}