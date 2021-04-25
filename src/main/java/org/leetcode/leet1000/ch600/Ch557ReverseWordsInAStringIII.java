package org.leetcode.leet1000.ch600;

/**
 * <p>557. 反转字符串中的单词 III
 * <p>给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *
 *
 * <p>示例：
 *
 * <p> 输入："Let's take LeetCode contest"
 * <p>输出："s'teL ekat edoCteeL tsetnoc"
 *
 *
 *
 * <p>提示：
 *
 * <p>在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * <p>https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 *
 * @Author: shenpei
 * @Date: 2021/3/15 8:08 下午
 */
public class Ch557ReverseWordsInAStringIII {

  /**
   * self
   *
   * @param s
   * @return
   */
  public String reverseWords(String s) {
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; ) {
      int start = i;
      while (i < chars.length && s.charAt(i) != ' ') {
        i++;
      }
      for (int j = i - 1; start < j; ) {
        char temp = chars[start];
        chars[start++] = chars[j];
        chars[j--] = temp;
      }
      while (i < chars.length && s.charAt(i) == ' ') {
        i++;
      }
    }
    return new String(chars);
  }

  /**
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(N)，其中 N 为字符串的长度。原字符串中的每个字符都会在 O(1) 的时间内放入新字符串中。
   *
   * <p>  空间复杂度：O(N)。我们开辟了与原字符串等大的空间。
   *
   * @param s
   * @return
   */
  public String reverseWords2(String s) {
    StringBuffer ret = new StringBuffer();
    int length = s.length();
    int i = 0;
    while (i < length) {
      int start = i;
      while (i < length && s.charAt(i) != ' ') {
        i++;
      }
      for (int p = start; p < i; p++) {
        ret.append(s.charAt(start + i - 1 - p));
      }
      while (i < length && s.charAt(i) == ' ') {
        i++;
        ret.append(' ');
      }
    }
    return ret.toString();
  }


}
