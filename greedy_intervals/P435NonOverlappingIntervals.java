/**
* ============================================================
* Problem    : 435. Non-overlapping Intervals
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Sorting, Greedy
* Pattern    : Greedy
*
* Link       : https://leetcode.com/problems/non-overlapping-intervals
* ============================================================
*/

/*
Intuition

We need to remove the minimum number of intervals so that the remaining
intervals do not overlap.

Instead of directly deciding which intervals to remove, we can focus on keeping
the maximum number of non-overlapping intervals.

To maximize the number of intervals we keep, always choose the interval that
ends earliest. This leaves the maximum possible space for the remaining
intervals.

Therefore, sort the intervals by their end time and greedily keep an interval
when it does not overlap with the previously selected interval.
*/

/*
Approach
Greedy + Sorting by End Time

Sort the intervals by their ending position.

Keep track of the end of the last selected non-overlapping interval.

For each interval:
- If its start is before `lastEnd`, it overlaps with the previous interval, so
  remove it.
- Otherwise, keep it and update `lastEnd` to the current interval's end.

The number of removed intervals is the minimum number required.

Time: O(n log n)
Space: O(1)
*/

package greedy_intervals;

public class P435NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int remove = 0;
        int lastEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < lastEnd) {
                remove++;
            } else {
                lastEnd = intervals[i][1];
            }
        }
        return remove;
    }
}