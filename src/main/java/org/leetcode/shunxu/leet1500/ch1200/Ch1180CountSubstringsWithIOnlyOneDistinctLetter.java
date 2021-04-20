package org.leetcode.shunxu.leet1500.ch1200;

import java.util.ArrayList;

/**
 * <p>LeetCode 1180. 统计只含单一字母的子串
 * <p>2020-07-13阅读 1530
 * <p>1. 题目
 * <p>给你一个字符串 S，返回只含 单一字母 的子串个数。
 *
 * <p>示例 1：
 * <p>输入： "aaaba"
 * <p>输出： 8
 * <p>解释：
 * <p>只含单一字母的子串分别是 "aaa"， "aa"， "a"， "b"。
 * <p>"aaa" 出现 1 次。
 * <p>"aa" 出现 2 次。
 * <p>"a" 出现 4 次。
 * <p>"b" 出现 1 次。
 * <p>所以答案是 1 + 2 + 4 + 1 = 8。
 *
 * <p>示例 2:
 * <p>输入： "aaaaaaaaaa"
 * <p>输出： 55
 * https://leetcode-cn.com/problems/count-substrings-with-only-one-distinct-letter/
 * <p>提示：
 * <p>1 <= S.length <= 1000
 * <p>S[i] 仅由小写英文字母组成。
 * <p>@author: wangrui
 * <p>@date: 2021/4/10
 */
public class Ch1180CountSubstringsWithIOnlyOneDistinctLetter {

  /**
   * 1、以不同字符为边界，找出所有单一字符的子串。比如："aabbaccc"的不同字符为边界的字串为：“aa”、“bb”、“a”、“ccc”;
   * <p>
   *   2、统计字串的组合数。例如："aaa"的组合有：“a”、“aa”、“aaa”。总共3个，可以发现规律是，组合数为长度n从 1 加到 n，即：n(n+1)/2
   * <p>
   *   3、累加所有字串的组合数即是最终答案。
   *
   * @param S
   * @return
   */
  public int countLetters(String S) {
    int sum = 0;
    int subStrLength = 0;
    int start = 0;
    int end = 0;
    char c = S.charAt(start);
    ArrayList<String> list = new ArrayList<>();
    while (true) {
      if (c == S.charAt(end)) {
        end++;
      } else {
        list.add(S.substring(start, end));  // 包含头不包含尾
        start = end;
        c = S.charAt(start);
      }
      if (end == S.length()) {
        list.add(S.substring(start, end));
        break;
      }
    }
    for (String s : list) {
      if (s.length() == 1) {
        sum++;
      } else {
        subStrLength = s.length();
        sum += subStrLength * (subStrLength + 1) / 2;
      }
    }
    return sum;
  }

  public int countLetters_2(String S) {
    int nums = 0;
    int len = S.length();
    for (int i = 0; i < len - 1; i++) {
      nums++;
      char x = S.charAt(i);
      for (int j = i + 1; j < len; j++) {
        if (S.charAt(j) == x) {
          nums++;
        } else {
          break;
        }
      }
    }
    nums++;
    return nums;
  }
}
