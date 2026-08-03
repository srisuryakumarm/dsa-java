/**
* ============================================================
* Problem    : 88. Merge Sorted Array
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : String, Two Pointers
* Pattern    : Two Pointers
*
* Link       : https://leetcode.com/problems/merge-sorted-array
* ============================================================
*/

/*
Intuition

Both arrays are already sorted.

The idea is to merge them while preserving the sorted order. This can be done
either by using an extra array or by filling the elements into `nums1` from the
end, avoiding the need for additional space.
*/

/*
Approach 1
Brute Force - O(m + n) Space

Create a new array to store the merged result.

Compare the elements of both arrays and insert the smaller element into the
new array. After one array is exhausted, copy the remaining elements from the
other array.

Finally, copy the merged array back into `nums1`.

Time: O(m + n)
Space: O(m + n)
*/

/*
Approach 2
Two Pointers

Initialize three pointers:
- One at the last valid element of `nums1`.
- One at the last element of `nums2`.
- One at the last position of `nums1`.

Compare the elements from the end of both arrays and place the larger element
at the current position in `nums1`.

Continue until all elements from `nums2` have been placed into `nums1`.

Time: O(m + n)
Space: O(1)
*/

package two_pointers;

public class P88MergeSortedArray {

    // Brute Force - O(m + n) Space
    public void merge(int[] nums1, int m, int[] nums2, int n) {
         int[] merged = new int[m + n];
         int i = 0, j = 0, k = 0;
         while (i < m && j < n) {
             merged[k++] = (nums1[i] <= nums2[j]) ? nums1[i++] : nums2[j++];
         }
         while (i < m) {
             merged[k++] = nums1[i++];
         }
         while (j < n) {
             merged[k++] = nums2[j++];
         }
         System.arraycopy(merged, 0, nums1, 0, m + n);
    }

    // Two Pointers - O(1) Space
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}