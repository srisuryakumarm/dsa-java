/**
* ============================================================
* Problem    : 162. Find Peak Element
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Binary Search
* Pattern    : Binary Search
*
* Link       : https://leetcode.com/problems/find-peak-element
* ============================================================
*/

/*
Intuition

We need to find any element that is greater than its neighboring elements.

Instead of checking every element, we can use the fact that the array gives us
a direction for where a peak must exist.

If `nums[m] < nums[m + 1]`, we are on an increasing slope, so there must be a
peak somewhere to the right.

Otherwise, we are on a decreasing slope, so a peak exists at `m` or somewhere
to the left.

Therefore, we can discard half of the search space at every step.
*/

/*
Approach
Binary Search

Maintain a search range using two pointers.

Compare the middle element with the element immediately to its right.

- If `nums[m] < nums[m + 1]`, move `left` to `m + 1` because a peak must exist
  on the right side.
- Otherwise, move `right` to `m` because `m` itself could be a peak.

Continue until `left == right`.

The remaining index is a peak element.

Time: O(log n)
Space: O(1)
*/

package binary_search;

public class P162FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}