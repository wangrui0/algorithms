package org.leetcode.leet2000.ch1550;

import java.util.Stack;

/**
 * <p>1544. 整理字符串
 *
 * <p>给你一个由大小写英文字母组成的字符串 s 。
 *
 * <p>一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:
 *
 * <p>    若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。
 * <p>    若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。
 *
 * <p>请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
 *
 * <p>请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
 *
 * <p>注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：s = "leEeetcode"
 * <p>输出："leetcode"
 * <p>解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode" 。
 *
 * <p>示例 2：
 *
 * <p>输入：s = "abBAcC"
 * <p>输出：""
 * <p>解释：存在多种不同情况，但所有的情况都会导致相同的结果。例如：
 * <p>"abBAcC" --> "aAcC" --> "cC" --> ""
 * <p>"abBAcC" --> "abBA" --> "aA" --> ""
 *
 * <p>示例 3：
 *
 * <p>输入：s = "s"
 * <p>输出："s"
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= s.length <= 100
 * <p>    s 只包含小写和大写英文字母
 *
 * <p>通过次数16,147
 * <p>提交次数30,444
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/make-the-string-great/
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1544MakeTheStringGreate {

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(N)，其中 N 为字符串 s 的长度。我们要遍历字符串 s 的每一个字符，而对每个字符都只需要常数时间的操作。
   *
   * <p>  空间复杂度：O(N) 或 O(1)，取决于使用语言的字符串类型是否是可修改的。
   *
   * @param s
   * @return
   */
  public String makeGood(String s) {
    StringBuffer ret = new StringBuffer();
    int retIndex = -1;
    int length = s.length();
    for (int i = 0; i < length; i++) {
      char ch = s.charAt(i);
      if (ret.length() > 0 && Character.toLowerCase(ret.charAt(retIndex)) == Character.toLowerCase(ch)
          && ret.charAt(retIndex) != ch) {
        ret.deleteCharAt(retIndex);
        retIndex--;
      } else {
        ret.append(ch);
        retIndex++;
      }
    }
    return ret.toString();
  }

  public static String makeGood_self(String s) {
    StringBuffer sb = new StringBuffer();
    int lastIndex = -1;
    for (int i = 0; i < s.length(); i++) {
      if (lastIndex != -1 && sb.charAt(lastIndex) != s.charAt(i)
          && Character.toLowerCase(sb.charAt(lastIndex)) == Character.toLowerCase(s.charAt(i))) {
        sb.deleteCharAt(lastIndex);
        lastIndex--;
      } else {
        sb.append(s.charAt(i));
        lastIndex++;
      }
    }
    return sb.toString();
  }

  public static String makeGood_self2(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      Character peek = stack.isEmpty() ? null : stack.peek();
      if (peek != null && !peek.equals(s.charAt(i)) && Character.toLowerCase(peek) == Character
          .toLowerCase(s.charAt(i))) {
        stack.pop();
      } else {
        stack.push(s.charAt(i));
      }
    }
    char[] chars = new char[stack.size()];
    int index = 0;
    while (!stack.isEmpty()) {
      chars[stack.size() - 1 - index] = stack.pop();
    }
    return new String(chars);

  }


}
