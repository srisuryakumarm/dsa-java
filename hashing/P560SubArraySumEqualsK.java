/**
* ============================================================
* Problem    : 560. Subarray Sum Equals K
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Array, Prefix Sum, Hash Table
* Pattern    : Hashing
*
* Link       : https://leetcode.com/problems/subarray-sum-equals-k/
* ============================================================
*/

/*
Intuition

The sum of a subarray can be determined using prefix sums.

If the current running sum is `runningSum` and a previous running sum of
`runningSum - k` exists, then the elements between those two positions form a
subarray whose sum equals `k`.

The idea is to store the frequency of every running sum in a HashMap so that
the number of valid subarrays can be determined while traversing the array.
*/

/*
Approach 1
Brute Force

Consider every possible starting index and extend the subarray one element at
a time while maintaining its running sum.

Whenever the running sum equals `k`, increment the count.

Time: O(n²)
Space: O(1)
*/

/*
Approach 2
Prefix Sum + HashMap

Maintain a running sum while traversing the array.

For each running sum, check whether `runningSum - k` has been seen before.
Its frequency represents the number of previous prefix sums that form a
subarray with sum `k`.

Store the frequency of every running sum in a HashMap and update the count
accordingly.

Time: O(n)
Space: O(n)
*/

package hashing;

public class P560SubArraySumEqualsK {
    // Brute Force
    public int subarraySumBrute(int[] nums, int k) {
         int count = 0;
         for (int i = 0; i < nums.length; i++) {
             int sum = 0;
             for (int j = i; j < nums.length; j++) {
                 sum += nums[j];
                 if (sum == k) {
                     count++;
                 }
             }
         }
         return count;
    }

    // Prefix Sum + HashMap
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Adding Default Frequency for Running Sum 0

        int runningSum = 0;
        int count = 0;
        for (int num : nums) {
            runningSum += num;
            count += map.getOrDefault(runningSum - k, 0);
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }
        return count;
    }
}