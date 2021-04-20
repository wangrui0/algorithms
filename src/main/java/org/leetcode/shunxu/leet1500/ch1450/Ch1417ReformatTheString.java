package org.leetcode.shunxu.leet1500.ch1450;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * <p>1417. 重新格式化字符串
 *
 * <p>给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 *
 * <p>请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 *
 * <p>请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：s = "a0b1c2"
 * <p>输出："0a1b2c"
 * <p>解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 *
 * <p>示例 2：
 *
 * <p>输入：s = "leetcode"
 * <p>输出：""
 * <p>解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
 *
 * <p>示例 3：
 *
 * <p>输入：s = "1229857369"
 * <p>输出：""
 * <p>解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
 *
 * <p>示例 4：
 *
 * <p>输入：s = "covid2019"
 * <p>输出："c2o0v1i9d"
 *
 * <p>示例 5：
 *
 * <p>输入：s = "ab123"
 * <p>输出："1a2b3"
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= s.length <= 500
 * <p>    s 仅由小写英文字母和/或数字组成。
 *
 * <p>通过次数11,274
 * <p>提交次数21,909
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/reformat-the-string/
 * <p>@author: wangrui
 * <p>@date: 2021/4/18
 */
public class Ch1417ReformatTheString {

  public String reformat(String s) {
    int num1 = 0, num2 = 0;
    char[] chars = s.toCharArray();
    for (char c : chars) {
      if (c >= '0' && c <= '9') {
        num1++;
      } else {
        num2++;
      }
    }//看数字字符比较多还是字母字符比较多
    if (num1 - num2 < -1 || num1 - num2 > 1) {
      return "";
    }
    if (num1 > num2) {
      num1 = 0;
      num2 = 1;
    } else {
      num1 = 1;
      num2 = 0;
    }
    for (char c : s.toCharArray()) {
      if (c >= '0' && c <= '9') {
        chars[num1] = c;
        num1 += 2;
      } else {
        chars[num2] = c;
        num2 += 2;
      }
    }
    return new String(chars);
  }

  public String reformat_2(String s) {
    Stack<Character> stackAZ = new Stack();
    Stack<Character> stack09 = new Stack();
    Stack<Character> temp = new Stack();
    String result = "";
    for (char c : s.toCharArray()) {
      if (c >= '0' && c <= '9') {
        stack09.add(c);
      } else {
        stackAZ.add(c);
      }
    }
    if (Math.abs(stack09.size() - stackAZ.size()) > 1) {
      return result;
    }
    if (stack09.size() > stackAZ.size()) {
      temp = stack09;
      stack09 = stackAZ;
      stackAZ = temp;
    }
    for (stackAZ.size(); stackAZ.size() > 0; ) {
      result = result + String.valueOf(stackAZ.pop());
      if (stack09.empty()) {
        continue;
      } else {
        result = result + String.valueOf(stack09.pop());
      }
    }
    return result;
  }

  public String reformat_3(String s) {
    Queue<Character> ch = new LinkedList<>();
    Queue<Integer> num = new LinkedList<>();
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
        ch.add(s.charAt(i));
      } else {
        num.add(s.charAt(i) - '0');
      }
    }
    if (Math.abs(ch.size() - num.size()) > 1) {//不满足格式化的条件
      return "";
    }
    //谁长，就从谁开始
    if (ch.size() > num.size()) {//字母长
      while (!ch.isEmpty() && !num.isEmpty()) {
        res.append(ch.poll());
        res.append(num.poll());
      }
      //最后还剩一个ch
      while (!ch.isEmpty()) {
        res.append(ch.poll());
      }

    } else {
      //数字长
      while (!ch.isEmpty() && !num.isEmpty()) {
        res.append(num.poll());
        res.append(ch.poll());
      }
      while (!num.isEmpty()) {
        res.append(num.poll());
      }
    }

    return res + "";
  }

  public String reformat_4(String s) {
    List<Character> nums = new ArrayList<>();
    List<Character> letters = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      char temp = s.charAt(i);
      if (temp >= '0' && temp <= '9') {
        nums.add(temp);
      } else {
        letters.add(temp);
      }
    }
    int temp = letters.size() - nums.size();
    if (temp >= 2 || temp <= -2) {
      return "";
    }
    StringBuilder res = new StringBuilder();
    if (temp == 1) {
      res.append(letters.get(letters.size() - 1));
      return create(nums, letters, res, letters.size() - 2);
    } else if (temp == -1) {
      res.append(nums.get(nums.size() - 1));
      return create(letters, nums, res, nums.size() - 2);
    } else {
      return create(letters, nums, res, nums.size() - 1);
    }
  }

  private String create(List<Character> one, List<Character> two, StringBuilder sb, int hi) {
    for (int i = hi; i >= 0; i--) {
      sb.append(one.get(i));
      sb.append(two.get(i));
    }
    return sb.toString();
  }


  public static void main(String[] args) {

  }

  public String reformat_6(String s) {
    int num1 = 0, num2 = 0;
    for (char c : s.toCharArray()) {
      if (c >= '0' && c <= '9') {
        num1++;
      } else {
        num2++;
      }
    }
    if (num1 - num2 > 1 || num2 - num1 > 1) {
      return "";
    }
    if (num1 > num2) {
      num1 = 0;
      num2 = 1;
    } else {
      num2 = 0;
      num1 = 1;
    }
    char[] ans = new char[s.length()];
    for (char x : s.toCharArray()) {
      if (x >= '0' && x <= '9') {
        ans[num1] = x;
        num1 += 2;
      } else {
        ans[num2] = x;
        num2 += 2;
      }
    }
    return new String(ans);
  }


}
