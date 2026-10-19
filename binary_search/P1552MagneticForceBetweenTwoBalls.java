/**
* ============================================================
* Problem    : 1552. Magnetic Force Between Two Balls
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Binary Search, Sorting, Greedy
* Pattern    : Binary Search on Answer
*
* Link       : https://leetcode.com/problems/magnetic-force-between-two-balls
* ============================================================
*/

/*
Intuition

We need to place `m` balls in the given positions such that the minimum
distance between any two balls is maximized.

The idea is to sort the positions and use binary search on the minimum
distance between the balls.

For a candidate distance, greedily place each ball at the earliest available
position that is at least that distance away from the previously placed ball.

If at least `m` balls can be placed, the distance is achievable, so we try a
larger distance. Otherwise, we need to try a smaller distance.
*/

/*
Approach
Binary Search on Answer + Greedy

Sort the positions in ascending order.

Set the minimum possible distance to 1 and the maximum possible distance to
the difference between the last and first positions.

For each middle distance, check whether at least `m` balls can be placed while
maintaining that minimum distance.

Place the first ball at the first position. Then traverse the remaining
positions and place a ball whenever the distance from the previously placed
ball is at least the candidate distance.

If at least `m` balls can be placed, store the distance as a possible answer
and search for a larger distance. Otherwise, search for a smaller distance.

Time: O(n log n + n log D), where D is the range of positions
Space: O(1) auxiliary space
*/

package binary_search;

import java.util.Arrays;

public class P1552MagneticForceBetweenTwoBalls {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1;
        int r = position[position.length - 1] - position[0];
        int b = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canFinish(position, mid, m)) {
                b = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return b;
    }
    public boolean canFinish(int[] position, int distance, int balls) {
        int ballsPlaced = 1;
        int lastPlaced = position[0];
        for (int pos : position) {
            if (pos - lastPlaced >= distance) {
                ballsPlaced++;
                lastPlaced = pos;

                if (ballsPlaced >= balls) {
                    return true;
                }
            }
        }
        return false;
    }
}