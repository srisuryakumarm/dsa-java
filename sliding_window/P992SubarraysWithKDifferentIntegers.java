/**
* ============================================================
* Problem    : 992. Subarrays with K Different Integers
* Platform   : LeetCode
* Difficulty : Hard
*
* Topics     : Arrays, Hash Table, Sliding Window
* Pattern    : Sliding Window
*
* Link       : https://leetcode.com/problems/subarrays-with-k-different-integers
* ============================================================
*/

/*
Intuition

We need to count subarrays that contain exactly `k` distinct integers.

It is easier to count the number of subarrays with at most `k` distinct integers
and subtract the number of subarrays with at most `k - 1` distinct integers.

The difference gives the number of subarrays containing exactly `k` distinct
integers.
*/

/*
Approach 1
At Most K Distinct

Find the number of subarrays with at most `k` distinct integers using a sliding
window.

Maintain a frequency map for the current window. If the window contains more
than `k` distinct integers, move the left pointer forward until the window
becomes valid again.

For every valid window, the number of subarrays ending at `r` is `r - l + 1`.

Finally, calculate:

At most `k` distinct - At most `k - 1` distinct

Time: O(n)
Space: O(n)
*/

package sliding_window;

public class P992SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }
    public int atMostKDistinct(int[] nums, int k) {
        int l = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int r = 0; r < nums.length; r++) {
            map.merge(nums[r], 1, Integer::sum);
            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            count += r - l + 1;
        }
        return count;
    }
}