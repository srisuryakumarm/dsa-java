/**
* ============================================================
* Problem    : 122. Best Time to Buy and Sell Stock II
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Arrays, Greedy
* Pattern    : Greedy
*
* Link       : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
* ============================================================
*/

/*
Intuition

We can make multiple transactions, but we cannot hold more than one stock at a
time.

Whenever the current day's price is higher than the previous day's price, we
can take the difference as profit.

By adding every positive price difference, we capture all the profit that can
be made from increasing price movements.
*/

/*
Approach
Greedy

Keep track of the minimum price using `min`.

If the current price is lower than `min`, update `min`.

Otherwise, the current price is higher than or equal to `min`, so add the
difference to the total profit and set `min` to the current price.

This effectively captures profit from every increasing price movement.

Time: O(n)
Space: O(1)
*/

package greedy_intervals;

public class P122BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int sum = 0, min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                sum += prices[i] - min;
                min = prices[i];
            }
        }

        return sum;
    }
}