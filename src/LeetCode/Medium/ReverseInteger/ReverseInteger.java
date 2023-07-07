/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * Example 1:
 * <p>
 * Input: x = 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: x = -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: x = 120
 * Output: 21
 * <p>
 * Constraints:
 * <p>
 * -231 <= x <= 231 - 1
 */

package LeetCode.Medium.ReverseInteger;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(Solution.reverse(10));
    }
}

class Solution {
    public static int reverse(int x) {
        if (x < 10 && x > -10) {
            return x;
        }
        int abs = Math.abs(x);
        int operator = x / abs;
        char[] c = String.valueOf(abs).toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = c.length - 1; i >= 0; i--) {
            stringBuilder.append(c[i]);
        }
        int result;
        try {
            result = Integer.parseInt(String.valueOf(stringBuilder)) * operator;
            return result;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
