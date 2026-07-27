/**
* ============================================================
* Problem    : 383. Ransom Note
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Strings, Hash Table
* Pattern    : Hashing
*
* Link       : https://leetcode.com/problems/ransom-note
* ============================================================
*/

/*
Intuition

To construct the ransom note, every character in the ransom note must be
available in the magazine with at least the same frequency.

The idea is to count the occurrences of each character in the magazine and
decrease the count while processing the ransom note.

If the count of any character becomes negative, the ransom note cannot be
constructed.
*/

/*
Approach 1
Frequency Counting

Create a frequency array to count the occurrences of each character in the
magazine.

Iterate through the ransom note and decrease the corresponding character count.

If the count of any character becomes negative, return false because the
required character is not available. Otherwise, return true after processing
all the characters.

Time: O(m + n)
Space: O(1)
*/

/*
Approach 2
Hash Map

Store the frequency of every character in the magazine using a HashMap.

Iterate through the ransom note and decrease the frequency of each character.

If a character is not present in the map or its frequency becomes zero before
it is needed, return false. Otherwise, return true after processing all the
characters.

Time: O(m + n)
Space: O(1) - Number of Distinct Character k <= 26
*/

package hashing;

import java.util.HashMap;
import java.util.Map;

public class P383RansomNote{
    public static void main(String[] args){}

    //Frequency Counting
    public boolean canConstructFrequency(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    //HashMap
    public boolean canConstructHashMap(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }
}