package org.leetcode.shunxu.lcp;

/**
 * <p>LCP 17. 速算机器人
 *
 * <p>小扣在秋日市集发现了一款速算机器人。店家对机器人说出两个数字（记作 x 和 y），请小扣说出计算指令：
 *
 * <p>    "A" 运算：使 x = 2 *x + y；
 * <p>    "B" 运算：使 y = 2 *y + x。
 *
 * <p>在本次游戏中，店家说出的数字为 x = 1 和 y = 0，小扣说出的计算指令记作仅由大写字母 A、B 组成的字符串 s，字符串中字符的顺序表示计算顺序，请返回最终 x 与 y 的和为多少。
 *
 * <p>示例 1：
 *
 * <p>    输入：s = "AB"
 *
 * <p>    输出：4
 *
 * <p>    解释：
 * <p>    经过一次 A 运算后，x = 2, y = 0。
 * <p>    再经过一次 B 运算，x = 2, y = 2。
 * <p>    最终 x 与 y 之和为 4。
 *
 * <p>提示：
 *
 * <p>    0 <= s.length <= 10
 * <p>    s 由 'A' 和 'B' 组成
 *
 * <p>通过次数18,240
 * <p>提交次数22,807
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/31
 */
public class LCP017NGK0Fy {

  int x = 1;
  int y = 0;

  public int calculate(String s) {
    if (s.length() == 0) {
      return 1;
    }
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'A') {
        x = 2 * x + y;
      } else if (s.charAt(i) == 'B') {
        y = 2 * y + x;
      }
    }
    return x + y;
  }

  public int calculate_2(String s) {
    return 1 << s.length();
  }
}
