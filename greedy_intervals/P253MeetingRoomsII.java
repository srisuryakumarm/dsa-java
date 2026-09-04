/**
* ============================================================
* Problem    : 253. Meeting Rooms II
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Sorting, Heap, Priority Queue
* Pattern    : Greedy + Heap
*
* Link       : https://leetcode.com/problems/meeting-rooms-ii
* ============================================================
*/

/*
Intuition

We need to find the minimum number of rooms required to schedule all meetings.

Sort the meetings by their start time.

For every meeting, check the earliest ending meeting among the meetings that are
already using rooms.

If that meeting has ended before or exactly when the current meeting starts,
the same room can be reused.

Otherwise, another room is required.

A PriorityQueue is used to always keep the earliest ending meeting at the top.
*/

/*
Approach
Sorting + PriorityQueue

Sort the intervals by their start time.

Use a min-heap to store the end times of meetings currently occupying rooms.

For each meeting:
- If the earliest ending meeting ends before or exactly when the current
  meeting starts, remove that end time because its room can be reused.
- Add the current meeting's end time to the heap.

The size of the PriorityQueue at the end represents the number of rooms required.

Time: O(n log n)
Space: O(n)
*/

package greedy_intervals;

public class P253MeetingRoomsII {
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!endTime.isEmpty() && endTime.peek() <= interval[0]) {
                endTime.poll();
            }
            endTime.offer(interval[1]);
        }
        return endTime.size();
    }
}