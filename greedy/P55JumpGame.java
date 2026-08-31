/**
* ============================================================
* Problem    : 55. Jump Game
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Greedy
* Pattern    : Greedy
*
* Link       : https://leetcode.com/problems/jump-game
* ============================================================
*/

/*
Intuition

We need to determine whether the last index can be reached from the first
index.

The idea is to keep track of the farthest index that can be reached while
traversing the array.

If the current index is beyond the farthest reachable index, it cannot be
reached, so the last index cannot be reached either.

Otherwise, update the farthest reachable index using the current position and
the maximum jump length from that position.
*/

/*
Approach
Greedy

Maintain `maxJump` as the farthest index that can be reached so far.

For each index, first check whether the current index is reachable. If the
current index is greater than `maxJump`, return false.

Otherwise, update `maxJump` using `i + nums[i]`.

If `maxJump` reaches or passes the last index, return true.

If the traversal finishes without finding an unreachable index, return true.

Time: O(n)
Space: O(1)
*/

package greedy;

public class P55JumpGame {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxJump) {
                return false;
            }
            maxJump = Math.max(maxJump, i + nums[i]);
            if (maxJump >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}