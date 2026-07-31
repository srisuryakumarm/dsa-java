/**
* ============================================================
* Problem    : 290. Word Pattern
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : String, Hash Table
* Pattern    : Hashing
*
* Link       : https://leetcode.com/problems/word-pattern/
* ============================================================
*/

/*
Intuition

A valid word pattern requires a one-to-one mapping between each character in
the pattern and each word in the string.

The idea is to maintain the mapping in both directions while traversing the
pattern and the words simultaneously. If a conflicting mapping is found, the
pattern is invalid.
*/

/*
Approach 1

Split the input string into individual words.

Use one HashMap to store the mapping from pattern characters to words and
another HashMap to store the reverse mapping from words to pattern characters.

For each character-word pair, verify that both mappings remain consistent.
If either mapping conflicts with a previously stored mapping, return false.

Time: O(n)
Space: O(n)
*/

package hashing;

public class P290WordPattern{
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<Character, String> pMap = new HashMap<>();
        Map<String, Character> wMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (pMap.containsKey(c) && !word.equals(pMap.get(c))) {
                return false;
            }
            if (wMap.containsKey(word) && wMap.get(word) != c) {
                return false;
            }
            pMap.put(c, word);
            wMap.put(word, c);
        }
        return true;
    }
}