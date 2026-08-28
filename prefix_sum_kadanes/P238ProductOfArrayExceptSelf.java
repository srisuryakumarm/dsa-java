/**
* ============================================================
* Problem    : 238. Product of Array Except Self
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Prefix Sum
* Pattern    : Prefix & Suffix Products
*
* Link       : https://leetcode.com/problems/product-of-array-except-self
* ============================================================
*/

/*
Intuition

For every index, we need the product of all elements except the element at
that index.

The idea is to calculate the product of all elements to the left of each index
and store it in the result array.

Then, traverse the array from right to left while maintaining the product of
all elements to the right and multiply it with the value already stored in the
result array.
*/

/*
Approach
Prefix & Suffix Products

First, build the prefix product for each index.

`result[i]` stores the product of all elements before index `i`.

Then, traverse the array from right to left while maintaining the suffix
product.

Multiply the current suffix product with `result[i]` and then update the suffix
product using the current element.

This gives the product of all elements except the current element without using
division.

Time: O(n)
Space: O(1) - Excluding the output array
*/

package prefix_sum&kadanes;

public class P238ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1]* nums[i - 1];
        }
        int suffixProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i]*= suffixProduct;
            suffixProduct*= nums[i];
        }
        return result;
    }
}