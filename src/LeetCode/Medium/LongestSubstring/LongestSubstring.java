/**
 * Given a string s, find the length of the longest
 * substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
package LeetCode.Medium.LongestSubstring;

import java.util.*;

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(Solution.lengthOfLongestSubstring("ohvhjdml"));
    }
}

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        char[] string = s.toCharArray();
        LinkedHashSet<Character> longestLocalSubstring = new LinkedHashSet<>();
        List<Set<Character>> longestSubstring = new ArrayList<>();
        for (int i = 0; i < string.length; i++) {
            System.out.println(string[i]);
            longestLocalSubstring.add(string[i]);
            for (int j = i + 1; j < string.length; j++) {
                if (!longestLocalSubstring.contains(string[j])) {
                    longestLocalSubstring.add(string[j]);
                } else {
                    break;
                }
            }
            longestSubstring.add(new LinkedHashSet<>(longestLocalSubstring));
            longestLocalSubstring.clear();
            System.out.println(longestSubstring);

        }
        int max = 0;
        for (Set<Character> set : longestSubstring) {
            System.out.println(set);
            if (max < set.size()) {
                max = set.size();
            }
        }
        return max;
    }
}