/**
* ============================================================
* Problem    : 45. Jump Game II
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Greedy
* Pattern    : Greedy
*
* Link       : https://leetcode.com/problems/jump-game-ii
* ============================================================
*/

/*
Intuition

We need to reach the last index using the minimum number of jumps.

The idea is to treat all positions that can be reached with the current number
of jumps as one range.

While traversing this range, keep track of the farthest position that can be
reached with one more jump.

When we reach the end of the current range, we must make another jump and use
the farthest reachable position as the end of the new range.

This allows us to find the minimum number of jumps without exploring every
possible path.
*/

/*
Approach
Greedy

Maintain three variables:

- `maxJump` stores the farthest index reachable while processing the current
  range.
- `jumpEnd` stores the end of the range that can be reached using the current
  number of jumps.
- `result` stores the number of jumps taken.

Traverse the array until the second-last index.

For every index, update `maxJump` with the farthest position reachable from
that index.

When the current index reaches `jumpEnd`, a new jump is required. Increment the
jump count and set `jumpEnd` to `maxJump`.

Time: O(n)
Space: O(1)
*/

package greedy_intervals;

public class P45JumpGameII {
    public int jump(int[] nums) {
        int maxJump = 0, jumpEnd = 0, result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
            if (i == jumpEnd) {
                result++;
                jumpEnd = maxJump;
            }
        }
        return result;
    }
}