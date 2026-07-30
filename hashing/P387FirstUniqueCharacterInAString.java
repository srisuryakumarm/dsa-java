/**
* ============================================================
* Problem    : 387. First Unique Character in a String
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Strings, Arrays, Hash Table
* Pattern    : Hashing
*
* Link       : https://leetcode.com/problems/first-unique-character-in-a-string/
* ============================================================
*/

/*
Intuition

The first unique character is the first character whose frequency is exactly
one.

The idea is to first count the frequency of every character and then traverse
the string again to find the first character with a frequency of one.
*/

/*
Approach 1

Use a frequency array to count the occurrences of each character in the string.

Traverse the string again and return the index of the first character whose
frequency is one.

If no such character exists, return -1.

Time: O(n)
Space: O(1)
*/

package hashing;

public class P387FirstUniqueCharacterInaString{

    //Frequency Counting
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            freq[c - 'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            if(freq[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}