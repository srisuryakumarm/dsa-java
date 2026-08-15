/**
* ============================================================
* Problem    : 18. 4Sum
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Two Pointers, Sorting, Hash Table
* Pattern    : Two Pointers
*
* Link       : https://leetcode.com/problems/4sum
* ============================================================
*/

/*
Intuition

We need to find all unique quadruplets whose sum is equal to the target.

For the brute force approach, we can check every possible combination of four
elements and use a Set to avoid duplicate quadruplets.

For the optimized approach, after sorting the array, we can fix two elements
and use two pointers to find the remaining two elements whose sum makes the
total equal to the target.
*/

/*
Approach 1
Brute Force

Consider every possible combination of four elements.

If the sum of the four elements is equal to the target, store the quadruplet
in a Set to avoid duplicates.

Return all the unique quadruplets after checking all possible combinations.

Time: O(n⁴)
Space: O(n)
*/

/*
Approach 2
Two Pointers

Sort the array first.

Fix the first two elements using two loops and use two pointers to find the
remaining two elements.

If the sum is greater than the target, move the right pointer to decrease the
sum.

If the sum is less than the target, move the left pointer to increase the sum.

If the sum equals the target, add the quadruplet to the result and skip duplicate
values for both pointers.

Also skip duplicate values for the first and second fixed elements to avoid
duplicate quadruplets.

Time: O(n³)
Space: O(n)
*/

package two_pointers;

public class P18FourSum {
    // Brute Force
    public List<List<Integer>> fourSumBrute(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            result.add(
                                    Arrays.asList(nums[i], nums[j], nums[k], nums[l])
                            );
                        }
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    // Optimised
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        result.add(
                                Arrays.asList(nums[i], nums[j], nums[l], nums[r])
                        );
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return result;
    }
}