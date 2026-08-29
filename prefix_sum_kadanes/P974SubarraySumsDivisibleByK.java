/**
* ============================================================
* Problem    : 974. Subarray Sums Divisible by K
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Prefix Sum, Hash Table, Math
* Pattern    : Prefix Sum + Hashing
*
* Link       : https://leetcode.com/problems/subarray-sums-divisible-by-k
* ============================================================
*/

/*
Intuition

We need to count subarrays whose sum is divisible by `k`.

If two prefix sums have the same remainder when divided by `k`, the difference
between those prefix sums is divisible by `k`.

Therefore, while calculating the running sum, we can store the frequency of
each remainder in a HashMap.

Whenever the same remainder is encountered again, it means that one or more
subarrays ending at the current index have a sum divisible by `k`.
*/

/*
Approach
Prefix Sum + HashMap

Maintain a running sum while traversing the array.

For each running sum, calculate its remainder when divided by `k`.

Normalize the remainder so that it is always non-negative, even when the
running sum is negative.

If the same remainder has appeared before, add its frequency to the result.

Then, store the current remainder in the HashMap.

Initialize the frequency of remainder `0` to `1` to account for subarrays whose
sum is directly divisible by `k` from the beginning of the array.

Time: O(n)
Space: O(k)
*/

package prefix_sum_kadanes;

public class P974SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        int runningSum = 0, result = 0;
        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        occurrenceMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            int remainder = ((runningSum % k) + k) % k;
            result += occurrenceMap.getOrDefault(remainder, 0);
            occurrenceMap.merge(remainder, 1, Integer::sum);
        }
        return result;
    }
}