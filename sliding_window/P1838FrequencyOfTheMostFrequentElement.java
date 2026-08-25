/**
* ============================================================
* Problem    : 1838. Frequency of the Most Frequent Element
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Sorting, Sliding Window
* Pattern    : Sliding Window
*
* Link       : https://leetcode.com/problems/frequency-of-the-most-frequent-element
* ============================================================
*/

/*
Intuition

After sorting the array, if we want to make all elements in a window equal to
the largest element in that window, we only need to increase the smaller
elements.

For a window ending at `r`, the minimum number of operations required to make
every element equal to `nums[r]` is:

`nums[r]* window length - window sum`

If this value is greater than `k`, shrink the window from the left until the
number of required operations becomes valid again.

The largest valid window represents the maximum possible frequency.
*/

/*
Approach
Sorting + Sliding Window

Sort the array so that the largest element of the current window is always
`nums[r]`.

Maintain the sum of the elements inside the current window.

The number of operations required to make every element in the window equal to
`nums[r]` is:

`nums[r]* (r - l + 1) - sum`

If the required operations exceed `k`, remove elements from the left until the
window becomes valid.

Track the maximum valid window length.

Time: O(n log n)
Space: O(1)
*/

package sliding_window;

public class P1838FrequencyOfTheMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, b = 1;
        long sum = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while ((long) nums[r]* (r - l + 1) - sum > k) {
                sum -= nums[l];
                l++;
            }
            b = Math.max(b, r - l + 1);
        }
        return b;
    }
}