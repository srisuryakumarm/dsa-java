/**
* ============================================================
* Problem    : 167. Two Sum II - Input Array Is Sorted
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : String, Two Pointers
* Pattern    : Two Pointers
*
* Link       : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
* ============================================================
*/

/*
Intuition

Since the array is already sorted, the sum of the two elements can be adjusted
by moving one of the pointers.

If the current sum is greater than the target, move the right pointer to reduce
the sum. If the current sum is smaller than the target, move the left pointer
to increase the sum.
*/

/*
Approach 1
Two Pointers

Initialize one pointer at the beginning of the array and another at the end.

Calculate the sum of the elements at both pointers.

- If the sum equals the target, return their 1-based indices.
- If the sum is greater than the target, move the right pointer left.
- If the sum is smaller than the target, move the left pointer right.

Continue until the required pair is found.

Time: O(n)
Space: O(1)
*/

package two_pointers;

public class P167TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[] { -1, -1 };
    }
}