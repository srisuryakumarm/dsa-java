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

Two strings are anagrams if they contain the same characters with the same
frequency.

The idea is to either compare the characters after sorting both strings or
count the frequency of each character and verify that the frequencies match.
*/

/*
Approach 1
Sorting

Convert both strings into character arrays and sort them.

If the sorted arrays are identical, the strings are anagrams. Otherwise, they
are not.

Time: O(n log n)
Space: O(n)
*/

/*
Approach 2
Frequency Counting

Use a frequency array to count the occurrences of each character.

Increase the count for each character in the first string and decrease the
count for the corresponding character in the second string.

If every value in the frequency array is zero after processing both strings,
the strings are anagrams.

Time: O(n)
Space: O(1)
*/

package hashing;

public class P242ValidAnagram{
    public static void main(String[] args) {}

    //Sorting
    public boolean isAnagramSorting(String s, String t) {
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