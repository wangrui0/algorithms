package org.leetcode.shunxu.leet1000.ch800;

import java.util.Arrays;

/**
 * <p>796. 旋转字符串
 *
 * <p>给定两个字符串, A 和 B。
 *
 * <p>A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
 *
 * <p>示例 1:
 * <p>输入: A = 'abcde', B = 'cdeab'
 * <p>输出: true
 *
 * <p>示例 2:
 * <p>输入: A = 'abcde', B = 'abced'
 * <p>输出: false
 *
 * <p>注意：
 *
 * <p>    A 和 B 长度不超过 100。
 *
 * <p>通过次数17,804
 * <p>提交次数34,546
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/rotate-string/
 * <p>@author: wangrui
 * <p>@date: 2021/3/26
 */
public class Ch796RotateString {

  /**
   * <p>  方法二：判断子串
   * <p> 复杂度分析
   *
   * <p>    时间复杂度：O(N^2)，其中 N 是字符串 A 的长度。
   *
   * <p>    空间复杂度：O(N)，即 A + A 需要的空间。
   *
   * @param A
   * @param B
   * @return
   */
  public boolean rotateString(String A, String B) {
    return A.length() == B.length() && (A + A).contains(B);
  }

  /**
   * <p> 方法四：KMP 算法
   * <p> 复杂度分析
   *
   * <p>    时间复杂度：O(N)，其中 N 是字符串 A 的长度。
   *
   * <p>    空间复杂度：O(N)。
   *
   * @param A
   * @param B
   * @return
   */
  public boolean rotateString_2(String A, String B) {
    int N = A.length();
    if (N != B.length()) {
      return false;
    }
    if (N == 0) {
      return true;
    }

    //Compute shift table
    int[] shifts = new int[N + 1];
    Arrays.fill(shifts, 1);
    int left = -1;
    for (int right = 0; right < N; ++right) {
      while (left >= 0 && (B.charAt(left) != B.charAt(right))) {
        left -= shifts[left];
      }
      shifts[right + 1] = right - left++;
    }

    //Find match of B in A+A
    int matchLen = 0;
    for (char c : (A + A).toCharArray()) {
      while (matchLen >= 0 && B.charAt(matchLen) != c) {
        matchLen -= shifts[matchLen];
      }
      if (++matchLen == N) {
        return true;
      }
    }

    return false;
  }

  public boolean rotateString_3(String A, String B) {
    return A.length() == B.length() && kmp((A + A), B);
  }

  /**
   * s:主 t:子
   *
   * @param s
   * @param t
   * @return
   */
  public boolean kmp(String s, String t) {
    int sL = s.length();
    int tL = t.length();
    if (s.length() == 0 && t.length() == 0) {
      return true;
    }
    int[] fail = new int[tL];
    Arrays.fill(fail, -1);
    for (int i = 1, j = -1; i < tL; i++) {
      while (j != -1 && t.charAt(i) != t.charAt(j + 1)) {
        j = fail[j];
      }
      if (t.charAt(i) == t.charAt(j + 1)) {
        j++;
      }
      fail[i] = j;
    }
    for (int i = 0, j = -1; i < sL; i++) {
      while (j != -1 && s.charAt(i) != t.charAt(j + 1)) {
        j = fail[j];
      }
      if (s.charAt(i) == t.charAt(j + 1)) {
        j++;
      }
      if (j >= tL - 1) {
        return true;
      }
    }
    return false;
  }


}
