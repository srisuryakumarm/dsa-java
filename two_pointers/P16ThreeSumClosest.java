/**
* ============================================================
* Problem    : 16. 3Sum Closest
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Two Pointers, Sorting
* Pattern    : Two Pointers
*
* Link       : https://leetcode.com/problems/3sum-closest
* ============================================================
*/

/*
Intuition

We need to find three numbers whose sum is closest to the target.

For the brute force approach, we can check every possible combination of three
elements and keep track of the sum that is closest to the target.

For the optimized approach, after sorting the array, we can fix one element and
use two pointers to find a sum that is closest to the target.
*/

/*
Approach 1
Brute Force

Consider every possible combination of three elements.

For each combination, calculate the sum and compare its difference from the
target with the current closest sum.

Update the closest sum whenever a closer sum is found.

Time: O(n³)
Space: O(1)
*/

/*
Approach 2
Two Pointers

Sort the array first.

Fix one element and use two pointers to find the remaining two elements.

If the current sum is greater than the target, move the right pointer to
decrease the sum.

If the current sum is smaller than the target, move the left pointer to
increase the sum.

After calculating each sum, update the closest sum if the current sum is
closer to the target.

If the sum equals the target, return it immediately.

Time: O(n²)
Space: O(1)
*/

package two_pointers;

public class P16ThreeSumClosest {

    // Brute Force
    public int threeSumClosestBrute(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (Math.abs(sum - target) < Math.abs(closest - target)) {
                        closest = sum;
                    }
                }
            }
        }
        return closest;
    }

    // Optimised
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return closest;
    }
}