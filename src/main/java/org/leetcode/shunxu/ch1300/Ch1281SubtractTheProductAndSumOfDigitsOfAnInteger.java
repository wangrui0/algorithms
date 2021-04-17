package org.leetcode.shunxu.ch1300;

/**
 * <p>1281. 整数的各位积和之差
 *
 * <p>给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：n = 234
 * <p>输出：15
 * <p>解释：
 * <p>各位数之积 = 2 *3 *4 = 24
 * <p>各位数之和 = 2 + 3 + 4 = 9
 * <p>结果 = 24 - 9 = 15
 *
 * <p>示例 2：
 *
 * <p>输入：n = 4421
 * <p>输出：21
 * <p>解释：
 * <p>各位数之积 = 4 *4 *2 *1 = 32
 * <p>各位数之和 = 4 + 4 + 2 + 1 = 11
 * <p>结果 = 32 - 11 = 21
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= n <= 10^5
 *
 * <p>通过次数41,013
 * <p>提交次数49,411
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * <p>@author: wangrui
 * <p>@date: 2021/4/12
 */
public class Ch1281SubtractTheProductAndSumOfDigitsOfAnInteger {

  public int subtractProductAndSum(int n) {
    int add = 0, mul = 1;
    while (n > 0) {
      int digit = n % 10;
      add += digit;
      mul *= digit;
      n/=10;
    }
    return mul-add  ;
  }
}
