package org.company.meituan.algorithm;

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
 * <p>    0 <= s.length <= 5 *<p>104
 * <p>    s 由英文字母、数字、符号和空格组成
 *
 * <p>通过次数974,384
 * <p>提交次数2,628,582
 * <p>请问您在哪类招聘中遇到此题？
 * <p>|3. 无重复字符的最长子串|1|https://leetcode-cn.com/problems/longest-substring-without-repeating-characters|
 * <p>@author: wangrui
 * <p>@date: 2021/5/6
 */
public class Ch007LongestSubstringWithoutRepeatingCharacters无重复字符的最长子串 {

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring_self("pwwkew"));
  }

  public static int lengthOfLongestSubstring_self(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    Character leftC = s.charAt(0);
    int left = 0;
    Set<Character> set = new HashSet<>();
    int max = 0;
    for (int i = 0; i < s.length(); ) {
      Character c = s.charAt(i);
      if (set.contains(c)) {
        max = Math.max(max, set.size());
        set.remove(leftC);
        left = left + 1;
        leftC = s.charAt(left);
      } else {
        set.add(c);
        i++;
      }
    }
    return Math.max(max, set.size());
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(N)，其中 N 是字符串的长度。左指针和右指针分别会遍历整个字符串一次。
   *
   * <p> 空间复杂度：O(∣Σ∣)，其中 Σ 表示字符集（即字符串中可以出现的字符），|∣Σ∣ 表示字符集的大小。在本题中没有明确说明字符集，因此可以默认为所有 ASCII 码在 [0,128) 内的字符，即
   * ∣Σ∣=128。我们需要用到哈希集合来存储出现过的字符，而字符最多有 ∣Σ∣ 个，因此空间复杂度为 O(∣Σ∣)。
   *
   * @param s
   * @return
   */
  public int lengthOfLongestSubstring_2(String s) {
    // 哈希集合，记录每个字符是否出现过
    Set<Character> occ = new HashSet<Character>();
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


}
