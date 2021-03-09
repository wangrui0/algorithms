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

  public int countSegments(String s) {
    s = s.trim();
    if (s == null || s.length() == 0) {
      return 0;
    }
    return s.split("\\s+").length;
  }

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
