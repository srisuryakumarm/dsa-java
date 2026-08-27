/**
* ============================================================
* Problem    : 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Sliding Window, Monotonic Queue
* Pattern    : Sliding Window
*
* Link       : https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
* ============================================================
*/

/*
Intuition

We need to find the longest subarray where the difference between the maximum
and minimum elements is less than or equal to `limit`.

The idea is to maintain a sliding window and keep track of the minimum and
maximum elements in the current window.

Two monotonic deques can be used to efficiently get the minimum and maximum
values of the window.

If the difference between the maximum and minimum becomes greater than
`limit`, shrink the window from the left until it becomes valid again.
*/

/*
Approach
Sliding Window + Monotonic Deques

Use one increasing deque to keep track of the minimum values and one decreasing
deque to keep track of the maximum values.

When adding a new element:
- Remove elements from the back of the minimum deque that are greater than or
  equal to the current value.
- Remove elements from the back of the maximum deque that are less than or
  equal to the current value.
- Add the current index to both deques.

The front of the minimum deque represents the minimum value in the current
window, while the front of the maximum deque represents the maximum value.

If the difference between these two values exceeds `limit`, move the left
pointer forward and remove the index from the front of either deque if it
leaves the window.

Track the maximum valid window length.

Time: O(n)
Space: O(n)
*/

package sliding_window;

public class P1438LongestContinuousSubarray {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();
        int l = 0, b = 0;
        for (int r = 0; r < nums.length; r++) {
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[r]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(r);
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[r]) {
                maxDeque.pollLast();
            }
            maxDeque.offer(r);
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                if (minDeque.peekFirst() == l) {
                    minDeque.pollFirst();
                }
                if (maxDeque.peekFirst() == l) {
                    maxDeque.pollFirst();
                }
                l++;
            }
            b = Math.max(b, r - l + 1);
        }
        return b;
    }
}