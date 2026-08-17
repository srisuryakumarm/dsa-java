/**
* ============================================================
* Problem    : 75. Sort Colors
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Two Pointers, Sorting
* Pattern    : Two Pointers
*
* Link       : https://leetcode.com/problems/sort-colors
* ============================================================
*/

/*
Intuition

The array contains only three values: 0, 1, and 2.

The idea is to place all 0s at the beginning, all 1s in the middle, and all 2s
at the end.

For the optimized approach, we can maintain three pointers to keep track of
the positions of 0s, the current element, and 2s.
*/

/*
Approach 1
Counting

Count the number of 0s, 1s, and 2s using a frequency array.

Then overwrite the original array using these counts so that all 0s come first,
followed by 1s and then 2s.

Time: O(n)
Space: O(1)
*/

/*
Approach 2
Three Pointers

Maintain three pointers:
- `l` points to the position where the next 0 should be placed.
- `m` scans the array.
- `r` points to the position where the next 2 should be placed.

If the current element is 0, swap it with the element at `l` and move both `l`
and `m` forward.

If the current element is 1, move `m` forward.

If the current element is 2, swap it with the element at `r` and move `r`
backward. The `m` pointer is not moved because the element swapped from the
right has not been processed yet.

Time: O(n)
Space: O(1)
*/

package two_pointers;

public class P75SortColors {
    // Counting
    // int[] count = new int[3];
    // for(int i = 0; i < nums.length; i++){
    //     count[nums]++;
    // }
    // int index = 0;
    // for(int color = 0; color < 3; color++){
    //     for(int i = 0;i < color[count]; i++){
    //         nums[index++] = color;
    //     }
    // }

    // Optimised - Three Pointers
    public void sortColors(int[] nums) {
        int l = 0, m = 0, r = nums.length - 1;
        while (m <= r) {
            if (nums[m] == 0) {
                swap(nums, l, m);
                l++;
                m++;
            } else if (nums[m] == 1) {
                m++;
            } else {
                swap(nums, m, r);
                r--;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}