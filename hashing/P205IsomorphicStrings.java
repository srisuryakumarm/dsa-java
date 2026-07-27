/**
* ============================================================
* Problem    : 205. Isomorphic Strings
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : Strings, Hash Table
* Pattern    : Hashing
*
* Link       : https://leetcode.com/problems/isomorphic-strings
* ============================================================
*/

/*
Intuition

Two strings are isomorphic if every character in the first string maps to
exactly one character in the second string, and no two different characters
map to the same character.

The idea is to maintain a consistent mapping while traversing both strings
simultaneously. If a conflicting mapping is found, the strings are not
isomorphic.
*/

/*
Approach 1
Two HashMaps

Use two HashMaps to maintain the mapping in both directions.

The first map stores the mapping from the first string to the second string,
while the second map stores the reverse mapping.

For each pair of characters, verify that both mappings remain consistent.
If either mapping conflicts with a previously stored mapping, return false.

Time: O(n)
Space: O(n)
*/

/*
Approach 2
One HashMap & HashSet

Use a HashMap to store the mapping from the first string to the second string.

Use a HashSet to keep track of the characters that have already been mapped in
the second string.

For each pair of characters, verify that the existing mapping is consistent.
If no mapping exists, ensure that the target character has not already been
mapped before creating a new mapping.

Time: O(n)
Space: O(n)
*/

package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P205IsomorphicStrings {
    public static void main(String[] args) {}

    // Two HashMaps
    public boolean isIsomorphicMaps(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> STMap = new HashMap<>();
        Map<Character, Character> TSMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (STMap.containsKey(sc) && STMap.get(sc) != tc) {
                return false;
            }
            if (TSMap.containsKey(tc) && TSMap.get(tc) != sc) {
                return false;
            }
            STMap.put(sc, tc);
            TSMap.put(tc, sc);
        }
        return true;
    }

    // One HashMap & HashSet
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (map.containsKey(sc)) {
                if (map.get(sc) != tc) {
                    return false;
                }
            } else {
                if (set.contains(tc)) {
                    return false;
                }
                map.put(sc, tc);
                set.add(tc);
            }
        }
        return true;
    }
}