package org.leetcode.leet2000.ch1650;

import java.util.Stack;

/**
 * <p>1614. 括号的最大嵌套深度
 *
 * <p>如果字符串满足以下条件之一，则可以称之为 有效括号字符串（valid parentheses string，可以简写为 VPS）：
 *
 * <p>    字符串是一个空字符串 ""，或者是一个不为 "(" 或 ")" 的单字符。
 * <p>    字符串可以写为 AB（A 与 B 字符串连接），其中 A 和 B 都是 有效括号字符串 。
 * <p>    字符串可以写为 (A)，其中 A 是一个 有效括号字符串 。
 *
 * <p>类似地，可以定义任何有效括号字符串 S 的 嵌套深度 depth(S)：
 *
 * <p>    depth("") = 0
 * <p>    depth(C) = 0，其中 C 是单个字符的字符串，且该字符不是 "(" 或者 ")"
 * <p>    depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是 有效括号字符串
 * <p>    depth("(" + A + ")") = 1 + depth(A)，其中 A 是一个 有效括号字符串
 *
 * <p>例如：""、"()()"、"()(()())" 都是 有效括号字符串（嵌套深度分别为 0、1、2），而 ")(" 、"(()" 都不是 有效括号字符串 。
 *
 * <p>给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：s = "(1+(2*3)+((8)/4))+1"
 * <p>输出：3
 * <p>解释：数字 8 在嵌套的 3 层括号中。
 *
 * <p>示例 2：
 *
 * <p>输入：s = "(1)+((2))+(((3)))"
 * <p>输出：3
 *
 * <p>示例 3：
 *
 * <p>输入：s = "1+(2*3)/(2-1)"
 * <p>输出：1
 *
 * <p>示例 4：
 *
 * <p>输入：s = "1"
 * <p>输出：0
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= s.length <= 100
 * <p>    s 由数字 0-9 和字符 '+'、'-'、'*'、'/'、'('、')' 组成
 * <p>    题目数据保证括号表达式 s 是 有效的括号表达式
 *
 * <p>通过次数13,633
 * <p>提交次数16,594
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 7:25 下午
 */
public class Ch1614MaximumNestingDepthOfTheParentheses {

  public static int maxDepth(String s) {
    int ans = 0;
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        count++;
      } else if (c == ')') {
        count--;
      }
      ans = Math.max(count, ans);
    }
    return ans;
  }

  public int maxDepth_2(String s) {
    Stack<Character> stack = new Stack<>();
    int res = 0;
    int currentDepth = 0;
    for (int i = 0; i < s.length(); i++) {
      char a = s.charAt(i);
      if (a == '(') {
        stack.push(a);
        currentDepth++;
      } else if (a == ')') {
        stack.pop();
        currentDepth--;
      }
      res = Math.max(res, currentDepth);
    }
    return res;
  }

  public int maxDepth_3(String s) {
    int max = 0;
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(s.charAt(i));
      }
      if (s.charAt(i) == ')') {
        if (stack.peek() == '(') {
          max = Math.max(stack.size(), max);
          stack.pop();
        }
      }
    }
    return max;
  }
}
