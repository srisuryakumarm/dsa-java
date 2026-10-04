# dsa-java

LeetCode solutions organized by interview pattern, built as part of a structured 148-day SDE-2 preparation plan. Each pattern is solved as a complete ladder — easy through hard — rather than as scattered, unrelated problems, so the repository doubles as a pattern-recognition reference for interview review.

## Progress

**55 / 203 problems solved · 5 / 18 patterns complete** *(as of Day 27)*

| Pattern | Problems | Status |
|---|---|---|
| HashMap / HashSet | 7 | ✅ Complete |
| Two Pointers | 16 | ✅ Complete |
| Sliding Window | 14 | ✅ Complete |
| Prefix Sum & Kadane's | 7 | ✅ Complete |
| Greedy & Intervals | 11 | ✅ Complete |
| Binary Search | 11 | ⬜ Not started |
| Linked Lists | 11 | ⬜ Not started |
| Stacks / Monotonic Stack | 12 | ⬜ Not started |
| Trees | 15 | ⬜ Not started |
| Heaps / Priority Queue | 10 | ⬜ Not started |
| Tries | 7 | ⬜ Not started |
| Backtracking | 12 | ⬜ Not started |
| Graphs (BFS/DFS) | 12 | ⬜ Not started |
| Union-Find | 7 | ⬜ Not started |
| Dijkstra's Algorithm | 5 | ⬜ Not started |
| Dynamic Programming | 35 | ⬜ Not started |
| Bit Manipulation | 10 | ⬜ Not started |
| Segment Trees | 2 | ⬜ Not started |
| Sorting, From Scratch | — | ⬜ Not started |
| SQL Practice Track | 10 | ⬜ Not started |

> **Note:** [Maximum XOR of Two Numbers in an Array (#421)](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/) closes both the Tries and Bit Manipulation ladders at once — it's a Bit Trie problem, so it's listed once in each section but counted only once toward the 203 total.

## Structure

Each pattern lives in its own folder, one subfolder per problem:

```
dsa-java/
├── hashmap-hashset/
│   ├── two-sum/
│   ├── contains-duplicate/
│   └── ...
├── two-pointers/
├── sliding-window/
├── prefix-sum-kadanes/
├── greedy-intervals/
├── binary-search/
├── linked-lists/
├── stacks/
├── trees/
├── heaps/
├── tries/
├── backtracking/
├── graphs/
├── union-find/
├── dijkstra/
├── dynamic-programming/
├── bit-manipulation/
├── segment-trees/
├── sorting/
└── sql/
```

Every problem folder holds the Java solution plus a short note on the pattern it demonstrates and its time/space complexity.

## Patterns

<details>
<summary><strong>HashMap / HashSet</strong> — 7/7 ✅</summary>

O(1) average lookup turns an O(n²) brute-force "check every pair" into O(n). Signal: "find a pair," "check duplicates," "count frequency," "group by."

- [x] Two Sum — #1 — 🟢 Easy
- [x] Contains Duplicate — #217 — 🟢 Easy
- [x] Valid Anagram — #242 — 🟢 Easy
- [x] Ransom Note — #383 — 🟢 Easy
- [x] Isomorphic Strings — #205 — 🟢 Easy
- [x] Group Anagrams — #49 — 🟡 Medium
- [x] Longest Consecutive Sequence — #128 — 🟡 Medium
</details>

<details>
<summary><strong>Two Pointers</strong> — 16/16 ✅</summary>

Two indices moving through a structure — opposite ends inward, or the same end at different speeds — instead of nested loops. Signal: sorted array + "find a pair/triplet," "reverse in place," "partition without extra space."

- [x] Valid Palindrome — #125 — 🟢 Easy
- [x] Reverse String — #344 — 🟢 Easy
- [x] Merge Sorted Array — #88 — 🟢 Easy
- [x] Is Subsequence — #392 — 🟢 Easy
- [x] Valid Palindrome II — #680 — 🟢 Easy
- [x] Remove Duplicates from Sorted Array — #26 — 🟢 Easy
- [x] Move Zeroes — #283 — 🟢 Easy
- [x] Squares of a Sorted Array — #977 — 🟢 Easy
- [x] Two Sum II (Input Array Is Sorted) — #167 — 🟡 Medium
- [x] 3Sum — #15 — 🟡 Medium
- [x] 3Sum Closest — #16 — 🟡 Medium
- [x] 4Sum — #18 — 🟡 Medium
- [x] Boats to Save Most People — #881 — 🟡 Medium
- [x] Container With Most Water — #11 — 🟡 Medium
- [x] Sort Colors — #75 — 🟡 Medium
- [x] Trapping Rain Water — #42 — 🔴 Hard
</details>

<details>
<summary><strong>Sliding Window</strong> — 14/14 ✅</summary>

A window that expands and contracts over the data instead of re-scanning from scratch for every start point — turns an O(n²)/O(n³) brute force into O(n). Signal: "longest/shortest contiguous subarray/substring satisfying a condition," "at most K distinct."

- [x] Best Time to Buy and Sell Stock — #121 — 🟢 Easy
- [x] Maximum Average Subarray I — #643 — 🟢 Easy
- [x] Max Consecutive Ones III — #1004 — 🟡 Medium
- [x] Longest Substring Without Repeating Characters — #3 — 🟡 Medium
- [x] Longest Repeating Character Replacement — #424 — 🟡 Medium
- [x] Permutation in String — #567 — 🟡 Medium
- [x] Find All Anagrams in a String — #438 — 🟡 Medium
- [x] Minimum Size Subarray Sum — #209 — 🟡 Medium
- [x] Fruit Into Baskets — #904 — 🟡 Medium
- [x] Longest Subarray of 1's After Deleting One Element — #1493 — 🟡 Medium
- [x] Longest Substring with At Most K Distinct Characters — #340 — 🟡 Medium
- [x] Minimum Window Substring — #76 — 🔴 Hard
- [x] Sliding Window Maximum — #239 — 🔴 Hard
- [x] Subarrays with K Different Integers — #992 — 🔴 Hard
</details>

<details>
<summary><strong>Prefix Sum & Kadane's</strong> — 7/7 ✅</summary>

Precomputed cumulative sums make any range's total a single subtraction away; Kadane's is the running-maximum special case. Signal: "contiguous subarray," "range sum," "maximum sum subarray."

- [x] Range Sum Query - Immutable — #303 — 🟢 Easy
- [x] Maximum Subarray — #53 — 🟡 Medium
- [x] Product of Array Except Self — #238 — 🟡 Medium
- [x] Contiguous Array — #525 — 🟡 Medium
- [x] Continuous Subarray Sum — #523 — 🟡 Medium
- [x] Subarray Sum Equals K — #560 — 🟡 Medium
- [x] Maximum Subarray Sum Circular — #918 — 🟡 Medium
</details>

<details>
<summary><strong>Greedy & Intervals</strong> — 11/11 ✅</summary>

Greedy: commit to the locally-best choice at each step and never revisit it. Intervals: sort by start or end time, then sweep once. Signal: "maximum profit/reach," "merge/insert/overlap," "minimum resources needed."

- [x] Best Time to Buy and Sell Stock II — #122 — 🟢 Easy
- [x] Jump Game — #55 — 🟡 Medium
- [x] Jump Game II — #45 — 🟡 Medium
- [x] Gas Station — #134 — 🟡 Medium
- [x] Merge Intervals — #56 — 🟡 Medium
- [x] Insert Interval — #57 — 🟡 Medium
- [x] Non-overlapping Intervals — #435 — 🟡 Medium
- [x] Minimum Number of Arrows to Burst Balloons — #452 — 🟡 Medium
- [x] Meeting Rooms — #252 — 🟢 Easy
- [x] Meeting Rooms II — #253 — 🟡 Medium
- [x] Partition Labels — #763 — 🟡 Medium
</details>

<details>
<summary><strong>Binary Search</strong> — 0/11 ⬜</summary>

Repeatedly halve a sorted search space — or, in the "on-the-answer" variant, a monotonic space of possible answers. O(log n) instead of O(n). Signal: "sorted array," or "minimum/maximum value such that a condition holds."

- [x] Binary Search — #704 — 🟢 Easy
- [x] First Bad Version — #278 — 🟢 Easy
- [ ] Search Insert Position — #35 — 🟢 Easy
- [ ] Find Peak Element — #162 — 🟡 Medium
- [ ] Search in Rotated Sorted Array — #33 — 🟡 Medium
- [ ] Search in Rotated Sorted Array II — #81 — 🟡 Medium
- [ ] Find Minimum in Rotated Sorted Array — #153 — 🟡 Medium
- [ ] Find First and Last Position of Element in Sorted Array — #34 — 🟡 Medium
- [ ] Search a 2D Matrix — #74 — 🟡 Medium
- [ ] Koko Eating Bananas — #875 — 🟡 Medium
- [ ] Capacity To Ship Packages Within D Days — #1011 — 🟡 Medium
</details>

<details>
<summary><strong>Linked Lists</strong> — 0/11 ⬜</summary>

A chain of nodes, each holding data and a reference to the next. O(1) insert/delete at a known position, O(n) access to an arbitrary index. Signal: "reverse," "merge," "detect a cycle," "find the middle."

- [ ] Reverse Linked List — #206 — 🟢 Easy
- [ ] Middle of the Linked List — #876 — 🟢 Easy
- [ ] Palindrome Linked List — #234 — 🟢 Easy
- [ ] Merge Two Sorted Lists — #21 — 🟢 Easy
- [ ] Linked List Cycle — #141 — 🟢 Easy
- [ ] Linked List Cycle II — #142 — 🟡 Medium
- [ ] Remove Nth Node From End of List — #19 — 🟡 Medium
- [ ] Add Two Numbers — #2 — 🟡 Medium
- [ ] Reorder List — #143 — 🟡 Medium
- [ ] Copy List with Random Pointer — #138 — 🟡 Medium
- [ ] LRU Cache — #146 — 🟡 Medium
</details>

<details>
<summary><strong>Stacks / Monotonic Stack</strong> — 0/12 ⬜</summary>

LIFO — the last thing pushed is the first thing popped. Signal: "matching/balanced," "nested," "most recent," "evaluate an expression."

- [ ] Valid Parentheses — #20 — 🟢 Easy
- [ ] Implement Queue using Stacks — #232 — 🟢 Easy
- [ ] Next Greater Element I — #496 — 🟢 Easy
- [ ] Next Greater Element II — #503 — 🟡 Medium
- [ ] Min Stack — #155 — 🟡 Medium
- [ ] Daily Temperatures — #739 — 🟡 Medium
- [ ] Evaluate Reverse Polish Notation — #150 — 🟡 Medium
- [ ] Asteroid Collision — #735 — 🟡 Medium
- [ ] Basic Calculator II — #227 — 🟡 Medium
- [ ] Largest Rectangle in Histogram — #84 — 🔴 Hard
- [ ] Maximal Rectangle — #85 — 🔴 Hard
- [ ] Basic Calculator — #224 — 🔴 Hard
</details>

<details>
<summary><strong>Trees</strong> — 0/15 ⬜</summary>

A node with at most two children; nearly every tree problem is recursion applied to that shape. Signal: anything phrased as a tree or hierarchical structure.

- [ ] Maximum Depth of Binary Tree — #104 — 🟢 Easy
- [ ] Invert Binary Tree — #226 — 🟢 Easy
- [ ] Same Tree — #100 — 🟢 Easy
- [ ] Symmetric Tree — #101 — 🟢 Easy
- [ ] Balanced Binary Tree — #110 — 🟢 Easy
- [ ] Diameter of Binary Tree — #543 — 🟢 Easy
- [ ] Binary Tree Level Order Traversal — #102 — 🟡 Medium
- [ ] Binary Tree Right Side View — #199 — 🟡 Medium
- [ ] Validate Binary Search Tree — #98 — 🟡 Medium
- [ ] Kth Smallest Element in a BST — #230 — 🟡 Medium
- [ ] Lowest Common Ancestor of a BST — #235 — 🟡 Medium
- [ ] Construct Binary Tree from Preorder and Inorder Traversal — #105 — 🟡 Medium
- [ ] Lowest Common Ancestor of a Binary Tree — #236 — 🟡 Medium
- [ ] Serialize and Deserialize Binary Tree — #297 — 🔴 Hard
- [ ] Median of Two Sorted Arrays — #4 — 🔴 Hard
</details>

<details>
<summary><strong>Heaps / Priority Queue</strong> — 0/10 ⬜</summary>

A binary tree stored in an array, where every parent is smaller (min-heap) or larger (max-heap) than its children. O(log n) insert/remove-extreme, O(1) peek. Signal: "k largest/smallest," "merge k sorted things," "median of a stream."

- [ ] Kth Largest Element in a Stream — #703 — 🟢 Easy
- [ ] Last Stone Weight — #1046 — 🟢 Easy
- [ ] Kth Largest Element in an Array — #215 — 🟡 Medium
- [ ] K Closest Points to Origin — #973 — 🟡 Medium
- [ ] Top K Frequent Elements — #347 — 🟡 Medium
- [ ] Ugly Number II — #264 — 🟡 Medium
- [ ] Reorganize String — #767 — 🟡 Medium
- [ ] Task Scheduler — #621 — 🟡 Medium
- [ ] Find Median from Data Stream — #295 — 🔴 Hard
- [ ] Merge k Sorted Lists — #23 — 🔴 Hard
</details>

<details>
<summary><strong>Tries</strong> — 0/7 ⬜</summary>

A tree where each edge represents one character; root-to-node paths spell out shared prefixes. O(m) lookup/insert for a word of length m, regardless of dictionary size. Signal: autocomplete, spell-checking, prefix queries.

- [ ] Implement Trie (Prefix Tree) — #208 — 🟡 Medium
- [ ] Map Sum Pairs — #677 — 🟡 Medium
- [ ] Longest Word in Dictionary — #720 — 🟡 Medium
- [ ] Design Add and Search Words Data Structure — #211 — 🟡 Medium
- [ ] Replace Words — #648 — 🟡 Medium
- [ ] Word Search II — #212 — 🔴 Hard
- [ ] Maximum XOR of Two Numbers in an Array — #421 — 🟡 Medium *(shared with Bit Manipulation)*
</details>

<details>
<summary><strong>Backtracking</strong> — 0/12 ⬜</summary>

Explore a decision tree by making a choice, recursing into it, and undoing the choice on the way back. Signal: "generate all," "find all valid," "every possible arrangement/combination/permutation."

- [ ] Subsets — #78 — 🟡 Medium
- [ ] Permutations — #46 — 🟡 Medium
- [ ] Combinations — #77 — 🟡 Medium
- [ ] Permutations II — #47 — 🟡 Medium
- [ ] Combination Sum — #39 — 🟡 Medium
- [ ] Combination Sum II — #40 — 🟡 Medium
- [ ] Letter Combinations of a Phone Number — #17 — 🟡 Medium
- [ ] Generate Parentheses — #22 — 🟡 Medium
- [ ] Word Search — #79 — 🟡 Medium
- [ ] Palindrome Partitioning — #131 — 🟡 Medium
- [ ] Subsets II — #90 — 🟡 Medium
- [ ] N-Queens — #51 — 🔴 Hard
</details>

<details>
<summary><strong>Graphs (BFS/DFS)</strong> — 0/12 ⬜</summary>

Nodes connected by edges. BFS explores level by level (shortest path, unweighted); DFS explores as deep as possible (exhaustive search, connectivity, cycle detection).

- [ ] Number of Islands — #200 — 🟡 Medium
- [ ] Max Area of Island — #695 — 🟡 Medium
- [ ] Clone Graph — #133 — 🟡 Medium
- [ ] Is Graph Bipartite? — #785 — 🟡 Medium
- [ ] Rotting Oranges — #994 — 🟡 Medium
- [ ] All Paths From Source to Target — #797 — 🟡 Medium
- [ ] Course Schedule — #207 — 🟡 Medium
- [ ] Course Schedule II — #210 — 🟡 Medium
- [ ] Surrounded Regions — #130 — 🟡 Medium
- [ ] Pacific Atlantic Water Flow — #417 — 🟡 Medium
- [ ] Word Ladder — #127 — 🔴 Hard
- [ ] Find the City With the Smallest Number of Neighbors at a Threshold Distance — #1334 — 🟡 Medium
</details>

<details>
<summary><strong>Union-Find</strong> — 0/7 ⬜</summary>

Tracks disjoint sets with near-O(1) `find` and `union`, via path compression and union by rank/size. Signal: "are these connected," "how many groups," "does adding this edge create a cycle."

- [ ] Redundant Connection — #684 — 🟡 Medium
- [ ] Number of Provinces — #547 — 🟡 Medium
- [ ] Satisfiability of Equality Equations — #990 — 🟡 Medium
- [ ] Most Stones Removed with Same Row or Column — #947 — 🟡 Medium
- [ ] Smallest String With Swaps — #1202 — 🟡 Medium
- [ ] Accounts Merge — #721 — 🟡 Medium
- [ ] Graph Valid Tree — #261 — 🟡 Medium
</details>

<details>
<summary><strong>Dijkstra's Algorithm</strong> — 0/5 ⬜</summary>

Shortest path from a source to every other node, for graphs with non-negative edge weights — a min-heap always expands whichever unfinalized node is currently closest. Signal: "minimum cost/time/distance" on a weighted graph.

- [ ] Network Delay Time — #743 — 🟡 Medium
- [ ] Path with Maximum Probability — #1514 — 🟡 Medium
- [ ] Cheapest Flights Within K Stops — #787 — 🟡 Medium
- [ ] Path With Minimum Effort — #1631 — 🟡 Medium
- [ ] Swim in Rising Water — #778 — 🔴 Hard
</details>

<details>
<summary><strong>Dynamic Programming</strong> — 0/35 ⬜ (the largest pattern in the plan)</summary>

Breaking a problem into overlapping subproblems, solving each exactly once, and reusing the result — via memoization (top-down) or tabulation (bottom-up) — instead of recomputing it from scratch. Signal: "minimum/maximum number of ways," "can you reach/make exactly X," optimization over a sequence or grid.

**1D DP** (14)
- [ ] Climbing Stairs — #70 — 🟢 Easy
- [ ] Min Cost Climbing Stairs — #746 — 🟢 Easy
- [ ] House Robber — #198 — 🟡 Medium
- [ ] House Robber II — #213 — 🟡 Medium
- [ ] Decode Ways — #91 — 🟡 Medium
- [ ] Maximum Product Subarray — #152 — 🟡 Medium
- [ ] Word Break — #139 — 🟡 Medium
- [ ] Coin Change — #322 — 🟡 Medium
- [ ] Coin Change II — #518 — 🟡 Medium
- [ ] Longest Increasing Subsequence — #300 — 🟡 Medium
- [ ] Partition Equal Subset Sum — #416 — 🟡 Medium
- [ ] Target Sum — #494 — 🟡 Medium
- [ ] Perfect Squares — #279 — 🟡 Medium
- [ ] Word Break II — #140 — 🔴 Hard

**Grid (2D) DP** (4)
- [ ] Unique Paths — #62 — 🟡 Medium
- [ ] Unique Paths II — #63 — 🟡 Medium
- [ ] Minimum Path Sum — #64 — 🟡 Medium
- [ ] Maximal Square — #221 — 🟡 Medium

**String DP** (9)
- [ ] Longest Common Subsequence — #1143 — 🟡 Medium
- [ ] Edit Distance — #72 — 🟡 Medium
- [ ] Longest Palindromic Substring — #5 — 🟡 Medium
- [ ] Palindromic Substrings — #647 — 🟡 Medium
- [ ] Longest Palindromic Subsequence — #516 — 🟡 Medium
- [ ] Interleaving String — #97 — 🟡 Medium
- [ ] Distinct Subsequences — #115 — 🔴 Hard
- [ ] Wildcard Matching — #44 — 🔴 Hard
- [ ] Regular Expression Matching — #10 — 🔴 Hard

**Interval DP** (2)
- [ ] Burst Balloons — #312 — 🔴 Hard
- [ ] Minimum Insertion Steps to Make a String Palindrome — #1312 — 🟡 Medium

**State Machine DP** (4)
- [ ] Best Time to Buy and Sell Stock with Cooldown — #309 — 🟡 Medium
- [ ] Best Time to Buy and Sell Stock with Transaction Fee — #714 — 🟡 Medium
- [ ] Best Time to Buy and Sell Stock III — #123 — 🔴 Hard
- [ ] Best Time to Buy and Sell Stock IV — #188 — 🔴 Hard

**Tree DP** (2)
- [ ] House Robber III — #337 — 🟡 Medium
- [ ] Binary Tree Maximum Path Sum — #124 — 🔴 Hard
</details>

<details>
<summary><strong>Bit Manipulation</strong> — 0/10 ⬜</summary>

Working directly with a number's binary representation (`& | ^ ~ << >> >>>`). Signal: "without extra space," "appears once," anything framed around binary representation.

- [ ] Single Number — #136 — 🟢 Easy
- [ ] Number of 1 Bits — #191 — 🟢 Easy
- [ ] Power of Two — #231 — 🟢 Easy
- [ ] Counting Bits — #338 — 🟢 Easy
- [ ] Missing Number — #268 — 🟢 Easy
- [ ] Reverse Bits — #190 — 🟢 Easy
- [ ] Single Number II — #137 — 🟡 Medium
- [ ] Single Number III — #260 — 🟡 Medium
- [ ] Sum of Two Integers — #371 — 🟡 Medium
- [ ] Maximum XOR of Two Numbers in an Array — #421 — 🟡 Medium *(shared with Tries)*
</details>

<details>
<summary><strong>Segment Trees</strong> — 0/2 ⬜</summary>

A binary tree where each node stores an aggregate (sum/min/max) over a range. O(log n) for both point updates and range queries. Deliberately kept light here — real exposure to a rare-but-real interview topic, not exhaustive coverage.

- [ ] Range Sum Query - Mutable — #307 — 🟡 Medium
- [ ] Count of Smaller Numbers After Self — #315 — 🔴 Hard
</details>

<details>
<summary><strong>Sorting, From Scratch</strong> — ⬜</summary>

`Collections.sort()`/`Arrays.sort()` get used throughout the plan without ever implementing the algorithm underneath — this closes that gap.

- [ ] Merge Sort — implemented from scratch, verified against `Arrays.sort()`
- [ ] Quicksort — implemented from scratch, verified against `Arrays.sort()`
- [ ] Kth Largest Element in an Array — #215 — 🟡 Medium — via Quickselect *(revision — first solved with a heap, under Heaps)*
</details>

<details>
<summary><strong>SQL Practice Track</strong> — 0/10 ⬜</summary>

Many SDE-2 loops include a SQL screening round, separate from the algorithmic rounds. Pattern-recognition practice for joins, aggregations, and window functions, using LeetCode's SQL problem set.

- [ ] Second Highest Salary — #176 — 🟡 Medium
- [ ] Department Highest Salary — #184 — 🟡 Medium
- [ ] Duplicate Emails — #182 — 🟢 Easy
- [ ] Rising Temperature — #197 — 🟢 Easy
- [ ] Employees Earning More Than Their Managers — #181 — 🟢 Easy
- [ ] Nth Highest Salary — #177 — 🟡 Medium
- [ ] Consecutive Numbers — #180 — 🟡 Medium
- [ ] Trips and Users — #262 — 🔴 Hard
- [ ] Exchange Seats — #626 — 🟡 Medium
- [ ] Department Top Three Salaries — #185 — 🔴 Hard
</details>

## Stack

- Java 21
- IntelliJ IDEA

## Related

- [`java-handbook`](https://github.com/srisuryakumarm/java-handbook) — Core Java, Collections, and Concurrency reference
- [`lld-patterns-java`](https://github.com/srisuryakumarm/lld-patterns-java) — Low-Level Design systems
