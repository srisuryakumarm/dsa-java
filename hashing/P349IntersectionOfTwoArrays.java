/**
* ============================================================
* Problem    : 349. Intersection Of Two Arrays
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Arrays, Hash Table
* Pattern    : Hashing
*
* Link       : https://leetcode.com/problems/intersection-of-two-arrays/
* ============================================================
*/

/*
Intuition

The intersection contains only the unique elements that are present in both
arrays.

The idea is to store the elements of one array in a HashSet for fast lookups
and then check each element of the other array against it. Another HashSet is
used to store the unique common elements.
*/

/*
Approach 1

Store all the elements of the first array in a HashSet.

Traverse the second array and check whether each element exists in the first
HashSet. If it does, add it to another HashSet to ensure that only unique
common elements are stored.

Finally, convert the resulting HashSet into an array and return it.

Time: O(m + n)
Space: O(m + n)
*/

package hashing;

public class P349IntersectionOfTwoArrays{
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        int[] result = new int[set2.size()];
        int i = 0;
        for (int val : set2) {
            result[i++] = val;
        }
        return result;
    }
}