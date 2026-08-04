/**
* ============================================================
* Problem    : 283. Move Zeroes
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Arrays, Two Pointers
* Pattern    : Two Pointers
*
* Link       : https://leetcode.com/problems/move-zeroes
* ============================================================
*/

/*
Intuition

All non-zero elements must retain their relative order, while all zeroes are
moved to the end of the array.

The idea is to keep track of the position where the next non-zero element
should be placed while scanning the array.
*/

/*
Approach 1
Two Pointers

Maintain two pointers:
- One pointer tracks the position where the next non-zero element should be
  placed.
- The other pointer traverses the array.

Whenever a non-zero element is found, swap it with the element at the first
pointer and move the first pointer forward.

After processing all the elements, all non-zero values remain at the beginning
of the array in their original order, and all zeroes are moved to the end.

Time: O(n)
Space: O(1)
*/

package two_pointers;

public class P283MoveZeros {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
}