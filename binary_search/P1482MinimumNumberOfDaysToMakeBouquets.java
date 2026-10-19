/**
* ============================================================
* Problem    : 1482. Minimum Number of Days to Make m Bouquets
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Binary Search
* Pattern    : Binary Search on Answer
*
* Link       : https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets
* ============================================================
*/

/*
Intuition

We need to find the minimum number of days required to make `m` bouquets,
where each bouquet requires `k` adjacent flowers.

A flower can be used only after its bloom day has arrived.

The idea is to use binary search over the possible number of days. For a
candidate day, check whether at least `m` bouquets can be made using flowers
that have bloomed by that day.

If enough bouquets can be made, try a smaller number of days. Otherwise,
increase the number of days.
*/

/*
Approach
Binary Search on Answer

First, check whether the total number of flowers is sufficient to make the
required bouquets. If `m* k` exceeds the number of flowers, return -1.

Set the search range from the minimum bloom day to the maximum bloom day.

For each middle day, check whether at least `m` bouquets can be made.

Traverse the flowers and count consecutive flowers that have bloomed by the
candidate day. Whenever `k` consecutive flowers are found, make a bouquet and
reset the consecutive flower count.

If at least `m` bouquets can be made, search for a smaller number of days.
Otherwise, search the upper half.

Time: O(n log D), where D is the range of bloom days
Space: O(1)
*/

package binary_search;

public class P1482MinimumNumberOfDaysToMakeBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m* k > bloomDay.length) {
            return -1;
        }
        int l = bloomDay[0], r = 0;
        for (int bloom : bloomDay) {
            l = Math.min(l, bloom);
            r = Math.max(r, bloom);
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (canFinish(bloomDay, mid, m, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    public boolean canFinish(int[] bloomDay, int days, int m, int k) {
        int bouquets = 0, currentBloom = 0;
        for (int bloom : bloomDay) {
            if (bloom <= days) {
                currentBloom++;
                if (currentBloom == k) {
                    bouquets++;
                    currentBloom = 0;
                }
            } else {
                currentBloom = 0;
            }
        }
        return bouquets >= m;
    }
}