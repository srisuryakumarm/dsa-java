/**
* ============================================================
* Problem    : 977. Squares Of A Sorted Array
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Array, Two Pointers, Sorting
* Pattern    : Two Pointers
*
* Link       : https://leetcode.com/problems/squares-of-a-sorted-array
* ============================================================
*/

/*
Intuition

Although the array is sorted, squaring negative numbers changes their order.

The largest square always comes from either the leftmost negative number or
the rightmost positive number.

The idea is to compare the squares at both ends and place the larger square
at the end of the result array.
*/

/*
Approach 1
Brute Force

Square every element in the array.

Since squaring may change the order of the elements, sort the array again and
return the result.

Time: O(n log n)
Space: O(1)
*/

/*
Approach 2
Two Pointers

Initialize one pointer at the beginning of the array and another at the end.

Compare the squares of both elements and place the larger square at the end
of the result array.

Move the corresponding pointer and continue until all elements have been
processed.

Time: O(n)
Space: O(n)
*/

package two_pointers;

public class P977SquaresOfASortedArray {
    // Brute Force - O(n log n)
    public int[] sortedSquaresBrute(int[] nums) {
         for (int i = 0; i < nums.length; i++) {
             nums[i] = nums[i] * nums[i];
         }
         Arrays.sort(nums);
         return nums;
    }

    // Optimised - Two Pointers Approach
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int resultIndex = nums.length - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare >= rightSquare) {
                result[resultIndex] = leftSquare;
                left++;
            } else {
                result[resultIndex] = rightSquare;
                right--;
            }
            resultIndex--;
        }
        return result;
    }
}