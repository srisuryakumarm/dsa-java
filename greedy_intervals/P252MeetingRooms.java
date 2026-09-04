/**
* ============================================================
* Problem    : 252. Meeting Rooms
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Arrays, Sorting, Intervals
* Pattern    : Intervals
*
* Link       : https://leetcode.com/problems/meeting-rooms
* ============================================================
*/

/*
Intuition

We need to determine whether a person can attend all the meetings without any
overlap.

If the meetings are sorted by their start times, we only need to compare each
meeting with the next meeting.

If a meeting ends after the next meeting starts, the two meetings overlap, so
they cannot both be attended.
*/

/*
Approach
Sorting

Sort the intervals by their start time.

Traverse the sorted intervals and compare the end time of the current meeting
with the start time of the next meeting.

If the current meeting ends after the next meeting starts, the meetings
overlap, so return false.

If no overlapping meetings are found, return true.

Time: O(n log n)
Space: O(1)
*/

package greedy_intervals;

public class P252MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
}