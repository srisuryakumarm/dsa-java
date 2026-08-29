/**
* ============================================================
* Problem    : 152. Maximum Product Subarray
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Dynamic Programming
* Pattern    : Kadane's Algorithm
*
* Link       : https://leetcode.com/problems/maximum-product-subarray
* ============================================================
*/

/*
Intuition

The maximum product of a subarray can be affected by negative numbers.

A negative number can turn a small negative product into a large positive
product. Therefore, we need to keep track of both the maximum and minimum
product ending at the current position.

Whenever the current number is negative, the maximum and minimum products
switch their roles.

At each position, update the maximum product and keep track of the overall
maximum product found.
*/

/*
Approach
Kadane's Algorithm

Maintain `currentMax` as the maximum product of a subarray ending at the
current index and `currentMin` as the minimum product ending at the current
index.

If the current number is negative, swap `currentMax` and `currentMin` because
multiplying by a negative number reverses their roles.

Then, calculate the new maximum and minimum products by either starting a new
subarray with the current number or extending the previous product.

Update the overall result using `currentMax`.

Time: O(n)
Space: O(1)
*/

package prefix_sum_kadanes;

public class P152MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }
            currentMax = Math.max(nums[i], currentMax* nums[i]);
            currentMin = Math.min(nums[i], currentMin* nums[i]);
            result = Math.max(result, currentMax);
        }
        return result;
    }
}