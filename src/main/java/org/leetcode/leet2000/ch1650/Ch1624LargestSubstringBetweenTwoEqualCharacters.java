package org.leetcode.leet2000.ch1650;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>1624. 两个相同字符之间的最长子字符串
 *
 * <p>给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 *
 * <p>子字符串 是字符串中的一个连续字符序列。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：s = "aa"
 * <p>输出：0
 * <p>解释：最优的子字符串是两个 'a' 之间的空子字符串。
 *
 * <p>示例 2：
 *
 * <p>输入：s = "abca"
 * <p>输出：2
 * <p>解释：最优的子字符串是 "bc" 。
 *
 * <p>示例 3：
 *
 * <p>输入：s = "cbzxy"
 * <p>输出：-1
 * <p>解释：s 中不存在出现出现两次的字符，所以返回 -1 。
 *
 * <p>示例 4：
 *
 * <p>输入：s = "cabbac"
 * <p>输出：4
 * <p>解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= s.length <= 300
 * <p>    s 只含小写英文字母
 *
 * <p>通过次数9,223
 * <p>提交次数14,752
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/largest-substring-between-two-equal-characters/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 7:27 下午
 */
public class Ch1624LargestSubstringBetweenTwoEqualCharacters {

  public static int maxLengthBetweenEqualCharacters_1(String s) {
    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j < s.length(); j++) {
        if (s.charAt(i) == s.charAt(j)) {
          ans = Math.max(ans, j - i - 1);
        }
      }
    }
    return ans == Integer.MIN_VALUE ? -1 : ans;
  }

  public static int maxLengthBetweenEqualCharacters_2(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), i);
    }
    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < s.length(); i++) {
      Integer index = map.get(s.charAt(i));
      if (index != i) {
        ans = Math.max(ans, index - i - 1);
      }
    }
    return ans == Integer.MIN_VALUE ? -1 : ans;
  }
}
