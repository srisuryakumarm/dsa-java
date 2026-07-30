/**
* ============================================================
* Problem    : 1. Two Sum
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Arrays, Hashing
* Pattern    : Hashing
*
* Link       : https://leetcode.com/problems/two-sum
* ============================================================
*/

/*
Intuition

The goal is to find two numbers whose sum equals the target.

Instead of checking every possible pair, we can keep track of the numbers we
have already processed. For each number, calculate the required complement and
check whether it has already been seen.
*/

/*
Approach 1
Brute Force

Check every possible pair of elements in the array.

If the sum of a pair equals the target, return their indices.

Time: O(n²)
Space: O(1)
*/

/*
Approach 2
Optimal

Use a HashMap to store each number and its index while traversing the array.

For each element, calculate the required complement. If the complement already
exists in the HashMap, return the stored index and the current index.

Otherwise, store the current number and its index in the HashMap and continue.

Time: O(n)
Space: O(n)
*/

package hashing;

public class P01TwoSum{
    public static void main(String[] args){}

    //Brute Force
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }

    //Optimized
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}