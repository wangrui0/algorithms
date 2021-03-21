package org.leetcode.shunxu.ch950;

import java.util.Stack;

/**
 * <p>917. 仅仅反转字母
 *
 * <p>给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入："ab-cd"
 * <p>输出："dc-ba"
 *
 * <p>示例 2：
 *
 * <p>输入："a-bC-dEf-ghIj"
 * <p>输出："j-Ih-gfE-dCba"
 *
 * <p>示例 3：
 *
 * <p>输入："Test1ng-Leet=code-Q!"
 * <p>输出："Qedo1ct-eeLg=ntse-T!"
 *
 *
 *
 * <p>提示：
 *
 * <p>    S.length <= 100
 * <p>    33 <= S[i].ASCIIcode <= 122
 * <p>    S 中不包含 \ or "
 *
 * <p>通过次数24,425
 * <p>提交次数43,186
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/21
 */
public class Ch917ReverseOnlyLetters {

  public static void main(String[] args) {
    System.out.println(reverseOnlyLetters("ab-cd"));
  }

  /**
   * i Test1ng-Leet=code-Q! j !Qedoc=-teelgn1ts-eT
   * <p>
   * !Qedoc=-teelgn1ts-eT
   *
   * @param S
   * @return
   */
  public static String reverseOnlyLetters(String S) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0, j = S.length() - 1; i < S.length(); i++) {
      if (Character.isLetter(S.charAt(i))) {
        while (!Character.isLetter(S.charAt(j))) {
          j--;
        }
        sb.append(S.charAt(j));
        j--;
      } else {
        sb.append(S.charAt(i));
      }
    }
    return sb.toString();
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(N)，其中 N 是 S 的长度。
   * <p>     空间复杂度：O(N)。
   *
   * @param S
   * @return
   */
  public String reverseOnlyLetters2(String S) {
    StringBuilder ans = new StringBuilder();
    int j = S.length() - 1;
    for (int i = 0; i < S.length(); ++i) {
      if (Character.isLetter(S.charAt(i))) {
        while (!Character.isLetter(S.charAt(j))) {
          j--;
        }
        ans.append(S.charAt(j--));
      } else {
        ans.append(S.charAt(i));
      }
    }

    return ans.toString();
  }

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(N)，其中 N 是 S 的长度。
   * <p>  空间复杂度：O(N)。
   *
   * @param S
   * @return
   */
  public String reverseOnlyLetters3(String S) {
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < S.length(); i++) {
      if (Character.isLetter(S.charAt(i))) {
        stack.push(S.charAt(i));
      }
    }
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < S.length(); ++i) {
      if (Character.isLetter(S.charAt(i))) {
        ans.append(stack.pop());
      } else {
        ans.append(S.charAt(i));
      }
    }

    return ans.toString();
  }
}
