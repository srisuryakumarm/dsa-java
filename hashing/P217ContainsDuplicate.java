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


*/

/*
Approach 1
Scanning



Time: O(n²)
Space: O(1)
*/

/*
Approach 2
Sorting



Time: O(n log n)
Space: O(1)
*/

/*
Approach 3
Optimal using HashSet



Time: O(n)
Space: O(n)
*/

package hashing;

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