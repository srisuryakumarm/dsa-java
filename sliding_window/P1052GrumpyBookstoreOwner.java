/**
* ============================================================
* Problem    : 1052. Grumpy Bookstore Owner
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Sliding Window
* Pattern    : Sliding Window
*
* Link       : https://leetcode.com/problems/grumpy-bookstore-owner
* ============================================================
*/

/*
Intuition

The customers who are already satisfied when the owner is not grumpy will
always be satisfied.

For the customers affected by the owner's grumpy state, we can use the secret
technique for a continuous period of `minutes` to make them satisfied.

The idea is to find the window of size `minutes` that contains the maximum
number of otherwise unsatisfied customers and add that value to the customers
who are already satisfied.
*/

/*
Approach
Fixed Sliding Window

First, calculate the number of customers who are already satisfied when the
owner is not grumpy.

Then maintain a sliding window of size `minutes` over the days when the owner
is grumpy.

Add the customers inside the current window when `grumpy[i] == 1`. When the
window becomes larger than `minutes`, remove the customers leaving the window.

Track the maximum number of additional customers that can be satisfied by
applying the secret technique.

Finally, add this maximum value to the customers who are already satisfied.

Time: O(n)
Space: O(1)
*/

package sliding_window;

public class P1052GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int l = 0, b = 0, sum = 0, cust = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                cust += customers[i];
            }
        }
        for (int r = 0; r < customers.length; r++) {
            if (grumpy[r] == 1) {
                sum += customers[r];
            }
            if ((r - l + 1) > minutes) {
                if (grumpy[l] == 1) {
                    sum -= customers[l];
                }
                l++;
            }
            b = Math.max(b, sum);
        }
        return b + cust;
    }
}