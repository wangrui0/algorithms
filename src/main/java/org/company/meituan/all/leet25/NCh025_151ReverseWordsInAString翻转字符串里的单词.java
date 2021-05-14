package org.company.meituan.all.leet25;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * <p>151. 翻转字符串里的单词
 *
 * <p>给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * <p>说明：
 *
 * <p>    无空格字符构成一个 单词 。
 * <p>    输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>    如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入："the sky is blue"
 * <p>输出："blue is sky the"
 *
 * <p>示例 2：
 *
 * <p>输入："  hello world!  "
 * <p>输出："world! hello"
 * <p>解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * <p>示例 3：
 *
 * <p>输入："a good   example"
 * <p>输出："example good a"
 * <p>解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * <p>示例 4：
 *
 * <p>输入：s = "  Bob    Loves  Alice   "
 * <p>输出："Alice Loves Bob"
 *
 * <p>示例 5：
 *
 * <p>输入：s = "Alice does not even like bob"
 * <p>输出："bob like even not does Alice"
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= s.length <= 104
 * <p>    s 包含英文大小写字母、数字和空格 ' '
 * <p>    s 中 至少存在一个 单词
 *
 *
 *
 * <p>进阶：
 *
 * <p>    请尝试使用 O(1) 额外空间复杂度的原地解法。
 *
 * <p>通过次数135,481
 * <p>提交次数289,748
 * <p>https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * <p>@author: wangrui
 * <p>@date: 2021/5/10
 */
public class NCh025_151ReverseWordsInAString翻转字符串里的单词 {

  /**
   * <p>方法一：使用语言特性
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(N)，其中 N 为输入字符串的长度。
   *
   * <p>  空间复杂度：O(N)，用来存储字符串分割之后的结果
   *
   * @param s
   * @return
   */
  public String reverseWords_1(String s) {
    // 除去开头和末尾的空白字符
    s = s.trim();
    // 正则匹配连续的空白字符作为分隔符分割
    List<String> wordList = Arrays.asList(s.split("\\s+"));
    Collections.reverse(wordList);
    return String.join(" ", wordList);
  }

  /**
   * <p>方法二：
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(N)，其中 N 为输入字符串的长度。
   *
   * <p>  空间复杂度：O(N)，用来存储字符串分割之后的结果
   *
   * @param s
   * @return
   */
  public String reverseWords_2(String s) {
    StringBuilder sb = trimSpaces(s);

    // 翻转字符串
    reverse(sb, 0, sb.length() - 1);

    // 翻转每个单词
    reverseEachWord(sb);

    return sb.toString();
  }

  public StringBuilder trimSpaces(String s) {
    int left = 0, right = s.length() - 1;
    // 去掉字符串开头的空白字符
    while (left <= right && s.charAt(left) == ' ') {
      ++left;
    }

    // 去掉字符串末尾的空白字符
    while (left <= right && s.charAt(right) == ' ') {
      --right;
    }

    // 将字符串间多余的空白字符去除
    StringBuilder sb = new StringBuilder();
    while (left <= right) {
      char c = s.charAt(left);

      if (c != ' ') {
        sb.append(c);
      } else if (sb.charAt(sb.length() - 1) != ' ') {
        sb.append(c);
      }

      ++left;
    }
    return sb;
  }

  public void reverse(StringBuilder sb, int left, int right) {
    while (left < right) {
      char tmp = sb.charAt(left);
      sb.setCharAt(left++, sb.charAt(right));
      sb.setCharAt(right--, tmp);
    }
  }

  public void reverseEachWord(StringBuilder sb) {
    int n = sb.length();
    int start = 0, end = 0;

    while (start < n) {
      // 循环至单词的末尾
      while (end < n && sb.charAt(end) != ' ') {
        ++end;
      }
      // 翻转单词
      reverse(sb, start, end - 1);
      // 更新start，去找下一个单词
      start = end + 1;
      ++end;
    }
  }

  /**
   * 方法三：双端队列
   *
   * @param s
   * @return
   */
  public String reverseWords_3(String s) {
    int left = 0, right = s.length() - 1;
    // 去掉字符串开头的空白字符
    while (left <= right && s.charAt(left) == ' ') {
      ++left;
    }

    // 去掉字符串末尾的空白字符
    while (left <= right && s.charAt(right) == ' ') {
      --right;
    }

    Deque<String> d = new ArrayDeque<String>();
    StringBuilder word = new StringBuilder();

    while (left <= right) {
      char c = s.charAt(left);
      if ((word.length() != 0) && (c == ' ')) {
        // 将单词 push 到队列的头部
        d.offerFirst(word.toString());
        word.setLength(0);
      } else if (c != ' ') {
        word.append(c);
      }
      ++left;
    }
    d.offerFirst(word.toString());

    return String.join(" ", d);
  }


}
