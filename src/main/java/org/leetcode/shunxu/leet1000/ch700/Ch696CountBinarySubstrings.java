package org.leetcode.shunxu.leet1000.ch700;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>696. 计数二进制子串
 * <p>给定一个字符串 s，计算具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是连续的。
 *
 * <p>重复出现的子串要计算它们出现的次数。
 *
 *
 *
 * <p>示例 1 :
 *
 * <p>输入: "00110011"
 * <p>输出: 6
 * <p>解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 *
 * <p>请注意，一些重复出现的子串要计算它们出现的次数。
 *
 * <p>另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * <p>示例 2 :
 *
 * <p>输入: "10101"
 * <p>输出: 4
 * <p>解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 *
 *
 * <p>提示：
 *
 * <p>s.length 在1到50,000之间。
 * <p>s 只包含“0”或“1”字符。
 * <p>通过次数44,935提交次数71,850
 * <p>在真实的面试中遇到过这道题？
 *
 * @Author: shenpei
 * @Date: 2021/3/18 11:35 下午
 */
public class Ch696CountBinarySubstrings {

  /**
   * 这个实现的时间复杂度和空间复杂度都是 O(n)。
   *
   * @param s
   * @return
   */
  public int countBinarySubstrings1(String s) {
    List<Integer> counts = new ArrayList<Integer>();
    int ptr = 0, n = s.length();
    while (ptr < n) {
      char c = s.charAt(ptr);
      int count = 0;
      while (ptr < n && s.charAt(ptr) == c) {
        ++ptr;
        ++count;
      }
      counts.add(count);
    }
    int ans = 0;
    for (int i = 1; i < counts.size(); ++i) {
      ans += Math.min(counts.get(i), counts.get(i - 1));
    }
    return ans;
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(n)。
   * <p> 空间复杂度：O(1)。
   *
   * @param s
   * @return
   */
  public static int countBinarySubstrings2(String s) {
    int ptr = 0, n = s.length(), last = 0, ans = 0;
    while (ptr < n) {
      char c = s.charAt(ptr);
      int count = 0;
      while (ptr < n && s.charAt(ptr) == c) {
        ++ptr;
        ++count;
      }
      ans += Math.min(count, last);
      last = count;
    }
    return ans;
  }
}
