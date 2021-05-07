package org.company.meituan.Collect;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * <p>20. 有效的括号
 *
 * <p>给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * <p>有效字符串需满足：
 *
 * <p>    左括号必须用相同类型的右括号闭合。
 * <p>    左括号必须以正确的顺序闭合。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：s = "()"
 * <p>输出：true
 *
 * <p>示例 2：
 *
 * <p>输入：s = "()[]{}"
 * <p>输出：true
 *
 * <p>示例 3：
 *
 * <p>输入：s = "(]"
 * <p>输出：false
 *
 * <p>示例 4：
 *
 * <p>输入：s = "([)]"
 * <p>输出：false
 *
 * <p>示例 5：
 *
 * <p>输入：s = "{[]}"
 * <p>输出：true
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= s.length <= 104
 * <p>    s 仅由括号 '()[]{}' 组成
 *
 * <p>通过次数623,079
 * <p>提交次数1,415,076
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/valid-parentheses/
 * <p>@author: wangrui
 * <p>@date: 2021/5/7
 */
public class Ch006_20ValidParentheses有效的括号 {

  public static boolean isValid_self(String s) {
    Map<Character, Character> map = new HashMap<Character, Character>() {{
      put(')', '(');
      put(']', '[');
      put('}', '{');
    }};
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else if (!stack.isEmpty() && map.get(c).equals(stack.peek())) {
        stack.pop();
      } else {
        return false;
      }
    }
    return stack.isEmpty();
  }

  /**
   * 复杂度分析
   * <p>
   * 时间复杂度：O(n)，其中 nnn 是字符串 sss 的长度。
   * <p>
   * 空间复杂度：O(n+∣Σ∣)，其中 Σ 表示字符集，本题中字符串只包含 6 种括号，∣Σ∣=6。栈中的字符数量为 O(n)，而哈希表使用的空间为 O(∣Σ∣)，相加即可得到总空间复杂度。
   *
   * @param s
   * @return
   */
  public boolean isValid_2(String s) {
    int n = s.length();
    if (n % 2 == 1) {
      return false;
    }

    Map<Character, Character> pairs = new HashMap<Character, Character>() {{
      put(')', '(');
      put(']', '[');
      put('}', '{');
    }};
    Deque<Character> stack = new LinkedList<Character>();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (pairs.containsKey(ch)) {
        if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
          return false;
        }
        stack.pop();
      } else {
        stack.push(ch);
      }
    }
    return stack.isEmpty();
  }
}
