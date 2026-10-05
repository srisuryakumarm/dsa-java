/**
* ============================================================
* Problem    : 33. Search in Rotated Sorted Array
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Binary Search
* Pattern    : Binary Search
*
* Link       : https://leetcode.com/problems/search-in-rotated-sorted-array
* ============================================================
*/

/*
Intuition

The array was originally sorted but then rotated at some pivot.

Even after rotation, at least one half of the current search range is always
sorted.

The idea is to determine which half is sorted, then check whether the target
lies inside that sorted half.

If the target belongs to the sorted half, search there. Otherwise, discard that
half and search the other half.
*/

/*
Approach
Modified Binary Search

Calculate the middle element and first check whether it is the target.

Then determine which half of the current search range is sorted:

- If `nums[l] <= nums[m]`, the left half is sorted.
- Otherwise, the right half is sorted.

If the left half is sorted, check whether the target lies between `nums[l]`
and `nums[m]`.

If it does, move `right` to `m - 1`; otherwise, search the right half.

If the right half is sorted, check whether the target lies between `nums[m]`
and `nums[r]`.

If it does, move `left` to `m + 1`; otherwise, search the left half.

Time: O(log n)
Space: O(1)
*/

package binary_search;

public class P33SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[l] <= nums[m]) {
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
        return -1;
    }
}