package org.leetcode.shunxu.ch450;

/**
 * <p>434. 字符串中的单词数
 *
 * <p>统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * <p>请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * <p> 示例:
 *
 * <p>输入: "Hello, my name is John"
 * <p>输出: 5
 * <p>解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *
 * <p>https://leetcode-cn.com/problems/number-of-segments-in-a-string/
 *
 * @author: wangrui
 * @date: 2021/3/4
 */
public class Ch434NumberOfSegmentsInAString {

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度 :O(n)。
   *
   * <p> 这里用到的内置函数（无论是 Java 还是 Python）的时间复杂度或为 O(n)，或为 O(1) ，故整个算法可以在线性复杂度内完成。
   *
   * <p>空间复杂度 : O(n)。
   *
   * <p>     split 函数 (不管哪种语言) 返回长度为 O(n) 的数组/列表，故算法使用线性的额外空间
   *
   * @param s
   * @return
   */
  public int countSegments(String s) {
    s = s.trim();
    if (s == null || s.length() == 0) {
      return 0;
    }
    return s.split("\\s+").length;
  }

  /**
   * 复杂度分析
   *
   *     时间复杂度 : O(n)。
   *
   *     对每个下标进行常数时间的检测。
   *
   *     空间复杂度 : O(1)。
   *
   *     只使用了额外的几个整数，因此使用的空间为常数。
   *
   * @param s
   * @return
   */
  public int countSegments2(String s) {
    s = s.trim();
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (i == 0 || s.charAt(i) != ' ' && s.charAt(i - 1) == ' ') {
        count++;
      }
    }
    return count;
  }
}
