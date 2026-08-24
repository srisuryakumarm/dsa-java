/**
* ============================================================
* Problem    : 904. Fruit Into Baskets
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Hash Table, Sliding Window
* Pattern    : Sliding Window
*
* Link       : https://leetcode.com/problems/fruit-into-baskets
* ============================================================
*/

/*
Intuition

We need to find the longest contiguous subarray that contains at most two
distinct types of fruits.

The idea is to maintain a sliding window and keep track of the frequency of
each fruit type inside the window.

If the window contains more than two distinct fruit types, move the left
pointer forward and decrease the frequency of the fruit leaving the window
until the window becomes valid again.
*/

/*
Approach
Sliding Window + HashMap

Use a HashMap to store the frequency of each fruit type in the current window.

Expand the window by moving the right pointer and increment the frequency of
the current fruit.

If the window contains more than two distinct fruit types, shrink the window
from the left by decreasing the frequency of each fruit that leaves the window.

Remove a fruit type from the HashMap when its frequency becomes zero.

After the window becomes valid, update the maximum window length.

Time: O(n)
Space: O(n)
*/

package sliding_window;

public class P904FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        int l = 0, b = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int r = 0; r < fruits.length; r++) {
            map.merge(fruits[r], 1, Integer::sum);
            while (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            b = Math.max(b, r - l + 1);
        }
        return b;
    }
}