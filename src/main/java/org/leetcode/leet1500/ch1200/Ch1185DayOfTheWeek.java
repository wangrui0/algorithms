package org.leetcode.leet1500.ch1200;

/**
 * <p>1185. 一周中的第几天
 *
 * <p>给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 *
 * <p>输入为三个整数：day、month 和 year，分别表示日、月、年。
 *
 * <p>您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：day = 31, month = 8, year = 2019
 * <p>输出："Saturday"
 *
 * <p>示例 2：
 *
 * <p>输入：day = 18, month = 7, year = 1999
 * <p>输出："Sunday"
 *
 * <p>示例 3：
 *
 * <p>输入：day = 15, month = 8, year = 1993
 * <p>输出："Sunday"
 *
 *
 *
 * <p>提示：
 *
 * <p>    给出的日期一定是在 1971 到 2100 年之间的有效日期。
 *
 * <p>通过次数9,800
 * <p>提交次数16,036
 * <p>@author: wangrui
 * <p>@date: 2021/4/10
 */
public class Ch1185DayOfTheWeek {

  public String dayOfTheWeek(int day, int month, int year) {
    String[] weekStr = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    int sum = 4;//1971 第一天是星期4
    if (year > 1971) {
      for (int i = 1971; i < year; i++) {
        sum += 365;
        if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
          sum++;
        }
      }
    }
    int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    for (int i = 0; i < month - 1; i++) {
      sum += months[i];
    }
    if (month >= 3 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
      sum++;
    }
    sum += day;
    return weekStr[sum % 7];
  }
}
