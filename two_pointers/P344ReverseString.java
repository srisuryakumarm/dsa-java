/**
* ============================================================
* Problem    : 344. Reverse String
* Platform   : LeetCode
* Difficulty : Easy
*
* Topics     : String, Two Pointers
* Pattern    : Two Pointers
*
* Link       : https://leetcode.com/problems/reverse-string
* ============================================================
*/

/*
Intuition

Reversing a string requires swapping the characters at the beginning and the
end while moving towards the center.

Using two pointers allows the string to be reversed in place without requiring
any additional data structure.
*/

/*
Approach 1
Two Pointers

Initialize one pointer at the beginning of the array and another at the end.

Swap the characters at both pointers, then move the left pointer forward and
the right pointer backward.

Continue until the two pointers meet or cross each other.

Time: O(n)
Space: O(1)
*/

package two_pointers;

public class P344ReverseString {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}