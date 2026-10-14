/**
* ============================================================
* Problem    : 74. Search a 2D Matrix
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Binary Search, Matrix
* Pattern    : Binary Search
*
* Link       : https://leetcode.com/problems/search-a-2d-matrix
* ============================================================
*/

/*
Intuition

The matrix is sorted so that each row is sorted in ascending order, and the
first element of each row is greater than the last element of the previous row.

Therefore, the matrix can be treated as a sorted one-dimensional array.

The idea is to perform binary search on this virtual array and convert each
middle index into its corresponding row and column indices.
*/

/*
Approach
Binary Search

Treat the matrix as a one-dimensional sorted array of size m* n.

Initialize the search range from index 0 to m* n - 1.

For each middle index, convert it into the corresponding matrix position:
- Row index: mid / n
- Column index: mid % n

Compare the element at that position with the target.

If the element equals the target, return true.
If the element is smaller than the target, search the right half.
Otherwise, search the left half.

If the target is not found, return false.

Time: O(log(m* n))
Space: O(1)
*/

package binary_search;

public class P74SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m* n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid / n][mid % n] == target) {
                return true;
            } else if (matrix[mid / n][mid % n] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}