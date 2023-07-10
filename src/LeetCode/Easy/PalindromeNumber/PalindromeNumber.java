/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * Example 1:
 * <p>
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 * <p>
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * Constraints:
 * <p>
 * -231 <= x <= 231 - 1
 * <p>
 * Follow up: Could you solve it without converting the integer to a string?
 */

package LeetCode.Easy.PalindromeNumber;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(Solution.isPalindrome(-12));
    }
}

class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int index = 0;
        for (int i = x; i > 0; i /= 10) {
            index++;
        }
        int rightIndex = 1;
        for (int leftIndex = index; leftIndex > index / 2; leftIndex--) {
            if (!check(x, leftIndex, rightIndex)) {
                return false;
            }
            rightIndex++;
        }
        return true;
    }

    private static boolean check (int x, int leftIndex, int rightIndex) {
        int left = x / ((int) Math.pow(10, leftIndex - 1)) % 10;
        int right = x % ((int) Math.pow(10, rightIndex)) / ((int) Math.pow(10, rightIndex - 1));
        return left == right;
    }
}
