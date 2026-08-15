/**
* ============================================================
* Problem    : 881. Boats to Save People
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Two Pointers, Sorting, Greedy
* Pattern    : Two Pointers
*
* Link       : https://leetcode.com/problems/boats-to-save-people
* ============================================================
*/

/*
Intuition

Each boat can carry at most two people, and their combined weight must not
exceed the limit.

The idea is to always consider the heaviest person. If the heaviest person can
share a boat with the lightest person, place them together. Otherwise, the
heaviest person must occupy a boat alone.
*/

/*
Approach
Two Pointers

Sort the array of people by weight.

Use two pointers, one at the lightest person and one at the heaviest person.

If the lightest and heaviest people can fit in the same boat, move the left
pointer forward.

Regardless of whether they share a boat or not, the heaviest person is placed
in a boat, so move the right pointer backward and increment the boat count.

Continue until all people have been assigned to boats.

Time: O(n log n)
Space: O(1)
*/

package two_pointers;

public class P881BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1, boat = 0;
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                l++;
            }

            boat++;
            r--;
        }
        return boat;
    }
}