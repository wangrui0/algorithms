package org.leetcode.easy;

/**
 * 171. Excel表列序号(26 进制转10 进制)
 * <p> 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * <p> 例如，
 *
 * <p>     A -> 1
 * <p>     B -> 2
 * <p>     C -> 3
 * <p>     ...
 * <p>     Z -> 26
 * <p>     AA -> 27
 * <p>     AB -> 28
 * <p>     ...
 * <p> 示例 1:
 *
 * <p> 输入: "A"
 * <p> 输出: 1
 * <p> 示例 2:
 *
 * <p> 输入: "AB"
 * <p> 输出: 28
 * <p> 示例 3:
 *
 * <p> 输入: "ZY"
 * <p> 输出: 701
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/12/12
 */
public class Ch0171ExcelSheetColumnNumber {

  public static void main(String[] args) {
    System.out.println(titleToNumber("A"));
    System.out.println(titleToNumber("AB"));
    System.out.println(titleToNumber("ZY"));
  }

  public static int titleToNumber(String s) {
    int result = 0;
    int length = s.length();
    for (int i = 0; i < length; i++) {
      char c = s.charAt(i);
      int num = c - 64;
      result += num * Math.pow(26, length - i - 1);

    }
    return result;
  }

  public int titleToNumber2(String s) {
    int ans = 0;
    for (int i = 0; i < s.length(); i++) {
      int num = s.charAt(i) - 'A' + 1;
      ans = ans * 26 + num;
    }
    return ans;
  }

}
