/**
* ============================================================
* Problem    : 986. Interval List Intersections
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Two Pointers, Intervals
* Pattern    : Two Pointers
*
* Link       : https://leetcode.com/problems/interval-list-intersections
* ============================================================
*/

/*
Intuition

Both interval lists are sorted and contain non-overlapping intervals.

For two current intervals, their intersection starts at the larger of their
start values and ends at the smaller of their end values.

If the intersection start is less than or equal to the intersection end, the
two intervals overlap and the intersection is added to the result.

After processing the current pair, move the pointer of the interval that ends
first because it cannot intersect with any future interval from the other list.
*/

/*
Approach
Two Pointers

Use one pointer for each interval list.

For the current pair of intervals:
- The intersection starts at the maximum of the two start values.
- The intersection ends at the minimum of the two end values.

If the intervals overlap, add the intersection to the result.

Then move the pointer of the interval that ends first. If both intervals end
at the same position, move the pointer of the second list.

Continue until one of the lists is exhausted.

Time: O(m + n)
Space: O(m + n)
*/

package greedy_intervals;

public class P986IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            if (secondList[j][0] <= firstList[i][1] && secondList[j][1] >= firstList[i][0]) {
                int[] intersection = new int[2];
                intersection[0] = Math.max(firstList[i][0], secondList[j][0]);
                intersection[1] = Math.min(firstList[i][1], secondList[j][1]);
                merged.add(intersection);
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}