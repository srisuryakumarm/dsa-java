/**
* ============================================================
* Problem    : 560. Subarray Sum Equals K
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Prefix Sum, Hash Table
* Pattern    : Prefix Sum + Hashing
*
* Link       : https://leetcode.com/problems/subarray-sum-equals-k
* ============================================================
*/

/*
Intuition

We need to count the number of continuous subarrays whose sum is equal to `k`.

For the brute force approach, we can consider every possible starting
position and calculate the sum of each subarray.

For the optimized approach, use prefix sums. If the current running sum is
`runningSum`, then a previous prefix sum of `runningSum - k` means that the
elements between those two prefix sums form a subarray whose sum is `k`.
*/

/*
Approach 1
Brute Force

Consider every possible starting position and extend the subarray one element
at a time while maintaining its running sum.

Whenever the running sum becomes equal to `k`, increment the count.

Time: O(n²)
Space: O(1)
*/

/*
Approach 2
Prefix Sum + HashMap

Maintain a running prefix sum while traversing the array.

Store the frequency of each prefix sum in a HashMap.

For the current running sum, check how many times `runningSum - k` has already
occurred. Each occurrence represents a subarray ending at the current position
whose sum is equal to `k`.

Then store the current running sum in the HashMap.

Initialize the frequency of prefix sum `0` to `1` to account for subarrays that
start from index `0`.

Time: O(n)
Space: O(n)
*/

package prefix_sum_kadanes;

public class P560SubarraySumEqualsK {
    // Brute Force
    // int count = 0;
    // for(int i = 0; i < nums.length; i++){
    //     int sum = 0;
    //     for(int j = i; j < nums.length; j++){
    //         sum += nums[j];
    //         if(sum == k){
    //             count++;
    //         }
    //     }
    // }
    // return count;

    // Prefix Sum + HashMap
    public int subarraySum(int[] nums, int k) {
        int runningSum = 0, count = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        for (int num : nums) {
            runningSum += num;
            count += prefixSumMap.getOrDefault(runningSum - k, 0);
            prefixSumMap.merge(runningSum, 1, Integer::sum);
        }
        return count;
    }
}