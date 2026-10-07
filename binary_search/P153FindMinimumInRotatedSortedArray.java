/**
* ============================================================
* Problem    : 153. Find Minimum in Rotated Sorted Array
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Binary Search
* Pattern    : Binary Search
*
* Link       : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
* ============================================================
*/

/*
Intuition

The array is originally sorted in ascending order and then rotated.

The minimum element is the point where the rotation occurs.

We can use binary search by comparing the middle element with the rightmost
element.

If the middle element is greater than the rightmost element, the minimum must
be to the right of the middle.

Otherwise, the minimum is at the middle or somewhere to its left.
*/

/*
Approach
Binary Search

Maintain a search range using two pointers.

Compare the middle element with the rightmost element.

- If `nums[m] > nums[r]`, the minimum must be in the right half, so move
  `left` to `m + 1`.
- Otherwise, the minimum is at `m` or somewhere in the left half, so move
  `right` to `m`.

Continue until `left == right`.

The remaining position contains the minimum element.

Time: O(log n)
Space: O(1)
*/

package binary_search;

public class P153FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;

            if (nums[r] < nums[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }
}