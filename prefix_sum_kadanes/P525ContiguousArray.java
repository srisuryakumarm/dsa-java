/**
* ============================================================
* Problem    : 525. Contiguous Array
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Prefix Sum, Hash Table
* Pattern    : Prefix Sum + Hashing
*
* Link       : https://leetcode.com/problems/contiguous-array
* ============================================================
*/

/*
Intuition

We need to find the longest contiguous subarray containing the same number of
0s and 1s.

Treat every 0 as `-1` and every 1 as `+1`. Then, a subarray contains an equal
number of 0s and 1s when its sum is zero.

If the same running sum occurs at two different indices, the elements between
those indices have a sum of zero and therefore contain an equal number of 0s
and 1s.
*/

/*
Approach 1
Brute Force

Consider every possible starting position and count the number of 0s and 1s
while extending the subarray.

Whenever the number of 0s and 1s becomes equal, update the maximum subarray
length.

Time: O(n²)
Space: O(1)
*/

/*
Approach 2
Prefix Sum + HashMap

Treat every 0 as `-1` and every 1 as `+1`.

Maintain a running sum while traversing the array and store the first index where
each running sum occurs in a HashMap.

If the same running sum occurs again, the elements between the two indices have
a sum of zero, which means they contain an equal number of 0s and 1s.

Store only the first occurrence of each running sum so that a repeated sum gives
the longest possible subarray.

Time: O(n)
Space: O(n)
*/

package prefix_sum_kadanes;

public class P525ContiguousArray {
    // Brute Force
    // int b = 0;
    // for (int i = 0; i < nums.length; i++) {
    //     int zeros = 0, ones = 0;
    //     for (int j = i; j < nums.length; j++) {
    //         if (nums[j] == 0) {
    //             zeros++;
    //         } else {
    //             ones++;
    //         }
    //         if (zeros == ones) {
    //             b = Math.max(b, j - i + 1);
    //         }
    //     }
    // }
    // return b;

    // Optimised - Prefix Sum + HashMap
    public int findMaxLength(int[] nums) {
        int runningSum = 0, b = 0;
        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        occurrenceMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i] == 0 ? -1 : 1;
            if (occurrenceMap.containsKey(runningSum)) {
                b = Math.max(b, i - occurrenceMap.get(runningSum));
            } else {
                occurrenceMap.put(runningSum, i);
            }
        }
        return b;
    }
}