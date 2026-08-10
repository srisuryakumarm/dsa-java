/**
* ============================================================
* Problem    : 27. Remove Element
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Arrays, Two Pointers
* Pattern    : Two Pointers
*
* Link       : https://leetcode.com/problems/remove-element
* ============================================================
*/

/*
Intuition

We need to remove all occurrences of the given value from the array while
keeping all other elements.

We can use two pointers, where one pointer scans the array and the other keeps
track of the position where the next valid element should be placed.
*/

/*
Approach
Two Pointers

Use one pointer to iterate through the array and another pointer to keep track
of the position where the next element that is not equal to val should be
placed.

Whenever the current element is not equal to val, place it at the left pointer
and move the left pointer forward.

After processing the entire array, the left pointer represents the number of
elements that are not equal to val.

Time: O(n)
Space: O(1)
*/

package two_pointers;

public class P27RemoveElement {
    public int removeElement(int[] nums, int val) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}