/**
* ============================================================
* Problem    : 217. Contains Duplicate
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Arrays, Hash Table
* Pattern    : Hashing
*
* Link       : https://leetcode.com/problems/contains-duplicate
* ============================================================
*/

/*
Intuition

The array contains a duplicate if the same element appears more than once.

The idea is to determine whether an element has already been encountered.
This can be done by comparing every pair of elements, sorting the array to
bring duplicates together, or using a HashSet to track previously seen
elements.
*/

/*
Approach 1
Scanning

Compare every element with all the remaining elements in the array.

If any two elements are equal, return true. Otherwise, return false after
checking all possible pairs.

Time: O(n²)
Space: O(1)
*/

/*
Approach 2
Sorting

Sort the array so that duplicate elements become adjacent.

Traverse the sorted array and compare each element with the next one.
If two adjacent elements are equal, return true. Otherwise, return false.

Time: O(n log n)
Space: O(1)
*/

/*
Approach 3
Optimal using HashSet

Traverse the array while storing each element in a HashSet.

If an element already exists in the HashSet, return true because a duplicate
has been found.

If the traversal completes without finding a duplicate, return false.

Time: O(n)
Space: O(n)
*/

package hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P217ContainsDuplicate {
    public static void main(String[] args) { }

    //Brute Force Scanning
    public boolean containsDuplicateScanning(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    //Sorting
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1]){
                return true;
            }
        }
        return false;
    }

    //HashSet
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}