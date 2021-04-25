package org.leetcode.leet1500.ch1350;

/**
 * <p>1317. 将整数转换为两个无零整数的和
 *
 * <p>「无零整数」是十进制表示中 不含任何 0 的正整数。
 *
 * <p>给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
 *
 * <p>    A 和 B 都是无零整数
 * <p>    A + B = n
 *
 * <p>题目数据保证至少有一个有效的解决方案。
 *
 * <p>如果存在多个有效解决方案，你可以返回其中任意一个。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：n = 2
 * <p>输出：[1,1]
 * <p>解释：A = 1, B = 1. A + B = n 并且 A 和 B 的十进制表示形式都不包含任何 0 。
 *
 * <p>示例 2：
 *
 * <p>输入：n = 11
 * <p>输出：[2,9]
 *
 * <p>示例 3：
 *
 * <p>输入：n = 10000
 * <p>输出：[1,9999]
 *
 * <p>示例 4：
 *
 * <p>输入：n = 69
 * <p>输出：[1,68]
 *
 * <p>示例 5：
 *
 * <p>输入：n = 1010
 * <p>输出：[11,999]
 *
 *
 *
 * <p>提示：
 *
 * <p>    2 <= n <= 10^4
 *
 * <p>通过次数8,823
 * <p>提交次数14,375
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
 * <p>@author: wangrui
 * <p>@date: 2021/4/12
 */
public class Ch1317ConvertIntegerToTheSumOfTwoNoZeroIntegers {

  /**
   * 复杂度分析
   *
   *     时间复杂度：O(NlogN)，枚举 A 的时间复杂度为 O(N)，判断 A 和 B 是否均不包含 0 的时间复杂度为 O(logN)，即 A 与 B 的位数之和。
   *
   *     空间复杂度：O(1)。
   *
   * @param n
   * @return
   */
  public int[] getNoZeroIntegers(int n) {
    for (int i = 1; i < n; i++) {
      if (isNoZero(i) && isNoZero(n - i)) {
        return new int[]{i, n - i};
      }
    }
    return null;
  }

  public boolean isNoZero(int num) {
    while (num > 0) {
      if (num % 10 == 0) {
        return false;
      }
      num /= 10;
    }
    return true;
  }
}
