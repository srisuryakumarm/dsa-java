/**
* ============================================================
* Problem    : 875. Koko Eating Bananas
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Binary Search
* Pattern    : Binary Search on Answer
*
* Link       : https://leetcode.com/problems/koko-eating-bananas
* ============================================================
*/

/*
Intuition

We need to find the minimum eating speed at which Koko can finish all the
bananas within `h` hours.

If Koko can finish all the piles at a particular speed, she can also finish
them at any higher speed.

This monotonic property allows us to use binary search over the possible
eating speeds, from 1 to the size of the largest pile.

For each candidate speed, calculate the total hours required to finish all
the piles. If the required hours are within `h`, try a smaller speed.
Otherwise, increase the speed.
*/

/*
Approach
Binary Search on Answer

Set the minimum possible speed to 1 and the maximum possible speed to the
largest pile.

For each middle speed, calculate the total hours required to finish all the
piles.

If Koko can finish within `h` hours, store the middle speed as a possible
answer and continue searching the lower half.

Otherwise, search the upper half for a faster speed.

Continue until the left and right pointers converge.

Time: O(n log M), where M is the maximum pile size
Space: O(1)
*/

package binary_search;

public class P875KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        while (l < r) {
            int m = l + (r - l) / 2;
            if (canFinish(m, piles, h)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    public boolean canFinish(int m, int[] piles, int h) {
        long hoursNeeded = 0;
        for (int pile : piles) {
            hoursNeeded += pile / m;
            if (pile % m != 0) {
                hoursNeeded++;
            }
        }
        return hoursNeeded <= h;
    }
}