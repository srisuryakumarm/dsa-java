/**
* ============================================================
* Problem    : 15. 3Sum
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Two Pointers
* Pattern    : Two Pointers
*
* Link       : https://leetcode.com/problems/3sum
* ============================================================
*/

/*
Intuition

We need to find all unique triplets whose sum is equal to zero.

For the brute force approach, we can check every possible combination of three elements and use a Set to avoid duplicate triplets.

For the optimized approach, after sorting the array, we can fix one element and use two pointers to find the other two elements whose sum makes the total equal
to zero.
*/

/*
Approach 1
Brute Force

Consider every possible combination of three elements.

If the sum of the three elements is zero, sort the triplet and store it in a Set to avoid duplicate triplets.

Time: O(n³)
Space: O(n³)
*/

/*
Approach 2
Two Pointers

Sort the array first.

Fix one element and use two pointers to find the remaining two elements.

If the sum is greater than zero, move the right pointer to decrease the sum.
If the sum is less than zero, move the left pointer to increase the sum.

If the sum is zero, add the triplet to the result and move both pointers while skipping duplicate values.

Also skip duplicate values for the fixed element to avoid duplicate triplets.

Time: O(n²)
Space: O(n)
*/

package two_pointers;

public class P15ThreeSum {

    // Brute Force
    public List<List<Integer>> threeSumBrute(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet =
                                new ArrayList<>(List.of(nums[i], nums[j], nums[k]));
                        Collections.sort(triplet);
                        set.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    // Optimised
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSums(nums, i, result);
            }
        }
        return result;
    }

    public void twoSums(int[] nums, int i, List<List<Integer>> result) {
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
        }
    }
}