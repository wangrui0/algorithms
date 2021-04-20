package org.leetcode.shunxu.leet1000.ch900;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> 859. 亲密字符串
 *
 * <p> 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 *
 * <p> 交换字母的定义是取两个下标 i 和 j （下标从 0 开始），只要 i!=j 就交换 A[i] 和 A[j] 处的字符。例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 *
 *
 *
 * <p> 示例 1：
 *
 * <p> 输入： A = "ab", B = "ba"
 * <p> 输出： true
 * <p> 解释： 你可以交换 A[0] = 'a' 和 A[1] = 'b' 生成 "ba"，此时 A 和 B 相等。
 *
 * <p> 示例 2：
 *
 * <p> 输入： A = "ab", B = "ab"
 * <p> 输出： false
 * <p> 解释： 你只能交换 A[0] = 'a' 和 A[1] = 'b' 生成 "ba"，此时 A 和 B 不相等。
 *
 * <p> 示例 3:
 *
 * <p> 输入： A = "aa", B = "aa"
 * <p> 输出： true
 * <p> 解释： 你可以交换 A[0] = 'a' 和 A[1] = 'a' 生成 "aa"，此时 A 和 B 相等。
 *
 * <p> 示例 4：
 *
 * <p> 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * <p> 输出： true
 *
 * <p> 示例 5：
 *
 * <p> 输入： A = "", B = "aa"
 * <p> 输出： false
 *
 *
 *
 * <p> 提示：
 *
 * <p>     0 <= A.length <= 20000
 * <p>     0 <= B.length <= 20000
 * <p>     A 和 B 仅由小写字母构成。
 *
 * <p> 通过次数23,834
 * <p> 提交次数80,399
 * <p> 在真实的面试中遇到过这道题？
 * <p> https://leetcode-cn.com/problems/buddy-strings/
 * <p> @author: wangrui
 * <p> @date: 2021/3/30
 */
public class Ch859BuddyStrings {

  /**
   * <p>复杂度分析
   *
   * <p>     时间复杂度：O(N)，其中 N 是 A 和 B 的长度。
   *
   * <p>    空间复杂度：O(1)。
   *
   * @param A
   * @param B
   * @return
   */
  public boolean buddyStrings(String A, String B) {
    if (A.length() != B.length()) {
      return false;
    }
    if (A.equals(B)) {
      int[] count = new int[26];
      for (int i = 0; i < A.length(); ++i) {
        count[A.charAt(i) - 'a']++;
      }

      for (int c : count) {
        if (c > 1) {
          return true;
        }
      }
      return false;
    } else {
      int first = -1, second = -1;
      for (int i = 0; i < A.length(); ++i) {
        if (A.charAt(i) != B.charAt(i)) {
          if (first == -1) {
            first = i;
          } else if (second == -1) {
            second = i;
          } else {
            return false;
          }
        }
      }

      return (second != -1 && A.charAt(first) == B.charAt(second) &&
          A.charAt(second) == B.charAt(first));
    }
  }
  /**
   * <p>复杂度分析
   *
   * <p>     时间复杂度：O(N)，其中 N 是 A 和 B 的长度。
   *
   * <p>    空间复杂度：O(1)。
   *
   * @param A
   * @param B
   * @return
   */
  public static boolean buddyStrings2(String A, String B) {
    int lengthA = A.length();
    int lengthB = B.length();
    if (lengthA != lengthB) {
      return false;
    }
    int left = -1;
    int right = -1;
    Map<Character, Integer> map = new HashMap<>();
    boolean flag = false;
    for (int i = 0; i < lengthA; i++) {
      int count = map.getOrDefault(A.charAt(i), 0) + 1;
      if (count >= 2) {
        flag = true;
      }
      map.put(A.charAt(i), count);
      if (A.charAt(i) != B.charAt(i)) {
        if (left != -1 && right != -1) {
          return false;
        } else if (left == -1) {
          left = i;
        } else {
          right = i;
        }
      }
    }
    return left != -1 && right != -1 && A.charAt(left) == B.charAt(right) && A.charAt(right) == B.charAt(left)
        || left == -1 && right == -1 && flag;
  }

}


