/**
* ============================================================
* Problem    : 49. Group Anagrams
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Strings, Arrays, Hash Table
* Pattern    : Hashing
*
* Link       : https://leetcode.com/problems/group-anagrams
* ============================================================
*/

/*
Intuition

Two strings are anagrams if they contain the same characters with the same
frequency.

The idea is to generate a unique key for every string such that all anagrams
produce the same key. Strings with the same key are grouped together using a
HashMap.
*/

/*
Approach 1
Sorting & HashMap

Sort the characters of every string and use the sorted string as the key in a
HashMap.

Since all anagrams produce the same sorted string, they are grouped under the
same key.

Time: O(n × k log k)
Space: O(n × k)
*/

/*
Approach 2
Frequency Counting & HashMap

Count the frequency of each character in the string and build a unique key
using those frequencies.

Since all anagrams have the same character frequencies, they generate the same
key and are grouped together in the HashMap.

Time: O(n × k)
Space: O(n × k)
*/

package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P049GroupAnagrams{
    public static void main(String[] args){}

    //BruteForce Sorting & HashMap
    public List<List<String>> groupAnagramsSorting(String[] strs){
         Map<String, List> map = new HashMap<>();
         for(String s: strs){
             char[] c = s.toCharArray();
             Arrays.sort(c);
             String key = new String(c);
             map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
         }
         return new ArrayList(map.values());
     }

    // Optimised Frequency Counting & HashMap
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> map = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int c : count) {
                sb.append("#");
                sb.append(c);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}