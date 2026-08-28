/**
* ============================================================
* Problem    : 303. Range Sum Query - Immutable
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Arrays, Prefix Sum
* Pattern    : Prefix Sum
*
* Link       : https://leetcode.com/problems/range-sum-query-immutable
* ============================================================
*/

/*
Intuition

We need to calculate the sum of elements between two indices multiple times.

Instead of calculating the sum of every range repeatedly, we can precompute the
sum of all elements from the beginning of the array up to each index.

Then, the sum of any range can be calculated by subtracting the prefix sum
before the range from the prefix sum at the end of the range.
*/

/*
Approach
Prefix Sum

Create a prefix sum array where `prefix[i]` stores the sum of the first `i`
elements of the input array.

For a range from `left` to `right`, the required sum can be calculated by
subtracting `prefix[left]` from `prefix[right + 1]`.

Time: O(n) - Prefix Sum construction
Space: O(n) - Prefix Sum array

sumRange:
Time: O(1)
Space: O(1)
*/

package prefix_sum&kadanes;

public class P303RangeSumQueryImmutable {
    class NumArray {
        private final int[] prefix;

        public NumArray(int[] nums) {
            prefix = new int[nums.length + 1];

            for (int i = 1; i < nums.length + 1; i++) {
                prefix[i] = prefix[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return prefix[right + 1] - prefix[left];
        }
    }
}

/**
* Your NumArray object will be instantiated and called as such:
* NumArray obj = new NumArray(nums);
* int param_1 = obj.sumRange(left,right);
*/