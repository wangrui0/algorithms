package org.leetcode.shunxu.leet1000.ch950;

/**
 * <p>942. 增减字符串匹配
 *
 * <p>给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 *
 * <p>返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 *
 * <p>    如果 S[i] == "I"，那么 A[i] < A[i+1]
 * <p>    如果 S[i] == "D"，那么 A[i] > A[i+1]
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入："IDID"
 * <p>输出：[0,4,1,3,2]
 *
 * <p>示例 2：
 *
 * <p>输入："III"
 * <p>输出：[0,1,2,3]
 *
 * <p>示例 3：
 *
 * <p>输入："DDI"
 * <p>输出：[3,2,0,1]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= S.length <= 10000
 * <p>    S 只包含字符 "I" 或 "D"。
 *
 * <p>通过次数19,712
 * <p>提交次数27,131
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/4/1
 */
public class Ch942DiStringMatch {

  public int[] diStringMatch(String S) {
    int[] ans = new int[S.length() + 1];
    int left = 0;
    int right = S.length();
    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) == 'I') {
        ans[i] = left++;
      } else {
        ans[i] = right--;
      }
    }
    ans[S.length()] = left;
    return ans;
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(N)，其中 N 是字符串 S 的长度。
   *
   * <p> 空间复杂度：O(N)。
   *
   * @param S
   * @return
   */
  public int[] diStringMatch_1(String S) {
    int N = S.length();
    int lo = 0, hi = N;
    int[] ans = new int[N + 1];
    for (int i = 0; i < N; ++i) {
      if (S.charAt(i) == 'I') {
        ans[i] = lo++;
      } else {
        ans[i] = hi--;
      }
    }

    ans[N] = lo;
    return ans;
  }
}
