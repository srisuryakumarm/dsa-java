/**
* ============================================================
* Problem    : 232. Implement Queue using Stacks
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Stack, Queue
* Pattern    : Queue
*
* Link       : https://leetcode.com/problems/implement-queue-using-stacks
* ============================================================
*/

/*
Intuition

A queue follows the FIFO (First In, First Out) principle, whereas a stack
follows the LIFO (Last In, First Out) principle.

To simulate queue operations using stacks, use one stack to store incoming
elements and another stack to retrieve elements in FIFO order.
*/

/*
Approach 1
Brute Force



Time:
Space:
*/

/*
Approach 2
Optimal

Use two stacks:
- inStack stores all newly inserted elements.
- outStack stores elements in the order required for queue operations.

For push operations, insert the element into inStack.

For pop and peek operations, transfer all elements from inStack to outStack
only when outStack is empty. This ensures that the oldest inserted element
appears on the top of outStack.

By transferring elements only when necessary, each element is moved at most
once from inStack to outStack, making the operations efficient.

Time:
- Push: O(1)
- Pop: Amortized O(1)
- Peek: Amortized O(1)
- Empty: O(1)
Space: O(n)
*/

package stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class P232ImplementQueueUsingStacks{
    public static void main(String[] args) {}

    class MyQueue {
        private final Deque<Integer> inStack = new ArrayDeque<>();
        private final Deque<Integer> outStack = new ArrayDeque<>();

        public MyQueue() {

        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            transferIfNeeded();
            return outStack.pop();
        }

        public int peek() {
            transferIfNeeded();
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        private void transferIfNeeded() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }
    }
}