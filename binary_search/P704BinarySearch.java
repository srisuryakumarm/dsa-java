/**
* ============================================================
* Problem    : 704. Binary Search
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Arrays, Binary Search
* Pattern    : Binary Search
*
* Link       : https://leetcode.com/problems/binary-search
* ============================================================
*/

/*
Intuition

Since the array is sorted, we can repeatedly compare the target with the
middle element and eliminate half of the remaining search space.

If the middle element is smaller than the target, search in the right half.

If the middle element is greater than the target, search in the left half.

If the middle element equals the target, return its index.
*/

/*
Approach
Binary Search

Maintain two pointers representing the current search range.

Calculate the middle index and compare the middle element with the target.

- If the middle element equals the target, return the middle index.
- If the middle element is smaller than the target, move the left pointer to
  `mid + 1`.
- Otherwise, move the right pointer to `mid - 1`.

Continue until the search range becomes empty.

Time: O(log n)
Space: O(1)
*/

package binary_search;

public class P704BinarySearch {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}