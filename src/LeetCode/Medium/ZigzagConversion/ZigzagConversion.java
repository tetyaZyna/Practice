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
        StringBuilder stringBuilder = new StringBuilder();
        int step;
        boolean isUp;
        for (int j = 0; j < numRows; j++) {
            isUp = false;
            for (int k = j; k < s.length();) {
                stringBuilder.append(s.charAt(k));
                if (isUp) {
                    step = j * 2;
                    k += step;
                    isUp = false;
                } else {
                    if (j > 0 && j < numRows - 1) {
                        step = 2 * (numRows - j) - 2;
                        isUp = true;
                    } else {
                        step = 2 * numRows - 2;
                    }
                    k += step;
                }
            }
        }
        return String.valueOf(stringBuilder);
    }
}


