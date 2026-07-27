/**
* ============================================================
* Problem    : 242. Valid Anagram
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Strings, Hash Table
* Pattern    : Hashing
*
* Link       : https://leetcode.com/problems/valid-anagram
* ============================================================
*/

/*
Intuition


*/

/*
Approach 1
Sorting



Time: O(n log n)
Space: O(n)
*/

/*
Approach 2
Frequency Counting



Time: O(n)
Space: O(1)
*/

package hashing;

public class P242ValidAnagram{
    public static void main(String[] args) {}

    //Sorting
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    //Frequency Counting
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}