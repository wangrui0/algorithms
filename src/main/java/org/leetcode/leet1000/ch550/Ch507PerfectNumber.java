package org.leetcode.leet1000.ch550;

/**
 * <p> 507. 完美数
 *
 * <p>对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 *
 * <p>给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：28
 * <p>输出：True
 * <p>解释：28 = 1 + 2 + 4 + 7 + 14
 * <p>1, 2, 4, 7, 和 14 是 28 的所有正因子。
 *
 * <p>示例 2：
 *
 * <p>输入：num = 6
 * <p>输出：true
 *
 * <p>示例 3：
 *
 * <p>输入：num = 496
 * <p>输出：true
 *
 * <p>示例 4：
 *
 * <p>输入：num = 8128
 * <p>输出：true
 *
 * <p>示例 5：
 *
 * <p>输入：num = 2
 * <p>输出：false
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= num <= 108
 *
 * <p>通过次数23,094
 * <p>提交次数58,521
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/perfect-number/
 *
 * @author: wangrui
 * @date: 2021/3/13
 */
public class Ch507PerfectNumber {

  /**
   * self
   *
   * @param num
   * @return
   */
  public static boolean checkPerfectNumber(int num) {
    if (num <= 1) {
      return false;
    }
    int sum = 1;
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) {
        sum += i;
        if (i * i != num) {
          sum += (num / i);
        }
      }
    }
    return sum == num;
  }

  /**
   * <p>时间复杂度:O(sqrt(n))
   * <p>空间复杂度：1
   *
   * @param num
   * @return
   */
  public boolean checkPerfectNumber2(int num) {
    if (num <= 0) {
      return false;
    }
    int sum = 0;
    for (int i = 1; i * i <= num; i++) {
      if (num % i == 0) {
        sum += i;
        if (i * i != num) {
          sum += num / i;
        }

      }
    }
    return sum - num == num;
  }

  public int pn(int p) {
    return (1 << (p - 1)) * ((1 << p) - 1);
  }

  /**
   * 最小的Perfect Number是6，接着是28，然后是496
   * <p>
   * 6: 2×3 true
   * <p>
   * 28: 4×7 true
   * <p>
   * 120: 8×15 false
   * <p>
   * 496: 16×31 true
   * <p>
   * 2016: 32×63 false
   * <p>
   * <p>8128: 64×127 true
   * <p>上面这些数，可以看做2的(n-1)次方与2的n次方再减1的乘积，其中n从2开始，但是并非所有的n都符合，在上面几个数中，
   * <p>当n等于4和6时是不符合Perfect Number的，这里直接给出符合的数吧，2,3,5,7,13,17,19,31，至于17,19,31这几个次方数，
   * <p>做乘法会溢出，可以直接不考虑，至于为什么是这几个数，可以一个一个往下推，不难。当然，
   * <p>你要是把int范围内的5个Perfect Number(第5个是33550336)都找出来了，直接做判断也行。
   *==============================
   *  <p>时间复杂度:O(sqrt(1))
   *  <p>空间复杂度：1
   * @param num
   * @return
   */
  public boolean checkPerfectNumber3(int num) {
    int[] primes = new int[]{2, 3, 5, 7, 13, 17, 19, 31};
    for (int prime : primes) {
      if (pn(prime) == num) {
        return true;
      }
    }
    return false;
  }


}
