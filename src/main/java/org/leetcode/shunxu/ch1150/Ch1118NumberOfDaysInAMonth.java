package org.leetcode.shunxu.ch1150;

/**
 * <p>LeetCode 1118. 一月有多少天（闰年判断）
 * <p>1. 题目
 * <p>指定年份 Y 和月份 M，请你帮忙计算出该月一共有多少天。
 *
 * <p>示例 1：
 * <p>输入：Y = 1992, M = 7
 * <p>输出：31
 *
 * <p>示例 2：
 * <p>输入：Y = 2000, M = 2
 * <p>输出：29
 *
 * <p>示例 3：
 * <p>输入：Y = 1900, M = 2
 * <p>输出：28
 *
 * <p>提示：
 * <p>1583 <= Y <= 2100
 * <p>1 <= M <= 12
 * <p>https://leetcode-cn.com/problems/number-of-days-in-a-month
 * <p>@author: wangrui
 * <p>@date: 2021/4/5
 */
public class Ch1118NumberOfDaysInAMonth {

  public int numberOfDays(int Y, int M) {
    int[] days = new int[]{
        0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };
    if (M != 2) {
      return days[M];
    }
    if (Y % 400 == 0 || Y % 4 == 0 && Y % 100 != 0) {
      return 29;
    }
    return 28;
  }
}
