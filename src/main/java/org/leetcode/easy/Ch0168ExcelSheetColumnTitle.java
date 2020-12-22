package org.leetcode.easy;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如，
 * <p>
 * <p>     1 -> A
 * <p>     2 -> B
 * <p>     3 -> C
 * <p>     ...
 * <p>     26 -> Z
 * <p>     27 -> AA
 * <p>     28 -> AB
 * <p>     ...
 * <p> 示例 1:
 *
 * <p> 输入: 1
 * <p> 输出: "A"
 * <p> 示例 2:
 *
 * <p> 输入: 28
 * <p> 输出: "AB"
 * <p> 示例 3:
 *
 * <p> 输入: 701
 * <p> 输出: "ZY"
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 168. Excel表列名称
 *
 * @author: wangrui
 * @date: 2020/12/12
 */
public class Ch0168ExcelSheetColumnTitle {

  public static void main(String[] args) {
//    System.out.println(convertToTitle(1));
//    System.out.println(convertToTitle(28));
    System.out.println(convertToTitle(701));
  }

  /**
   * 10 进制转25 进制的变形版本
   *
   * @param n
   * @return
   */
  public static String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder();
    int yuShu;
    while (n >= 1) {
      yuShu = n % 26;
      n = n / 26;
      if (yuShu != 0) {
        sb.append((char) (yuShu + 64));
      } else {
        sb.append('Z');
        n = n - 1;
      }
    }
    return sb.reverse().toString();
  }
}
