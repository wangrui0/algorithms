package org.company.meituan.all.week01.done;

/**
 * <p>剑指 Offer 10- I. 斐波那契数列
 *
 * <p>写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * <p>F(0) = 0,   F(1) = 1
 * <p>F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 *
 * <p>斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * <p>答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：n = 2
 * <p>输出：1
 *
 * <p>示例 2：
 *
 * <p>输入：n = 5
 * <p>输出：5
 *
 *
 *
 * <p>提示：
 *
 * <p>    0 <= n <= 100
 *
 * <p>通过次数161,307
 * <p>提交次数469,932
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 *
 * <p>@author: wangrui
 * <p>@date: 2021/5/9
 */
public class Ch021_offer_10_I_FeiBoNaQiShuLieLcof剑指Offerr10_II斐波那契数列 {

  public static int fib_self(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }

    int f0 = 0;
    int f1 = 1;
    for (int i = 2; i <= n; i++) {
      int fn = f0 + f1;
      f0 = f1;
      f1 = fn % 1000000007;
    }
    return f1;
  }

  public int fib(int n) {
    int a = 0, b = 1, sum;
    for (int i = 0; i < n; i++) {
      sum = (a + b) % 1000000007;
      a = b;
      b = sum;
    }
    return a;
  }

}
