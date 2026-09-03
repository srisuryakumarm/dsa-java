/**
* ============================================================
* Problem    : 56. Merge Intervals
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Sorting
* Pattern    : Intervals, Greedy
*
* Link       : https://leetcode.com/problems/merge-intervals
* ============================================================
*/

/*
Intuition

We need to merge all overlapping intervals.

If the intervals are sorted by their starting values, we can process them from
left to right.

For each interval, compare its start with the end of the last merged interval.
If the current interval starts after the end of the last merged interval, there
is no overlap, so it can be added separately.

Otherwise, the two intervals overlap, so extend the end of the last merged
interval to the larger of the two end values.
*/

/*
Approach
Sorting + Greedy

Sort the intervals based on their starting values.

Maintain a list of merged intervals.

For each interval:
- If there are no merged intervals or the current interval does not overlap
  with the last merged interval, add it to the result.
- Otherwise, merge it with the last merged interval by updating its end to the
  maximum of the two end values.

Finally, convert the list of merged intervals into an array.

Time: O(n log n)
Space: O(n)
*/

package greedy_intervals;

public class P56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] current : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < current[0]) {
                merged.add(current);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], current[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}