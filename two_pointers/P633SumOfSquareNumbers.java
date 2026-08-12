/**
* ============================================================
* Problem    : 633. Sum of Square Numbers
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Math, Two Pointers
* Pattern    : Two Pointers
*
* Link       : https://leetcode.com/problems/sum-of-square-numbers
* ============================================================
*/

/*
Intuition

We need to determine whether the number can be represented as the sum of two
squared integers.

Since the possible values of the two numbers are ordered, we can use two
pointers: one starting from zero and the other starting from the square root
of the given number.

If the sum of the squares is greater than the target, decrease the right
pointer. If the sum is smaller than the target, increase the left pointer.
*/

/*
Approach
Two Pointers

Initialize the left pointer to 0 and the right pointer to the square root of
the given number.

Calculate the sum of the squares of both pointers.

If the sum equals the given number, return true.

If the sum is greater than the given number, decrease the right pointer.
Otherwise, increase the left pointer.

Continue until the pointers cross each other.

Time: O(√c)
Space: O(1)
*/

package two_pointers;

public class P633SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        long l = 0, r = (long) Math.sqrt(c);

        while (l <= r) {
            long sum = (l* l) + (r* r);

            if (sum == c) {
                return true;
            } else if (sum > c) {
                r--;
            } else {
                l++;
            }
        }

        return false;
    }
}