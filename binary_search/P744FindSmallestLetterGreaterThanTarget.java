/**
* ============================================================
* Problem    : 744. Find Smallest Letter Greater Than Target
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Arrays, Binary Search
* Pattern    : Binary Search
*
* Link       : https://leetcode.com/problems/find-smallest-letter-greater-than-target
* ============================================================
*/

/*
Intuition

The letters are sorted, so we can use binary search to find the smallest letter
that is strictly greater than the target.

If the middle letter is less than or equal to the target, search the right half.
Otherwise, the middle letter could be the answer, so continue searching the
left half.

If no letter is greater than the target, wrap around and return the first
letter in the array.
*/

/*
Approach
Binary Search

Maintain a search range using two pointers.

Calculate the middle index and compare the middle letter with the target.

- If `letters[m] <= target`, move `left` to `m + 1`.
- Otherwise, move `right` to `m - 1` because the middle letter could be the
  smallest letter greater than the target.

When the loop ends, `left` represents the index of the smallest letter greater
than the target.

Use modulo to wrap around to the beginning of the array if `left` reaches the
array length.

Time: O(log n)
Space: O(1)
*/

package binary_search;

public class P744FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return letters[l % letters.length];
    }
}