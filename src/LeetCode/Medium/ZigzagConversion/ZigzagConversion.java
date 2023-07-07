/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 * <p>
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 * <p>
 * Input: s = "A", numRows = 1
 * Output: "A"
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */

package LeetCode.Medium.ZigzagConversion;

public class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(Solution.convert("abcdefghijklmnopqr", 4));
        System.out.println(Solution.convert("PAYPALISHIRING", 3));
        System.out.println(Solution.convert("PAYPALISHIRING", 4));
        System.out.println(Solution.convert("A", 2));
    }
}


class Solution {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int step = 2 * numRows - 2;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i += step) {
            stringBuilder.append(s.charAt(i));
        }
        int localUpStep;
        int localDownStep;
        boolean isUp;
        for (int j = 1; j < numRows - 1; j++) {
            isUp = false;
            for (int k = j; k < s.length();) {
                stringBuilder.append(s.charAt(k));
                if (isUp) {
                    localUpStep = j * 2;
                    k += localUpStep;
                    isUp = false;
                } else {
                    localDownStep = 2 * (numRows - j) - 2;
                    k += localDownStep;
                    isUp = true;
                }
            }
        }
        for (int q = numRows - 1; q < s.length(); q += step) {
            stringBuilder.append(s.charAt(q));
        }
        return String.valueOf(stringBuilder);
    }
}


