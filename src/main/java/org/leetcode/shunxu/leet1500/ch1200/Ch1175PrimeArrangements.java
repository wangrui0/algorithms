package org.leetcode.shunxu.leet1500.ch1200;

/**
 * <p>1175. 质数排列
 *
 * <p>请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
 *
 * <p>让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
 *
 * <p>由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：n = 5
 * <p>输出：12
 * <p>解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
 *
 * <p>示例 2：
 *
 * <p>输入：n = 100
 * <p>输出：682289015
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= n <= 100
 *
 * <p>通过次数6,093
 * <p>提交次数12,624
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/prime-arrangements/
 * <p>@author: wangrui
 * <p>@date: 2021/4/10
 */
public class Ch1175PrimeArrangements {

  /**
   * <p>解题思路
   *
   * <p>直接撸出100以内的25个质数，计算n以内质数的个数和合数的个数
   * <p>然后质数全排列乘以合数全排列，在计算时要及时取模防止溢出
   *
   * @param n
   * @return
   */
  public int numPrimeArrangements(int n) {
    int[] zhishu = {
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
        83, 89, 97
    };
    //计算质数个数
    int nzhishu = 0;
    for (int c : zhishu) {
      if (n >= c) {
        nzhishu++;
      }
    }
    //计算非质数的个数
    int nfeizhishu = n - nzhishu;
    long ans = 1;
    for (int i = nfeizhishu; i > 1; i--) {
      if (ans < 1000000007 / i) {
        ans *= i;
      } else {
        ans = ans * i % 1000000007;
      }
    }
    for (int i = nzhishu; i > 1; i--) {
      if (ans < 1000000007 / i) {
        ans *= i;
      } else {
        ans = ans * i % 1000000007;
      }
    }
    return (int) ans % 1000000007;
  }

  public int numPrimeArrangements_2(int n) {
    if (n <= 2) {
      return 1;
    }
    int prime = 2;
    for (int i = 4; i <= n; i++) {
      if (isPrime(i) == true) {
        prime++;
      }
    }
    return (int) (calculate(prime) * calculate(n - prime) % 1000000007);
  }

  private boolean isPrime(int n) {
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  private long calculate(int n) {
    long res = 1;
    for (int i = 2; i <= n; i++) {
      res *= i;
      res %= 1000000007;
    }
    return res;
  }

}
