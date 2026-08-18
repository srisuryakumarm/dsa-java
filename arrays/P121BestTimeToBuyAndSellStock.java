/**
* ============================================================
* Problem    : 121. Best Time to Buy and Sell Stock
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Arrays, Greedy
* Pattern    : Greedy
*
* Link       : https://leetcode.com/problems/best-time-to-buy-and-sell-stock
* ============================================================
*/

/*
Intuition

To maximize the profit, we need to buy the stock at the lowest price before
selling it at a higher price.

The idea is to keep track of the minimum buying price seen so far and calculate
the profit that can be made by selling at the current price.

Whenever a lower price is found, update the minimum buying price.
*/

/*
Approach 1
Brute Force

Consider every possible pair of buying and selling days.

For each pair, calculate the profit by subtracting the buying price from the
selling price and keep track of the maximum profit.

Time: O(n²)
Space: O(1)
*/

/*
Approach 2
Greedy

Maintain the minimum stock price seen so far.

For each price, update the minimum price if the current price is lower.
Otherwise, calculate the profit by selling at the current price and update the
maximum profit.

Since the minimum buying price is always maintained before the current selling
day, the maximum possible profit can be found in a single traversal.

Time: O(n)
Space: O(1)
*/

package arrays;

public class P121BestTimeToBuyAndSellStock {
    // Brute Force
    // int profit = 0;
    // for(int i = 0; i < prices.length; i++){
    //     for(int j = i + 1; j < prices.length; j++){
    //         profit = Math.max(profit, prices[j] - prices[i]);
    //     }
    // }
    // return profit;

    // Optimised - Greedy
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - buy);
            }
        }
        return profit;
    }
}