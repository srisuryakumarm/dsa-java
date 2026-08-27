/**
* ============================================================
* Problem    : 239. Sliding Window Maximum
* Platform   : LeetCode
* Difficulty : Hard
*
* Topics     : Arrays, Queue, Sliding Window, Monotonic Queue
* Pattern    : Sliding Window
*
* Link       : https://leetcode.com/problems/sliding-window-maximum
* ============================================================
*/

/*
Intuition

We need to find the maximum element in every window of size `k`.

The idea is to maintain a deque containing the indices of useful elements in
the current window.

The deque keeps the elements in decreasing order of their values, so the
element at the front is always the maximum element of the current window.

When a new element is added, remove all smaller elements from the back because
they can no longer become the maximum while the new element is inside the
window.
*/

/*
Approach
Sliding Window + Monotonic Deque

Use a deque to store indices of elements in decreasing order of their values.

For every element, first remove all indices from the back whose values are
less than or equal to the current element.

Add the current index to the back of the deque.

If the index at the front is outside the current window, remove it.

Once the first complete window is formed, the value at the front of the deque
is the maximum value for that window.

Time: O(n)
Space: O(k)
*/

package sliding_window;

public class P239SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for (int r = 0; r < nums.length; r++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[r]) {
                deque.pollLast();
            }
            deque.offerLast(r);
            if (deque.peekFirst() <= r - k) {
                deque.pollFirst();
            }
            if (r >= k - 1) {
                result[r - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}