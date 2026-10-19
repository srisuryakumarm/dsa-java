/**
* ============================================================
* Problem    : 1011. Capacity To Ship Packages Within D Days
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Binary Search
* Pattern    : Binary Search on Answer
*
* Link       : https://leetcode.com/problems/capacity-to-ship-packages-within-d-days
* ============================================================
*/

/*
Intuition

We need to find the minimum ship capacity required to ship all packages within
the given number of days.

The minimum possible capacity is the heaviest package because every package
must be shipped without splitting it.

The maximum possible capacity is the sum of all package weights because the
ship could carry every package in a single day.

The idea is to use binary search over this capacity range. For each candidate
capacity, check whether all packages can be shipped within the given number of
days.

If the capacity is sufficient, try a smaller capacity. Otherwise, increase the
capacity.
*/

/*
Approach
Binary Search on Answer

Initialize the lower bound to the maximum package weight and the upper bound
to the sum of all package weights.

For each middle capacity, check how many days are required to ship all
packages while preserving their order.

If the current package would exceed the capacity, start a new day and place
that package on the new day.

If all packages can be shipped within the given number of days, search for a
smaller capacity. Otherwise, search for a larger capacity.

Continue until the left and right pointers converge.

Time: O(n log S), where S is the sum of all package weights
Space: O(1)
*/

package binary_search;

public class P1011CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;
        for (int weight : weights) {
            l = Math.max(l, weight);
            r += weight;
        }
        while (l < r) {
            int m = l + (r - l) / 2;
            if (canFinish(weights, m, days)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    public boolean canFinish(int[] weights, int limit, int days) {
        int daysNeeded = 1, currentWeight = 0;
        for (int weight : weights) {
            currentWeight += weight;
            if (currentWeight > limit) {
                daysNeeded++;
                currentWeight = weight;
            }
        }
        return daysNeeded <= days;
    }
}