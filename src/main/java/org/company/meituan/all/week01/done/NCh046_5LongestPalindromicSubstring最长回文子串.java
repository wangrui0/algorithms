package org.company.meituan.all.week01.done;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>5. 最长回文子串
 * <p>给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：s = "babad"
 * <p>输出："bab"
 * <p>解释："aba" 同样是符合题意的答案。
 * <p>示例 2：
 *
 * <p>输入：s = "cbbd"
 * <p>输出："bb"
 * <p>示例 3：
 *
 * <p>输入：s = "a"
 * <p>输出："a"
 * <p>示例 4：
 *
 * <p>输入：s = "ac"
 * <p>输出："a"
 *
 *
 * <p>提示：
 *
 * <p>1 <= s.length <= 1000
 * <p>s 仅由数字和英文字母（大写和/或小写）组成
 * <p>通过次数590,530提交次数1,722,988
 * <p>https://leetcode-cn.com/problems/longest-palindromic-substring/
 * <p>@author: wangrui
 * <p>@date: 2021/5/14
 */
public class NCh046_5LongestPalindromicSubstring最长回文子串 {

  /**
   * <p>方法一：动态规划
   * 复杂度分析
   *
   * <p>时间复杂度：O(n^2)，其中 n 是字符串的长度。动态规划的状态总数为 O(n^2)，对于每个状态，我们需要转移的时间为 O(1)。
   *
   * <p>空间复杂度：O(n^2)，即存储动态规划状态需要的空间。
   *
   * @param s
   * @return
   */
  public String longestPalindrome(String s) {
    int len = s.length();
    if (len < 2) {
      return s;
    }

    int maxLen = 1;
    int begin = 0;
    // dp[i][j] 表示 s[i..j] 是否是回文串
    boolean[][] dp = new boolean[len][len];
    // 初始化：所有长度为 1 的子串都是回文串
    for (int i = 0; i < len; i++) {
      dp[i][i] = true;
    }

    char[] charArray = s.toCharArray();
    // 递推开始
    // 先枚举子串长度
    for (int L = 2; L <= len; L++) {
      // 枚举左边界，左边界的上限设置可以宽松一些
      for (int i = 0; i < len; i++) {
        // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
        int j = L + i - 1;
        // 如果右边界越界，就可以退出当前循环
        if (j >= len) {
          break;
        }

        if (charArray[i] != charArray[j]) {
          dp[i][j] = false;
        } else {
          if (j - i < 3) {
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i + 1][j - 1];
          }
        }

        // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
        if (dp[i][j] && j - i + 1 > maxLen) {
          maxLen = j - i + 1;
          begin = i;
        }
      }
    }
    return s.substring(begin, begin + maxLen);
  }

  /**
   * 方法二：中心扩展算法
   * <p>复杂度分析
   *
   * <p>时间复杂度：O(n^2)，其中 n 是字符串的长度。长度为 1和 2的回文中心分别有 n 和 n-1 个，每个回文中心最多会向外扩展 O(n) 次。
   *
   * <p>空间复杂度：O(1)。
   *
   * @param s
   * @return
   */
  public String longestPalindrome_2(String s) {
    if (s == null || s.length() < 1) {
      return "";
    }
    int start = 0, end = 0;
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

  public int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      --left;
      ++right;
    }
    return right - left - 1;
  }

  /**
   * <p>方法三：Manacher 算法
   * <p>复杂度分析
   *
   * <p>时间复杂度：O(n)，其中 n是字符串的长度。由于对于每个位置，扩展要么从当前的最右侧臂长 right 开始，要么只会进行一步，而 right 最多向前走 O(n) 步，因此算法的复杂度为 O(n)。
   *
   * <p>空间复杂度：O(n)，我们需要 O(n) 的空间记录每个位置的臂长。
   *
   * @param s
   * @return
   */
  public String longestPalindrome_3(String s) {
    int start = 0, end = -1;
    StringBuffer t = new StringBuffer("#");
    for (int i = 0; i < s.length(); ++i) {
      t.append(s.charAt(i));
      t.append('#');
    }
    t.append('#');
    s = t.toString();

    List<Integer> arm_len = new ArrayList<Integer>();
    int right = -1, j = -1;
    for (int i = 0; i < s.length(); ++i) {
      int cur_arm_len;
      if (right >= i) {
        int i_sym = j * 2 - i;
        int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
        cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
      } else {
        cur_arm_len = expand(s, i, i);
      }
      arm_len.add(cur_arm_len);
      if (i + cur_arm_len > right) {
        j = i;
        right = i + cur_arm_len;
      }
      if (cur_arm_len * 2 + 1 > end - start) {
        start = i - cur_arm_len;
        end = i + cur_arm_len;
      }
    }

    StringBuffer ans = new StringBuffer();
    for (int i = start; i <= end; ++i) {
      if (s.charAt(i) != '#') {
        ans.append(s.charAt(i));
      }
    }
    return ans.toString();
  }

  public int expand(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      --left;
      ++right;
    }
    return (right - left - 2) / 2;
  }
}
