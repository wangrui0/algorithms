package org.leetcode.leet2000.ch1600;

/**
 * <p>1556. 千位分隔数
 *
 * <p>给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：n = 987
 * <p>输出："987"
 *
 * <p>示例 2：
 *
 * <p>输入：n = 1234
 * <p>输出："1.234"
 *
 * <p>示例 3：
 *
 * <p>输入：n = 123456789
 * <p>输出："123.456.789"
 *
 * <p>示例 4：
 *
 * <p>输入：n = 0
 * <p>输出："0"
 *
 *
 *
 * <p>提示：
 *
 * <p>    0 <= n < 2^31
 *
 * <p>通过次数8,394
 * <p>提交次数14,328
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/thousand-separator/
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1556ThousandSeparator {

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(logn)。
   * <p>   空间复杂度：O(logn)。
   *
   * @param n
   * @return
   */
  public String thousandSeparator(int n) {
    int count = 0;
    StringBuffer ans = new StringBuffer();
    do {
      int cur = n % 10;
      n /= 10;
      ans.append(cur);
      ++count;
      if (count % 3 == 0 && n != 0) {
        ans.append('.');
      }
    } while (n != 0);
    ans.reverse();
    return ans.toString();
  }

  public static String thousandSeparator_self(int n) {
    StringBuilder sb = new StringBuilder();
    int index = 1;
    while (n > 0 || index == 1) {
      int remainder = n % 10;
      n = n / 10;
      sb.append(remainder);
      if (index % 3 == 0 && n != 0) {
        sb.append(".");
      }
      index++;
    }
    return sb.reverse().toString();
  }

}
