/**
* ============================================================
* Problem    : 35. Search Insert Position
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Arrays, Binary Search
* Pattern    : Binary Search
*
* Link       : https://leetcode.com/problems/search-insert-position
* ============================================================
*/

/*
Intuition

Since the array is sorted, we can use binary search to determine where the
target exists or where it should be inserted.

If the middle element is smaller than the target, search in the right half.

If the middle element is greater than the target, search in the left half.

If the target is found, return its index.

If the target is not found, the left pointer eventually reaches the position
where the target should be inserted.
*/

/*
Approach
Binary Search

Maintain a search range using two pointers.

For each middle element:
- If it equals the target, return its index.
- If it is smaller than the target, move `left` to `mid + 1`.
- Otherwise, move `right` to `mid - 1`.

When the loop ends, `left` represents the first position where the target
could be inserted while maintaining sorted order.

Time: O(log n)
Space: O(1)
*/

package binary_search;

public class P35SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
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
        return l;
    }
}