/**
* ============================================================
* Problem    : 128. Longest Consecutive Sequence
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Hashing
* Pattern    : Hashing
*
* Link       : https://leetcode.com/problems/longest-consecutive-sequence
* ============================================================
*/

/*
Intuition

A consecutive sequence consists of numbers that appear one after another
without any gaps, regardless of their original order in the array.

The idea is to efficiently identify the longest consecutive sequence by either
sorting the array or using a HashSet for fast lookups.
*/

/*
Approach 1
Brute Force

Clone and sort the array.

Traverse the sorted array while counting consecutive numbers. Ignore duplicate
elements and reset the count whenever the sequence is broken.

Track the maximum sequence length throughout the traversal.

Time: O(n log n)
Space: O(n)
*/

/*
Approach 2
Optimal

Store all the elements in a HashSet.

For every number in the set, keep checking whether the next consecutive number
exists and count the length of the sequence.

Track the maximum sequence length found.

Time: O(n²)
Space: O(n)
*/

/*
Approach 3
Optimal

Store all the elements in a HashSet.

Only start counting a sequence if the current number does not have a previous
consecutive number in the set. This ensures that every sequence is processed
only once.

Expand the sequence by checking consecutive numbers and update the maximum
sequence length.

Time: O(n)
Space: O(n)
*/

package hashing;

public P128LongestConsecutiveSequence {

    // Sorted
    public int longestConsecutive ( int[] nums){
        if (nums.length == 0) {
            return 0;
        }
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int longest = 1, current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (sorted[i] == sorted[i - 1]) {
                continue;
            } else if (sorted[i] == sorted[i - 1] + 1) {
                current++;
            } else {
                current = 1;
            }
            longest = Math.max(longest, current);
        }
        return longest;
    }

    //HashSet - Brute
    public int longestConsecutive ( int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : set) {
            int currentNumber = num, count = 1;
            while (set.contains(currentNumber + 1)) {
                currentNumber++;
                count++;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    // HashSet - Amortized
    public int longestConsecutive ( int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}