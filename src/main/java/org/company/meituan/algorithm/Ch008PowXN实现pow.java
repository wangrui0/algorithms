package org.company.meituan.algorithm;

/**
 * <p>50. Pow(x, n)
 *
 * <p>实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：x = 2.00000, n = 10
 * <p>输出：1024.00000
 *
 * <p>示例 2：
 *
 * <p>输入：x = 2.10000, n = 3
 * <p>输出：9.26100
 *
 * <p>示例 3：
 *
 * <p>输入：x = 2.00000, n = -2
 * <p>输出：0.25000
 * <p>解释：2-2 = 1/22 = 1/4 = 0.25
 *
 *
 *
 * <p>提示：
 *
 * <p>    -100.0 < x < 100.0
 * <p>    -231 <= n <= 231-1
 * <p>    -104 <= xn <= 104
 *
 * <p>通过次数179,767
 * <p>提交次数479,885
 * <p>请问您在哪类招聘中遇到此题？
 * <p>|50. Pow(x, n)|1|https://leetcode-cn.com/problems/powx-n|
 * <p>@author: wangrui
 * <p>@date: 2021/5/6
 */
public class Ch008PowXN实现pow {

  /**
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(logn)，即为递归的层数。
   *
   * <p> 空间复杂度：O(logn)，即为递归的层数。这是由于递归的函数调用会使用栈空间。
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
    if (N == 0) {
      return 1.0;
    }
    double y = quickMul(x, N / 2);
    return N % 2 == 0 ? y * y : y * y * x;
  }

  /**
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(logn)，即为对 n 进行二进制拆分的时间复杂度。
   *
   * <p>  空间复杂度：O(1)。
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

  public static void main(String[] args) {
    System.out.println(quickMul_3(2, 10));
  }

  public static double quickMul_3(double x, long N) {
    double ans = 1.0;
    double x_x = x;
    while (N > 0) {
      if (N % 2 == 1) {
        ans = ans * x_x;
      }
      x_x *= x_x;
      N /= 2;
    }
    return ans;
  }


}
