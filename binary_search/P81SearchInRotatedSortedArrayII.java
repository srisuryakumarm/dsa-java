/**
* ============================================================
* Problem    : 81. Search in Rotated Sorted Array II
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Binary Search
* Pattern    : Binary Search
*
* Link       : https://leetcode.com/problems/search-in-rotated-sorted-array-ii
* ============================================================
*/

/*
Intuition

The array is sorted and then rotated, but it can contain duplicate values.

As in the previous rotated-array problem, we try to determine which half of
the current search range is sorted.

However, when `nums[l] == nums[m] == nums[r]`, we cannot determine which half
is sorted because the duplicate values hide the rotation point.

In that case, safely shrink the search range by moving both pointers inward.
Otherwise, use the sorted-half logic to determine where the target can exist.
*/

/*
Approach
Modified Binary Search

Calculate the middle element and first check whether it is the target.

If the left, middle, and right values are all equal, we cannot determine which
half is sorted. Safely shrink the search space by moving both `left` and
`right` inward.

Otherwise:
- If the left half is sorted, check whether the target lies within that range.
- Otherwise, the right half is sorted, so check whether the target lies within
  that range.

Continue until the target is found or the search range becomes empty.

Time: O(log n) average, O(n) worst case
Space: O(1)
*/

package binary_search;

public class P81SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return true;
            }
            if (nums[l] == nums[m] && nums[m] == nums[r]) {
                l++;
                r--;
            } else if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return false;
    }
}