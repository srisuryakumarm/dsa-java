/**
* ============================================================
* Problem    : 34. Find First and Last Position of Element in Sorted Array
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Binary Search
* Pattern    : Binary Search
*
* Link       : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
* ============================================================
*/

/*
Intuition

Since the array is sorted, we can use binary search to find the target.

However, finding any occurrence is not enough because we need the first and last
positions of the target.

The idea is to perform binary search twice:
- Once to find the first occurrence.
- Once to find the last occurrence.

When the target is found, continue searching toward the required side instead
of stopping immediately.
*/

/*
Approach
Binary Search

Use a helper method that performs binary search and determines whether we are
searching for the first or last occurrence.

When the middle element equals the target:
- If searching for the first occurrence, store the index and continue searching
  in the left half.
- If searching for the last occurrence, store the index and continue searching
  in the right half.

If the target is not found during the first search, return `[-1, -1]`.

Time: O(log n)
Space: O(1)
*/

package binary_search;

public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int first = search(nums, target, true);
        if (first == -1) {
            return new int[] { -1, -1 };
        }
        int second = search(nums, target, false);
        return new int[] { first, second };
    }

    public int search(int[] nums, int target, boolean isFirst) {
        int l = 0, r = nums.length - 1, result = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                result = m;

                if (isFirst) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return result;
    }
}