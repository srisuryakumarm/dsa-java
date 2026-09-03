/**
* ============================================================
* Problem    : 134. Gas Station
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Greedy
* Pattern    : Greedy
*
* Link       : https://leetcode.com/problems/gas-station
* ============================================================
*/

/*
Intuition

We need to find a starting gas station from which we can travel around the
entire circuit without the gas in the tank becoming negative.

For the brute force approach, try starting from every gas station and simulate
the complete circuit.

For the optimized approach, track the total gas available and the current gas
balance from the current starting position.

If the current balance becomes negative at station `i`, none of the stations
between the current start and `i` can be a valid starting point. Therefore, the
next station becomes the new starting point.

A valid starting point exists only when the total gas is greater than or equal
to the total cost.
*/

/*
Approach 1
Brute Force

Try every gas station as a possible starting point.

For each starting point, simulate the complete circuit and keep track of the
gas in the tank.

If the gas becomes negative at any station, that starting point is invalid.

Return the first starting point that completes the circuit. If no starting
point works, return -1.

Time: O(n²)
Space: O(1)
*/

/*
Approach 2
Greedy

Maintain:
- `total` as the total gas available after subtracting the total cost.
- `current` as the current gas balance from the current starting point.
- `start` as the current candidate starting station.

Traverse the stations once.

If `current` becomes negative at station `i`, the current starting point and
every station between `start` and `i` cannot be a valid starting point. Set
`i + 1` as the new starting point and reset the current balance.

After traversing all stations, a solution exists only if the total gas is
greater than or equal to the total cost.

Time: O(n)
Space: O(1)
*/

package greedy_intervals;

public class P134GasStation {
    // Brute Force
    // for (int i = 0; i < gas.length; i++) {
    //     int tank = 0;
    //     boolean reached = true;
    //     for (int j = 0; j < gas.length; j++) {
    //         int index = (i + j) % gas.length;
    //         tank += gas[index] - cost[index];
    //         if (tank < 0) {
    //             reached = false;
    //             break;
    //         }
    //     }
    //     if (reached) {
    //         return i;
    //     }
    // }
    // return -1;

    // Optimal - Greedy
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, current = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            current += gas[i] - cost[i];
            if (current < 0) {
                start = i + 1;
                current = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}