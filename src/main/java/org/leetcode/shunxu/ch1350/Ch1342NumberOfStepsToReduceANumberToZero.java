package org.leetcode.shunxu.ch1350;

/**
 * <p>1342. 将数字变成 0 的操作次数
 *
 * <p>给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：num = 14
 * <p>输出：6
 * <p>解释：
 * <p>步骤 1) 14 是偶数，除以 2 得到 7 。
 * <p>步骤 2） 7 是奇数，减 1 得到 6 。
 * <p>步骤 3） 6 是偶数，除以 2 得到 3 。
 * <p>步骤 4） 3 是奇数，减 1 得到 2 。
 * <p>步骤 5） 2 是偶数，除以 2 得到 1 。
 * <p>步骤 6） 1 是奇数，减 1 得到 0 。
 *
 * <p>示例 2：
 *
 * <p>输入：num = 8
 * <p>输出：4
 * <p>解释：
 * <p>步骤 1） 8 是偶数，除以 2 得到 4 。
 * <p>步骤 2） 4 是偶数，除以 2 得到 2 。
 * <p>步骤 3） 2 是偶数，除以 2 得到 1 。
 * <p>步骤 4） 1 是奇数，减 1 得到 0 。
 *
 * <p>示例 3：
 *
 * <p>输入：num = 123
 * <p>输出：12
 *
 *
 *
 * <p>提示：
 *
 * <p>    0 <= num <= 10^6
 *
 * <p>通过次数37,870
 * <p>提交次数46,152
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 * <p>@author: wangrui
 * <p>@date: 2021/4/18
 */
public class Ch1342NumberOfStepsToReduceANumberToZero {

  public int numberOfSteps(int num) {
    int ans = 0;
    while (num != 0) {
      if (num % 2 == 0) {
        num /= 2;
      } else {
        num -= 1;
      }
      ans++;
    }
    return ans;
  }
}
