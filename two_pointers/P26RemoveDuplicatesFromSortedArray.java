/**
* ============================================================
* Problem    : 26. Remove Duplicates from Sorted Array
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : String, Two Pointers
* Pattern    : Two Pointers
*
* Link       : https://leetcode.com/problems/remove-duplicates-from-sorted-array
* ============================================================
*/

/*
Intuition

Since the array is already sorted, duplicate elements appear next to each
other.

The idea is to keep one pointer at the last unique element and another pointer
to scan the remaining elements. Whenever a new unique element is found, place
it immediately after the last unique element.
*/

/*
Approach 1
Two Pointers

Maintain one pointer for the position of the last unique element and another
pointer to traverse the array.

Whenever the current element differs from the last unique element, move the
last unique pointer forward and copy the current element to that position.

The number of unique elements represents the required length of the modified
array.

Time: O(n)
Space: O(1)
*/

package two_pointers;

public class P26RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int left = 0, right = 1, k = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
                k++;
            }
            right++;
        }
        return k++;
    }
}