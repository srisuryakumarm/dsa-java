/**
* ============================================================
* Problem    : 278. First Bad Version
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Binary Search
* Pattern    : Binary Search
*
* Link       : https://leetcode.com/problems/first-bad-version
* ============================================================
*/

/*
Intuition

The versions have a monotonic property: once a version is bad, every version
after it is also bad.

Therefore, we can use binary search to find the first bad version.

If the middle version is bad, the first bad version is at `m` or somewhere
before it, so move the right pointer to `m`.

If the middle version is good, the first bad version must be after `m`, so move
the left pointer to `m + 1`.
*/

/*
Approach
Binary Search

Maintain a search range from version `1` to version `n`.

Calculate the middle version and use `isBadVersion(m)` to determine which half
contains the first bad version.

- If `m` is bad, keep `m` in the search range because it could be the first bad
  version.
- If `m` is good, discard `m` and everything before it.

Continue until `left` and `right` point to the same version.

That version is the first bad version.

Time: O(log n)
Space: O(1)
*/

package binary_search;

public class P278FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}