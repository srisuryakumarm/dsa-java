/**
* ============================================================
* Problem    : 406. Queue Reconstruction by Height
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Sorting, Greedy
* Pattern    : Greedy
*
* Link       : https://leetcode.com/problems/queue-reconstruction-by-height
* ============================================================
*/

/*
Intuition

Each person is represented by `[h, k]`, where `h` is the person's height and
`k` is the number of people in front of them who have a height greater than or
equal to `h`.

The idea is to place taller people first.

For people with the same height, place the person with the smaller `k` first.

Once taller people have been placed, inserting a person at index `k` guarantees
that exactly `k` people who are already placed are in front of them. Since all
already placed people are at least as tall as the current person, the required
condition is satisfied.
*/

/*
Approach
Greedy + Sorting

Sort the people by:
- Height in descending order.
- `k` value in ascending order when heights are equal.

Then process the people in the sorted order.

For each person, insert them at index `k` in the result list.

Since all previously inserted people are taller than or equal to the current
person, placing the current person at index `k` ensures that exactly `k` taller
or equal people are in front of them.

Time: O(n²)
Space: O(n)
*/

package greedy;

public class P406QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        List<int[]> result = new ArrayList<>();
        for (int[] person : people) {
            result.add(person[1], person);
        }
        return result.toArray(new int[result.size()][]);
    }
}