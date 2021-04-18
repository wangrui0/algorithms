package org.leetcode.shunxu.ch1350;

/**
 * <p>1323. 6 和 9 组成的最大数字
 *
 * <p>给你一个仅由数字 6 和 9 组成的正整数 num。
 *
 * <p>你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
 *
 * <p>请返回你可以得到的最大数字。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：num = 9669
 * <p>输出：9969
 * <p>解释：
 * <p>改变第一位数字可以得到 6669 。
 * <p>改变第二位数字可以得到 9969 。
 * <p>改变第三位数字可以得到 9699 。
 * <p>改变第四位数字可以得到 9666 。
 * <p>其中最大的数字是 9969 。
 *
 * <p>示例 2：
 *
 * <p>输入：num = 9996
 * <p>输出：9999
 * <p>解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
 *
 * <p>示例 3：
 *
 * <p>输入：num = 9999
 * <p>输出：9999
 * <p>解释：无需改变就已经是最大的数字了。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= num <= 10^4
 * <p>    num 每一位上的数字都是 6 或者 9 。
 *
 * <p>通过次数20,976
 * <p>提交次数27,907
 * <p>https://leetcode-cn.com/problems/maximum-69-number/
 * <p>@author: wangrui
 * <p>@date: 2021/4/12
 */
public class Ch1323Maximum69Number {

  public static void main(String[] args) {
    System.out.println(maximum69Number(9996));
  }

  public static int maximum69Number(int num) {
    char[] chars = String.valueOf(num).toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '6') {
        chars[i] = '9';
        break;
      }
    }
    return Integer.parseInt(new String(chars));
  }

  public int maximum69Number_2(int num) {
    StringBuffer s = new StringBuffer(Integer.toString(num));
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '6') {
        s.deleteCharAt(i);
        s.insert(i, '9');
        break;
      }
    }
    return Integer.parseInt(s.toString());
  }

}
