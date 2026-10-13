/**
* ============================================================
* Problem    : 154. Find Minimum in Rotated Sorted Array II
* Platform   : LeetCode
* Difficulty : Hard
*
* Topics     : Arrays, Binary Search
* Pattern    : Binary Search
*
* Link       : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii
* ============================================================
*/

/*
Intuition

The array was originally sorted in ascending order and then rotated, but it
can contain duplicate elements.

The minimum element is located at the rotation point.

We can use binary search by comparing the middle element with the rightmost
element.

If the rightmost element is smaller than the middle element, the minimum must
be to the right of the middle.

Otherwise, the minimum is at the middle or somewhere to its left.

When the left, middle, and right elements are equal, we cannot determine which
half contains the minimum, so we safely shrink the search range from both ends.
*/

/*
Approach
Modified Binary Search

Maintain a search range using two pointers.

Calculate the middle index and compare the elements at the left, middle, and
right positions.

If all three elements are equal, move both pointers inward because the
duplicate boundary elements can be discarded without losing the minimum value.

Otherwise, if the rightmost element is smaller than the middle element, move
the left pointer to `mid + 1`.

If neither condition holds, the minimum is at the middle or somewhere to its
left, so move the right pointer to `mid`.

Continue until the search range contains a single element.

Time: O(log n) average, O(n) worst case
Space: O(1)
*/

package binary_search;

public class P154FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[l] == nums[m] && nums[m] == nums[r]) {
                l++;
                r--;
            } else if (nums[r] < nums[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }
}