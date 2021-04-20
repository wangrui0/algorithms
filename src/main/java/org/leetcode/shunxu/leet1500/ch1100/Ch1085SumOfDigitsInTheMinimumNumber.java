package org.leetcode.shunxu.leet1500.ch1100;

/**
 * 最小元素各数位之和
 * <p>1. 题目
 * <p>给你一个正整数的数组 A。
 *
 * <p>然后计算 S，使其等于数组 A 当中最小的那个元素各个数位上数字之和。
 *
 * <p>最后，假如 S 所得计算结果是 奇数 的请你返回 0，否则请返回 1。
 *
 * <p>示例 1:
 * <p>输入：[34,23,1,24,75,33,54,8]
 * <p>输出：0
 * <p>解释：
 * <p>最小元素为 1，该元素各个数位上的数字之和 S = 1，是奇数所以答案为 0。
 *
 * <p>示例 2：
 * <p>输入：[99,77,33,66,55]
 * <p>输出：1
 * <p>解释：
 * <p>最小元素为 33，该元素各个数位上的数字之和 S = 3 + 3 = 6，是偶数所以答案为 1。
 *
 * <p>提示：
 * <p>1 <= A.length <= 100
 * <p>1 <= A[i].length <= 100
 * https://leetcode-cn.com/problems/sum-of-digits-in-the-minimum-number/
 * <p>@author: wangrui
 * <p>@date: 2021/4/5
 */
public class Ch1085SumOfDigitsInTheMinimumNumber {

  public int sumOfDigits_self(int[] A) {
    int min = A[0];
    for (int i = 1; i < A.length; i++) {
      if (min > A[i]) {
        min = A[i];
      }
    }
    int ans = 0;
    while (min > 0) {
      ans += min % 10;
      min /= 10;
    }
    return ans % 2 == 0 ? 1 : 0;
  }

  public int sumOfDigits(int[] A) {
    int min = A[0];
    for (int n : A) {
      if (n < min) {
        min = n;
      }
    }
    int sum = 0;
    int n = 0;
    while (min != 0) {
      n = min % 10;
      sum += n;
      min = min / 10;
    }
    return sum % 2 == 0 ? 1 : 0;
  }
}
