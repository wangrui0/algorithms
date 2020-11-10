package org.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * <p>
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * <p>
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * <p>
 * 输出: true
 * <p>
 * 示例 3:
 * <p>
 * 输入: "(]"
 * <p>
 * 输出: false
 * <p>
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * <p>
 * 输出: false
 * <p>
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * <p>
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/11/10
 */
public class Ch0020IsValid {

  //[{}]
  public static void main(String[] args) {
    System.out.println(isValid2("()"));
    System.out.println(isValid2("()[]{}"));
    System.out.println(isValid2("(]"));
    System.out.println(isValid2("([)]"));
    System.out.println(isValid2("{[]}"));
  }

  public static boolean isValid2(String s) {
    int length = s.length();
    if (length % 2 == 1) {
      return false;
    }
    Map<Character, Character> map = new HashMap<Character, Character>() {
      {
        put('}', '{');
        put(']', '[');
        put(')', '(');
      }
    };
    Deque<Character> deque = new LinkedList<>();
    for (int i = 0; i < length; i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        if (map.get(c) != deque.peek()) {
          return false;
        } else {
          deque.pop();
        }
      } else {
        deque.push(c);
      }
    }
    return deque.isEmpty();
  }


  /**
   * <p>
   * 判断括号的有效性可以使用「栈」这一数据结构来解决。
   * <p>
   * 我们对给定的字符串 s 进行遍历，当我们遇到一个左括号时，我们会期望在后续的遍历中，有一个相同类型的右括号将其闭合。由于后遇到的左括号要先闭合，因此我们可以将这个左括号放入栈顶。
   * <p>
   * 当我们遇到一个右括号时，我们需要将一个相同类型的左括号闭合。此时，我们可以取出栈顶的左括号并判断它们是否是相同类型的括号。如果不是相同的类型，或者栈中并没有左括号，那么字符串 s 无效，返回
   * <p>
   * False。为了快速判断括号的类型，我们可以使用哈希映射（HashMap）存储每一种括号。哈希映射的键为右括号，值为相同类型的左括号。
   * <p>
   * 在遍历结束后，如果栈中没有左括号，说明我们将字符串 s 中的所有左括号闭合，返回 True，否则返回 False。
   * <p>
   * 注意到有效字符串的长度一定为偶数，因此如果字符串的长度为奇数，我们可以直接返回 False，省去后续的遍历判断过程。
   * <p>
   * ==================================
   * <p>
   * 复杂度分析
   * <p>
   * 时间复杂度：O(n)，其中 n 是字符串 s 的长度。
   * <p>
   * 空间复杂度：O(n+∣Σ∣)，其中 Σ 表示字符集，本题中字符串只包含 6 种括号，∣Σ∣=6。栈中的字符数量为 O(n)，而哈希映射使用的空间为
   * <p>
   * O(∣Σ∣)，相加即可得到总空间复杂度。
   * <p>
   */
  public boolean isValid(String s) {
    int n = s.length();
    if (n % 2 == 1) {
      return false;
    }

    Map<Character, Character> pairs = new HashMap<Character, Character>() {{
      put(')', '(');
      put(']', '[');
      put('}', '{');
    }};
    Deque<Character> stack = new LinkedList<>();
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






























