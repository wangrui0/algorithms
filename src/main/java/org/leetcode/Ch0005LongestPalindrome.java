package org.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * <p>
 * 输出: "bab"
 * <p>
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * <p>
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/10/24
 */
public class Ch0005LongestPalindrome {

  public static void main(String[] args) {
  }

  /**
   * @return
   */
  public static String longestPalindromicSubstring(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    int start = 0;
    int end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = expandAroundCenter(s, i, i);
      int len2 = expandAroundCenter(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
    return s.substring(start, end + 1);

  }

  public static int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }

  /**
   * 官方:
   * <p>
   * 思路与算法
   * <p>
   * 我们仔细观察一下方法一中的状态转移方程：
   * <p>
   * 可以发现，所有的状态在转移的时候的可能性都是唯一的。也就是说，我们可以从每一种边界情况开始「扩展」，也可以得出所有的状态对应的答案。
   * <p>
   * 边界情况即为子串长度为 1 或 2 的情况。我们枚举每一种边界情况，并从对应的子串开始不断地向两边扩展。如果两边的字母相同，我们就可以继续扩展，例如从 P(i+1,j−1) 扩展到
   * <p>
   * P(i,j)；如果两边的字母不同，我们就可以停止扩展，因为在这之后的子串都不能是回文串了。
   * <p>
   * 聪明的读者此时应该可以发现，「边界情况」对应的子串实际上就是我们「扩展」出的回文串的「回文中心」。方法二的本质即为：我们枚举所有的「回文中心」并尝试「扩展」，
   * <p>
   * 直到无法扩展为止，此时的回文串长度即为此「回文中心」下的最长回文串长度。我们对所有的长度求出最大值，即可得到最终的答案。
   *
   * @param s
   * @return
   */
  public String longestPalindrome2(String s) {
    if (s == null || s.length() < 1) {
      return "";
    }
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = expandAroundCenter2(s, i, i);
      int len2 = expandAroundCenter2(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  public int expandAroundCenter2(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      --left;
      ++right;
    }
    return right - left - 1;
  }
}
