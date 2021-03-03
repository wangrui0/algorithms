package org.leetcode.shunxu.ch400;

/**
 * <p>392. 判断子序列
 *
 * <p>给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * <p>字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * <p>进阶：
 *
 * <p>如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * <p>致谢：
 *
 * <p>特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：s = "abc", t = "ahbgdc"
 * <p>输出：true
 *
 * <p>示例 2：
 *
 * <p>输入：s = "axc", t = "ahbgdc"
 * <p>输出：false
 *
 *
 *
 * <p>提示：
 *
 * <p>   0 <= s.length <= 100
 * <p>    0 <= t.length <= 10^4
 * <p>    两个字符串都只由小写字符组成。
 * <p> https://leetcode-cn.com/problems/is-subsequence/
 *
 * @author: wangrui
 * @date: 2021/3/3
 */
public class Ch392IsSubsequence {

  /**
   * self:
   * <p>时间复杂度：O(n)
   * <p>空间复杂度：O(1)
   *
   * @param s
   * @param t
   * @return
   */
  public static boolean isSubsequence(String s, String t) {
    int s0 = 0;
    int s1 = 0;
    while (s0 < s.length() && s1 < t.length()) {
      while (s1 < t.length() && s.charAt(s0) != t.charAt(s1)) {
        s1++;
      }
      if (s1 == t.length()) {
        return false;
      }
      s0++;
      s1++;
    }
    return s0 == s.length();
  }

  /**
   * 不错
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(n+m)，其中 n 为 s 的长度，m 为 t 的长度。每次无论是匹配成功还是失败，都有至少一个指针发生右移，两指针能够位移的总距离为 n+m。
   *
   * <p>   空间复杂度：O(1)。
   *
   * <p>作者：LeetCode-Solution
   * <p>链接：https://leetcode-cn.com/problems/is-subsequence/solution/pan-duan-zi-xu-lie-by-leetcode-solution/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isSubsequence2(String s, String t) {
    int n = s.length(), m = t.length();
    int i = 0, j = 0;
    while (i < n && j < m) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
      }
      j++;
    }
    return i == n;
  }

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(m×∣Σ∣+n)，其中 n 为 s 的长度，m 为 t 的长度，Σ 为字符集，在本题中字符串只包含小写字母，∣Σ∣=26。预处理时间复杂度 O(m)，判断子序列时间复杂度 O(n)。
   * <p>      如果是计算 k 个平均长度为 n 的字符串是否为 t 的子序列，则时间复杂度为 O(m×∣Σ∣+k×n)。
   *
   * <p>  空间复杂度：O(m×∣Σ∣)，为动态规划数组的开销。
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isSubsequence3(String s, String t) {
    int n = s.length(), m = t.length();

    int[][] f = new int[m + 1][26];
    for (int i = 0; i < 26; i++) {
      f[m][i] = m;
    }

    for (int i = m - 1; i >= 0; i--) {
      for (int j = 0; j < 26; j++) {
        if (t.charAt(i) == j + 'a') {
          f[i][j] = i;
        } else {
          f[i][j] = f[i + 1][j];
        }
      }
    }
    int add = 0;
    for (int i = 0; i < n; i++) {
      if (f[add][s.charAt(i) - 'a'] == m) {
        return false;
      }
      add = f[add][s.charAt(i) - 'a'] + 1;
    }
    return true;
  }
}
