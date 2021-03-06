package org.company.meituan.all.week02.done;

/**
 * <p>50. Pow(x, n)
 * <p>实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：x = 2.00000, n = 10
 * <p>输出：1024.00000
 * <p>示例 2：
 *
 * <p>输入：x = 2.10000, n = 3
 * <p>输出：9.26100
 * <p>示例 3：
 *
 * <p>输入：x = 2.00000, n = -2
 * <p>输出：0.25000
 * <p>解释：2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * <p>提示：
 *
 * <p>-100.0 < x < 100.0
 * <p>-231 <= n <= 231-1
 * <p>-104 <= xn <= 104
 * <p>通过次数182,675提交次数487,200
 * <p>请问您在哪类招聘中遇到此题？
 * <p>贡献者
 * <p>LeetCode
 * <p>https://leetcode-cn.com/problems/powx-n/
 * <p>@Author: shenpei
 * <p>@Date: 2021/5/17 6:38 下午
 */
public class NCh071_50powxN {

  /**
   * 循环
   *
   * @param x
   * @param n
   * @return
   */
  public double myPow(double x, int n) {
    long N = n;
    return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
  }

  public double quickMul(double x, long N) {
    double ans = 1.0;
    // 贡献的初始值为 x
    double x_contribute = x;
    // 在对 N 进行二进制拆分的同时计算答案
    while (N > 0) {
      if (N % 2 == 1) {
        // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
        ans *= x_contribute;
      }
      // 将贡献不断地平方
      x_contribute *= x_contribute;
      // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
      N /= 2;
    }
    return ans;
  }

  /**
   * 递归
   *
   * @param x
   * @param n
   * @return
   */
  public double myPow_2(double x, int n) {
    long N = n;
    return N >= 0 ? quickMul_2(x, N) : 1.0 / quickMul_2(x, -N);
  }

  public double quickMul_2(double x, long N) {
    if (N == 0) {
      return 1.0;
    }
    double y = quickMul(x, N / 2);
    return N % 2 == 0 ? y * y : y * y * x;
  }

}

