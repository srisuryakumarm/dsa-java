/**
* ============================================================
* Problem    : 169. Majority Element
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Hashing
* Pattern    : Hashing
*
* Link       : https://leetcode.com/problems/majority-element
* ============================================================
*/

/*
Intuition

A majority element appears more than ⌊n / 2⌋ times in the array.

The idea is to identify the element that occurs more than half of the array's
length. This can be achieved either by counting the frequency of each element
or by using the Boyer-Moore Voting Algorithm to determine the majority element
in a single pass.
*/

/*
Approach 1
HashMap Frequency Counting

Use a HashMap to count the frequency of each element while traversing the array.

After updating the frequency of an element, check whether its count exceeds
⌊n / 2⌋. If it does, return that element immediately.

Time: O(n)
Space: O(n)
*/

/*
Approach 2
Boyer-Moore Voting

Maintain a candidate and a counter.

If the counter becomes zero, choose the current element as the new candidate.
Increase the counter when the current element matches the candidate; otherwise,
decrease it.

Since the majority element appears more than half of the time, it cannot be
completely cancelled out by the other elements, making it the final candidate.

Time: O(n)
Space: O(1)
*/

package hashing;

public class P169MajorityElement{

    // HashMap Frequency Counting
    public int majorityElementHashSet(int[] nums) {
         Map<Integer, Integer> map = new HashMap<>();
         for (int num : nums) {
             map.put(num, map.getOrDefault(num, 0) + 1);
             if (map.get(num) > nums.length / 2) {
                 return num;
             }
         }
         throw new IllegalArgumentException("No Majority Element Found");
    }

    // Boyer-Moore Voting
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}