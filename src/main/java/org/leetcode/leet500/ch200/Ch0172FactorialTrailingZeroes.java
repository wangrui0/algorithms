package org.leetcode.leet500.ch200;

import java.math.BigInteger;

/**
 * <p> 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * <p> 示例 1:
 *
 * <p> 输入: 3
 * <p> 输出: 0
 * <p> 解释: 3! = 6, 尾数中没有零。
 * <p> 示例 2:
 *
 * <p> 输入: 5
 * <p> 输出: 1
 * <p> 解释: 5! = 120, 尾数中有 1 个零.
 * <p> 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/12/23
 */
public class Ch0172FactorialTrailingZeroes {

  /**
   * <p> 先算出结果，然后进行采用取余
   * <p>时间复杂度:O(n^2)
   * <p> 空间复杂度:O(nlogn)
   *
   * @param n
   * @return
   */
  public int trailingZeros(int n) {
    // Calculate n!
    BigInteger nFactorial = BigInteger.ONE;
    for (int i = 2; i <= n; i++) {
      nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
    }

    // Count how many 0's are on the end.
    int zeroCount = 0;

    while (nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
      nFactorial = nFactorial.divide(BigInteger.TEN);
      zeroCount++;
    }

    return zeroCount;
  }

  /**
   * 有几个0
   *
   * @param n
   * @return
   */
  public int trailingZero2(int n) {
    BigInteger nFactorial = BigInteger.ONE;
    for (int i = 2; i <= n; i++) {
      nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
    }
    int zeroCount = 0;
    while (nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
      nFactorial = nFactorial.divide(BigInteger.TEN);
      zeroCount++;
    }
    return zeroCount;
  }

  /**
   * <p></p>时间复杂度：O(n)
   * <p></p>空间复杂度:O(1)
   *
   * @param n
   * @return
   */
  public int trailingZero3(int n) {
    int zeroCount = 0;
    for (int i = 5; i <= n; i += 5) {
      int currentFactor = i;
      while (currentFactor % 5 == 0) {
        zeroCount++;
        currentFactor /= 5;
      }
    }
    return zeroCount;
  }

  /**
   * <p></p>时间复杂度：O(logn)
   * <p></p>空间复杂度：O(1)，只是用了常数空间
   *
   * @param n
   * @return
   */
  public int trailingZeroes(int n) {
    int zeroCount = 0;
    long currentMultiple = 5;
    while (n > 0) {
      n /= currentMultiple;
      zeroCount += n;
    }
    return zeroCount;
  }

  /**
   * self
   *
   * @param n
   * @return
   */
  public int trailingZeroes2(int n) {
    int zeroCount = 0;
    int currentMulti = 5;
    while (n > 0) {
      n /= currentMulti;
      zeroCount += n;
    }
    return zeroCount;
  }
}
