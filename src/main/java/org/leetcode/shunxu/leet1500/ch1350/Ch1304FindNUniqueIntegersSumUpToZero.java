package org.leetcode.shunxu.leet1500.ch1350;

/**
 * <p>1304. 和为零的N个唯一整数
 *
 * <p>给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：n = 5
 * <p>输出：[-7,-1,1,3,4]
 * <p>解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
 *
 * <p>示例 2：
 *
 * <p>输入：n = 3
 * <p>输出：[-1,0,1]
 *
 * <p>示例 3：
 *
 * <p>输入：n = 1
 * <p>输出：[0]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= n <= 1000
 *
 * <p>通过次数18,942
 * <p>提交次数25,790
 * <p>https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero/
 * <p>@author: wangrui
 * <p>@date: 2021/4/12
 */
public class Ch1304FindNUniqueIntegersSumUpToZero {

  /**
   * <p> n为奇数：压入0+互为相反数的数
   * <p>n为偶数：压入互为相反数的数
   *
   * @param n
   * @return
   */
  public int[] sumZero(int n) {
    int[] ans = new int[n];
    int index = 0;
    if (n % 2 == 1) {
      ans[index++] = 0;
    }
    for (int i = 1; i <= n / 2; i++) {
      ans[index++] = i;
      ans[index++] = -i;
    }
    return ans;
  }
}
