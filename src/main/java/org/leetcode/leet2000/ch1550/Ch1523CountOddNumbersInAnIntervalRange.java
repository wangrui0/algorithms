package org.leetcode.leet2000.ch1550;

/**
 * <p>1523. 在区间范围内统计奇数数目
 *
 * <p>给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：low = 3, high = 7
 * <p>输出：3
 * <p>解释：3 到 7 之间奇数数字为 [3,5,7] 。
 *
 * <p>示例 2：
 *
 * <p>输入：low = 8, high = 10
 * <p>输出：1
 * <p>解释：8 到 10 之间奇数数字为 [9] 。
 *
 *
 *
 * <p>提示：
 *
 * <p>    0 <= low <= high <= 10^9
 *
 * <p>通过次数8,091
 * <p>提交次数14,187
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/count-odd-numbers-in-an-interval-range/
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1523CountOddNumbersInAnIntervalRange {

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(1)。
   *
   * <p> 空间复杂度：O(1)。
   *
   * @param low
   * @param high
   * @return
   */
  public int countOdds(int low, int high) {
    return pre(high) - pre(low - 1);
  }

  public int pre(int x) {
    return (x + 1) >> 1;
  }

  /**
   * self
   *
   * @param low
   * @param high
   * @return
   */
  public int countOdds_self(int low, int high) {
    if ((low & 1) == 0 && (high & 1) == 0) {
      return (high - low) / 2;
    }
    return (high - low) / 2 + 1;
  }


}
