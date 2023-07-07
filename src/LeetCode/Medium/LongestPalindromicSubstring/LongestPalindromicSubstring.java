/**
 * Given a string s, return the longest
 * palindromic
 * <p>
 * substring
 * in s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */

package LeetCode.Medium.LongestPalindromicSubstring;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(Solution.longestPalindrome("aaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaa"));
    }
}

class Solution {
    public static String longestPalindrome(String s) {
        for (int lenght = s.length(); lenght > 0; lenght--) {
            for (int start = 0; start <= s.length() - lenght; start++) {
                if (check(start, start + lenght, s)) {
                    return s.substring(start, start + lenght);
                }
            }
        }
        return "";
    }

    private static boolean check (int i, int j, String s) {
        int left = i;
        int right = j - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}