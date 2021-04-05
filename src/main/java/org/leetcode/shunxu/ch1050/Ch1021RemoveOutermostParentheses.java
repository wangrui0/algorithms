package org.leetcode.shunxu.ch1050;

import java.util.Stack;

/**
 * <p>1021. 删除最外层的括号
 *
 * <p>有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 *
 * <p>如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 *
 * <p>给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 *
 * <p>对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入："(()())(())"
 * <p>输出："()()()"
 * <p>解释：
 * <p>输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * <p>删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 *
 * <p>示例 2：
 *
 * <p>输入："(()())(())(()(()))"
 * <p>输出："()()()()(())"
 * <p>解释：
 * <p>输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * <p>删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 *
 * <p>示例 3：
 *
 * <p>输入："()()"
 * <p>输出：""
 * <p>解释：
 * <p>输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * <p>删除每个部分中的最外层括号后得到 "" + "" = ""。
 *
 *
 *
 * <p>提示：
 *
 * <p>    S.length <= 10000
 * <p>    S[i] 为 "(" 或 ")"
 * <p>    S 是一个有效括号字符串
 * https://leetcode-cn.com/problems/remove-outermost-parentheses/
 * <p>通过次数50,628
 * <p>提交次数64,610
 * <p>@author: wangrui
 * <p>@date: 2021/4/5
 */
public class Ch1021RemoveOutermostParentheses {

  /**
   * 方法一:
   *
   * @param S
   * @return
   */
  public String removeOuterParentheses(String S) {
    StringBuilder sb = new StringBuilder();
    int level = 0;
    for (char c : S.toCharArray()) {
      if (c == ')') {
        --level;
      }
      if (level >= 1) {
        sb.append(c);
      }
      if (c == '(') {
        ++level;
      }
    }
    return sb.toString();
  }


  /**
   * 方法二：
   *
   * @param s
   * @return
   */
  public String removeOuterParentheses_2(String S) {
    StringBuilder ans = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    int start = 0;// 初始化原语的起始位置
    int end = 0;// 初始化原语的结束位置
    boolean flag = false;// 标志每个原语

    for (int i = 0; i < S.length(); i++) {
      char ch = S.charAt(i);

      if (ch == '(') {// 遇到左括号，入栈
        stack.push(ch);
        if (!flag) {// 遇到的第一个左括号，是原语的开始位置，记录下原语开始位置
          start = i;
          flag = true;
        }
      }

      if (ch == ')') {// 遇到右括号，出栈
        stack.pop();
        if (stack.isEmpty()) {// 当栈空的时候，找到了一个完整的原语
          end = i;// 记录下结束位置
          ans.append(S.substring(start + 1, end));// 去掉原语的最外层括号，并追加到答案中
          flag = false;// 置标志为false，往后接着找下一个原语
          start = end;// 往后找，再次初始化原语开始位置
        }
      }
    }

    return ans.toString();
  }

  /**
   * 用栈来记录匹配的问题
   *
   * @param S
   * @return
   */
  public String removeOuterParentheses_3(String S) {
    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int start = 0;
    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) == '(') {
        stack.push('(');
      } else {
        stack.pop();
        if (stack.isEmpty()) {//如果为空的话，说明里面的是个原语
          sb.append(S.substring(start + 1, i));
          start = i + 1;
        }
      }
    }
    return sb.toString();
  }

}
