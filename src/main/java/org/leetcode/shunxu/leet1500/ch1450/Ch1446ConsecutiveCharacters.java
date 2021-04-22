package org.leetcode.shunxu.leet1500.ch1450;

/**
 * <p>1446. 连续字符
 *
 * <p>给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 *
 * <p>请你返回字符串的能量。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：s = "leetcode"
 * <p>输出：2
 * <p>解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 *
 * <p>示例 2：
 *
 * <p>输入：s = "abbcccddddeeeeedcba"
 * <p>输出：5
 * <p>解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 *
 * <p>示例 3：
 *
 * <p>输入：s = "triplepillooooow"
 * <p>输出：5
 *
 * <p>示例 4：
 *
 * <p>输入：s = "hooraaaaaaaaaaay"
 * <p>输出：11
 *
 * <p>示例 5：
 *
 * <p>输入：s = "tourist"
 * <p>输出：1
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= s.length <= 500
 * <p>    s 只包含小写英文字母。
 *
 * <p>通过次数10,425
 * <p>提交次数18,160
 * <p>请问您在哪类招聘中遇到此题？
 * <p>@author: wangrui
 * <p>@date: 2021/4/20
 */
public class Ch1446ConsecutiveCharacters {

  public int maxPower(String s) {
    int i = 0;
    int j = 1;
    int count = 1;
    int max = Integer.MIN_VALUE;
    if (s.length() == 1) {
      return 1;
    }
    boolean flag = true;
    while (j < s.length()) {
      //这一步为了解决j是最后一个字符
      if (s.charAt(i) == s.charAt(j)) {
        count++;
        if (j == s.length() - 1) {
          max = Math.max(count, max);
        }
        j++;
        //如果不相等,就让i指向j,j++
      } else {
        max = Math.max(count, max);
        i = j;
        j++;
        count = 1;
      }
    }

    return max;
  }

  public static int maxPower_self(String s) {
    int max = 1;
    int pre = 0;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) != s.charAt(i - 1)) {
        max = Math.max(max, i - pre);
        pre = i;
      } else if (i == s.length() - 1) {
        max = Math.max(max, i - pre + 1);
      }
    }
    return max;
  }


}
