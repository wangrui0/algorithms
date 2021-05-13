package org.company.meituan.all.leet25;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>3. 无重复字符的最长子串
 *
 * <p>给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * <p>示例 1:
 *
 * <p>输入: s = "abcabcbb"
 * <p>输出: 3
 * <p>解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * <p>示例 2:
 *
 * <p>输入: s = "bbbbb"
 * <p>输出: 1
 * <p>解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * <p>示例 3:
 *
 * <p>输入: s = "pwwkew"
 * <p>输出: 3
 * <p>解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * <p>     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * <p>示例 4:
 *
 * <p>输入: s = ""
 * <p>输出: 0
 *
 *
 *
 * <p>提示：
 *
 * <p>    0 <= s.length <= 5 *104
 * <p>    s 由英文字母、数字、符号和空格组成
 *
 * <p>通过次数976,290
 * <p>提交次数2,633,118
 * <p>https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>@author: wangrui
 * <p>@date: 2021/5/7
 */
public class NKCh012_3LongestSubstringWithoutRepeatingCharacters无重复字符的最长子串 {

  public int lengthOfLongestSubstring(String s) {
    // 哈希集合，记录每个字符是否出现过
    Set<Character> occ = new HashSet<>();
    int n = s.length();
    // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
    int rk = -1, ans = 0;
    for (int i = 0; i < n; ++i) {
      if (i != 0) {
        // 左指针向右移动一格，移除一个字符
        occ.remove(s.charAt(i - 1));
      }
      while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
        // 不断地移动右指针
        occ.add(s.charAt(rk + 1));
        ++rk;
      }
      // 第 i 到 rk 个字符是一个极长的无重复字符子串
      ans = Math.max(ans, rk - i + 1);
    }
    return ans;
  }

  public int lengthOfLongestSubstring_2(String s) {
    int ans = 0, rp = -1;
    int length = s.length();
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      if (i != 0) {
        set.remove(s.charAt(i - 1));
      }
      while (rp + 1 < length && !set.contains(s.charAt(rp + 1))) {
        set.add(s.charAt(rp + 1));
        rp++;
      }
      ans = Math.max(ans, rp + 1 - i);
    }
    return ans;
  }
}
