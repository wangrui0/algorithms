package org.company.meituan.all.week01.done;

/**
 * <p>718. 最长重复子数组
 *
 * <p>给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 *
 *
 * <p>示例：
 *
 * <p>输入：
 * <p>A: [1,2,3,2,1]
 * <p>B: [3,2,1,4,7]
 * <p>输出：3
 * <p>解释：
 * <p>长度最长的公共子数组是 [3, 2, 1] 。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= len(A), len(B) <= 1000
 * <p>    0 <= A[i], B[i] < 100
 *
 * <p>通过次数61,117
 * <p>提交次数109,488
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * <p>@author: wangrui
 * <p>@date: 2021/5/7
 */
public class NCh005_718MaximumLengthOfRepeatedSubarray最长重复子数组 {

  public int findLength_1(int[] A, int[] B) {
    int n = A.length, m = B.length;
    int[][] dp = new int[n + 1][m + 1];
    int ans = 0;
    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
        ans = Math.max(ans, dp[i][j]);
      }
    }
    return ans;
  }


}
