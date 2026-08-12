/**
* ============================================================
* Problem    : 80. Remove Duplicates from Sorted Array II
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Two Pointers
* Pattern    : Two Pointers
*
* Link       : https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
* ============================================================
*/

/*
Intuition

Since the array is sorted, duplicate elements appear next to each other.

We need to allow each element to appear at most twice. We can keep track of the
position where the next valid element should be placed and compare the current
element with the element two positions before it.

If they are different, the current element can be included in the result.
*/

/*
Approach 1
Brute Force

Use an additional list to store the elements while ensuring that each element
appears at most twice.

Traverse the array and keep track of the current element's frequency. Add the
element to the list only if its frequency is less than or equal to two.

Finally, copy the elements from the list back into the original array.

Time: O(n)
Space: O(n)
*/

/*
Approach 2
Two Pointers

Since the array is sorted, compare the current element with the element two
positions before the current position in the result.

If they are different, place the current element at the left pointer and move
the left pointer forward.

This ensures that each element appears at most twice in the modified array.

Time: O(n)
Space: O(1)
*/

package two_pointers;

public class P80RemoveDuplicatesFromSortedArrayII {

    // Brute Force
    public int removeDuplicatesBrute(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        int currentLen = 1;

        for (int i = 1; i < nums.length; i++) {
            currentLen = nums[i] == nums[i - 1] ? currentLen + 1 : 1;

            if (currentLen <= 2) {
                list.add(nums[i]);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        return list.size();
    }

    // Optimised
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int l = 2, r = 2;

        while (r < nums.length) {
            if (nums[r] != nums[l - 2]) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }

        return l;
    }
}