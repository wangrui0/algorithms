package org.leetcode.shunxu.ch400;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>389. 找不同
 *
 * <p>给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * <p>字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * <p>请找出在 t 中被添加的字母。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：s = "abcd", t = "abcde"
 * <p>输出："e"
 * <p>解释：'e' 是那个被添加的字母。
 *
 * <p>示例 2：
 *
 * <p>输入：s = "", t = "y"
 * <p>输出："y"
 *
 * <p>示例 3：
 *
 * <p>输入：s = "a", t = "aa"
 * <p>输出："a"
 *
 * <p>示例 4：
 *
 * <p>输入：s = "ae", t = "aea"
 * <p>输出："a"
 *
 *
 *
 * <p>提示：
 *
 * <p>    0 <= s.length <= 1000
 * <p>    t.length == s.length + 1
 * <p>   s 和 t 只包含小写字母
 * <p> https://leetcode-cn.com/problems/find-the-difference/
 *
 * @author: wangrui
 * @date: 2021/3/3
 */
public class Ch389FindTheDifference {
  /**
   * self
   *
   * @param s
   * @param t
   * @return
   */
  public char findTheDifference(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }
    for (int i = 0; i < t.length(); i++) {
      Integer num = map.getOrDefault(t.charAt(i), 0);
      if (num == 0) {
        return t.charAt(i);
      }
    }
    return ' ';
  }

  /**
   * <p> 计数(很巧妙的方法)
   * <p>时间复杂度：O(N)，其中 N 为字符串的长度。
   *
   * <p>空间复杂度：O(∣Σ∣)，其中 Σ 是字符集，这道题中字符串只包含小写字母，∣Σ∣=26。需要使用数组对每个字符计数。
   *
   * @param s
   * @param t
   * @return
   */
  public char findTheDifference2(String s, String t) {
    int[] cnt = new int[26];
    for (int i = 0; i < s.length(); ++i) {
      char ch = s.charAt(i);
      cnt[ch - 'a']++;
    }
    for (int i = 0; i < t.length(); ++i) {
      char ch = t.charAt(i);
      cnt[ch - 'a']--;
      if (cnt[ch - 'a'] < 0) {
        return ch;
      }
    }
    return ' ';
  }

  /**
   * <p>求和
   * <p>
   * 复杂度分析
   * <p>
   * 时间复杂度：O(N)。
   * <p>
   * 空间复杂度：O(1)。
   *
   * @param s
   * @param t
   * @return
   */
  public char findTheDifference3(String s, String t) {
    int as = 0, at = 0;
    for (int i = 0; i < s.length(); ++i) {
      as += s.charAt(i);
    }
    for (int i = 0; i < t.length(); ++i) {
      at += t.charAt(i);
    }
    return (char) (at - as);
  }

  /**
   * <p>异或
   * 两个相同数的异或为0,0与另一个数的异或为另一个数
   * <p>
   * 复杂度分析
   * <p>
   * 时间复杂度：O(N)。
   * <p>
   * 空间复杂度：O(1)。
   *
   * @param s
   * @param t
   * @return
   */
  public char findTheDifference4(String s, String t) {
    int ret = 0;
    for (int i = 0; i < s.length(); ++i) {
      ret ^= s.charAt(i);
    }
    for (int i = 0; i < t.length(); ++i) {
      ret ^= t.charAt(i);
    }
    return (char) ret;
  }
}
