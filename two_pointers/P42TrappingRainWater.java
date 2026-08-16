/**
* ============================================================
* Problem    : 42. Trapping Rain Water
* Platform   : LeetCode
* Difficulty : Hard
*
* Topics     : Arrays, Two Pointers, Dynamic Programming, Stack, Monotonic Stack
* Pattern    : Two Pointers
*
* Link       : https://leetcode.com/problems/trapping-rain-water
* ============================================================
*/

/*
Intuition

The amount of water that can be trapped at an index depends on the shorter of
the maximum heights on its left and right sides.

The idea is to use two pointers, one at each end of the array, and maintain the
maximum height seen from both sides.

When the left height is smaller than the right height, the trapped water at the
left side can be determined using the left maximum. Otherwise, it can be
determined using the right maximum.

Move the pointer on the side with the smaller height toward the center.
*/

/*
Approach 1
Brute Force

For each position, find the maximum height to its left and the maximum height
to its right.

The amount of water that can be trapped at that position is the difference
between the smaller of these two maximum heights and the current height.

Add this amount to the total trapped water.

Time: O(n²)
Space: O(1)
*/

/*
Approach 2
Two Pointers

Initialize one pointer at the beginning of the array and another at the end.

Maintain the maximum height encountered from the left and from the right.

If the left height is smaller than the right height, update the left maximum
and calculate the water trapped at the left pointer.

Otherwise, update the right maximum and calculate the water trapped at the
right pointer.

Continue until the two pointers meet.

Time: O(n)
Space: O(1)
*/

package two_pointers;

public class P42TrappingRainWater {
    // Brute Force
    // int n = height.length - 1, water = 0;
    // for (int i = 0; i < n; i++) {
    //     int leftMax = 0, rightMax = 0;
    //     for (int j = 0; j <= i; j++) {
    //         leftMax = Math.max(leftMax, height[j]);
    //     }
    //     for (int j = i; j < n; j++) {
    //         rightMax = Math.max(rightMax, height[j]);
    //     }
    //     water += Math.min(leftMax, rightMax) - height[i];
    // }
    // return water;

    // Optimised - Two Pointers
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lmax = 0, rmax = 0, water = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                lmax = Math.max(lmax, height[l]);
                water += lmax - height[l];
                l++;
            } else {
                rmax = Math.max(rmax, height[r]);
                water += rmax - height[r];
                r--;
            }
        }
        return water;
    }
}