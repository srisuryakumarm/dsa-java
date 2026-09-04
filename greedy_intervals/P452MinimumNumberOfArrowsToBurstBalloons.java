/**
* ============================================================
* Problem    : 452. Minimum Number of Arrows to Burst Balloons
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Sorting, Greedy
* Pattern    : Greedy
*
* Link       : https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
* ============================================================
*/

/*
Intuition

Each balloon can be burst by an arrow shot at any point within its interval.

To use the minimum number of arrows, we can process the balloons in increasing
order of their ending position and try to use the same arrow for as many
overlapping balloons as possible.

If the next balloon starts before or at the position of the last arrow, the
same arrow can burst it.

Otherwise, a new arrow is required at the end of the current balloon.
*/

/*
Approach
Greedy + Sorting by End Time

Sort the balloons by their ending position.

Keep track of the position of the last arrow using `lastEnd`.

For each balloon:
- If its start is less than or equal to `lastEnd`, it overlaps with the
  current arrow position, so it can be burst by the same arrow.
- Otherwise, the current arrow cannot burst it, so update `lastEnd` to the
  current balloon's end.

Count the number of balloons that overlap with the current arrow and calculate
the number of required arrows from the total number of balloons.

Time: O(n log n)
Space: O(1)
*/

package greedy_intervals;

public class P452MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int overlap = 0, lastEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= lastEnd) {
                overlap++;
            } else {
                lastEnd = points[i][1];
            }
        }
        return points.length - overlap;
    }
}