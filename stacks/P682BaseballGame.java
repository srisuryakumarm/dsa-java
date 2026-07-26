/**
* ============================================================
* Problem    : 682. Baseball Game
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Array, Stack
* Pattern    : Stacks
*
* Link       : https://leetcode.com/problems/baseball-game
* ============================================================
*/

/*
Intuition

Some operations depend on the most recently recorded score, such as doubling it,
removing it, or calculating the sum of the last two scores.

Since all these operations require accessing the most recent score first, a
Stack (LIFO) is the appropriate data structure.
*/

/*
Approach 1
Brute Force

A brute force approach is to maintain all the scores in a list and perform
each operation by accessing or modifying the required elements directly.

Time: O(n²)
Space: O(n)
*/

/*
Approach 2
Optimal

Use a stack to store all valid scores.

For each operation:
- Push a new score onto the stack.
- Remove the most recent score for "C".
- Push double the previous score for "D".
- Push the sum of the last two scores for "+".

After processing all the operations, iterate through the stack to calculate the
final score.

Time: O(n) - Iterate through the operations once
Space: O(n) - In the worst case, all the scores are stored in the stack
*/

package stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class P682BaseballGame{
    public static void main(String[] args){}

    // Optimised
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String op: operations){
            switch(op){
                case "+" -> {
                    int top = stack.pop();
                    int second = stack.peek();
                    stack.push(top);
                    stack.push(top + second);
                }
                case "D" -> stack.push(stack.peek()* 2);
                case "C" -> stack.pop();
                default -> stack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for(int score: stack){
            sum += score;
        }
        return sum;
    }
}