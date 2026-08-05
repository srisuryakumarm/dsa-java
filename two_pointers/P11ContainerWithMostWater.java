/**
* ============================================================
* Problem    : 11. Container With Most Water
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Two Pointers
* Pattern    : Two Pointers
*
* Link       : https://leetcode.com/problems/container-with-most-water
* ============================================================
*/

/*
Intuition

The amount of water is determined by the shorter line and the distance between
the two lines.

Starting with the widest container, moving the taller line cannot increase the
area because the width decreases while the limiting height remains unchanged.

Therefore, always move the pointer pointing to the shorter line in the hope of
finding a taller line that may produce a larger area.
*/

/*
Approach 1
Brute Force

Consider every possible pair of lines.

For each pair, calculate the area formed by the two lines and keep track of
the maximum area.

Time: O(n²)
Space: O(1)
*/

/*
Approach 2
Two Pointers

Initialize one pointer at the beginning of the array and another at the end.

Calculate the area formed by the two pointers and update the maximum area.

Move the pointer pointing to the shorter line, since moving the taller line
cannot produce a larger area while the width decreases.

Continue until the two pointers meet.

Time: O(n)
Space: O(1)
*/

package two_pointers;

public class P11ContainerWithMostWater {

    // Brute Force
    public int maxAreaBrute(int[] height) {
        int left = 0, right = height.length - 1, area = 0;
        while (left < right) {
            area = Math.max(area, Math.min(height[left], height[right])* (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }

    //Optimised
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, area = 0;
        while (left < right) {
            area = Math.max(area, Math.min(height[left], height[right])* (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}