/**
* ============================================================
* Problem    : 1695. Maximum Erasure Value
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Hash Table, Sliding Window
* Pattern    : Sliding Window
*
* Link       : https://leetcode.com/problems/maximum-erasure-value
* ============================================================
*/

/*
Intuition

We need to find the subarray with unique elements that has the maximum sum.

The idea is to maintain a sliding window containing only unique elements and
keep track of the sum of the elements inside the window.

When a duplicate element is found, move the left pointer forward and remove
elements from the Set and from the current sum until the duplicate element is
removed.

At every step, update the maximum sum found.
*/

/*
Approach
Sliding Window + HashSet

Use a HashSet to store the elements currently present in the sliding window.

Move the right pointer through the array and add each element to the Set and
the running sum.

If the current element already exists in the Set, move the left pointer
forward, removing elements from the Set and subtracting them from the running
sum until the duplicate element is removed.

After the window becomes valid, update the maximum sum.

Time: O(n)
Space: O(n)
*/

package sliding_window;

public class P1695MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int l = 0, b = 0, sum = 0;
        for (int r = 0; r < nums.length; r++) {
            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
            set.add(nums[r]);
            sum += nums[r];
            b = Math.max(b, sum);
        }
        return b;
    }
}