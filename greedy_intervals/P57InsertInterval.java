/**
* ============================================================
* Problem    : 57. Insert Interval
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays
* Pattern    : Intervals, Greedy
*
* Link       : https://leetcode.com/problems/insert-interval
* ============================================================
*/

/*
Intuition

The intervals are already sorted by their start time and do not overlap.

The idea is to divide the intervals into three parts:

1. Intervals that end before the new interval starts.
2. Intervals that overlap with the new interval and need to be merged.
3. Intervals that start after the merged new interval ends.

Add the first group directly, merge the overlapping intervals into the new
interval, then add the remaining intervals.
*/

/*
Approach
Greedy

Traverse the intervals using an index.

First, add all intervals whose end is before the start of the new interval,
since they cannot overlap with it.

Then, process all intervals whose start is less than or equal to the end of the
new interval. Merge each of them into `newInterval` by updating its start and
end.

Add the merged `newInterval` to the result.

Finally, add all remaining intervals that come after the new interval.

Time: O(n)
Space: O(n)
*/

package greedy_intervals;

public class P57InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int i = 0, n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]) {
            merged.add(intervals[i]);
            i++;
        }
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        merged.add(newInterval);
        while (i < n) {
            merged.add(intervals[i]);
            i++;
        }
        return merged.toArray(new int[merged.size()][]);
    }
}