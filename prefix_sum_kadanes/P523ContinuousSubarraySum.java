/**
* ============================================================
* Problem    : 523. Continuous Subarray Sum
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Prefix Sum, Hash Table
* Pattern    : Prefix Sum + Hashing
*
* Link       : https://leetcode.com/problems/continuous-subarray-sum
* ============================================================
*/

/*
Intuition

We need to determine whether there is a continuous subarray of at least two
elements whose sum is a multiple of `k`.

For the brute force approach, we can calculate the sum of every possible
subarray and check whether the sum is divisible by `k`.

For the optimized approach, use prefix sums and store the first index where
each remainder occurs.

If the same remainder occurs at two different indices, the sum of the elements
between those indices is divisible by `k`.

The distance between the two indices must be at least 2 because the subarray
must contain at least two elements.
*/

/*
Approach 1
Brute Force

Consider every possible starting position and calculate the running sum of the
subarray.

Whenever the subarray contains at least two elements, check whether its sum is
divisible by `k`.

If a valid subarray is found, return true. Otherwise, return false after
checking all possible subarrays.

Time: O(n²)
Space: O(1)
*/

/*
Approach 2
Prefix Sum + HashMap

Maintain a running prefix sum and calculate its remainder when divided by `k`.

Store the first index where each remainder occurs in a HashMap.

If the same remainder appears again, the difference between the two prefix sums
is divisible by `k`.

If the distance between the two indices is at least 2, the elements between
them form a valid subarray.

Store only the first occurrence of each remainder because an earlier index
produces the longest possible subarray.

Time: O(n)
Space: O(min(n, k))
*/

package prefix_sum_kadanes;

public class P523ContinuousSubarraySum {
    // Brute Force
    // int runningSum = 0;
    // for (int i = 0; i < nums.length; i++) {
    //     runningSum = nums[i];
    //     for (int j = i + 1; j < nums.length; j++) {
    //         runningSum += nums[j];
    //         if (runningSum % k == 0) {
    //             return true;
    //         }
    //     }
    // }
    // return false;

    // Prefix Sum + HashMap
    public boolean checkSubarraySum(int[] nums, int k) {
        int runningSum = 0;
        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        occurrenceMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            int remainder = runningSum % k;
            if (occurrenceMap.containsKey(remainder)) {
                if (i - occurrenceMap.get(remainder) >= 2) {
                    return true;
                }
            } else {
                occurrenceMap.put(remainder, i);
            }
        }
        return false;
    }
}