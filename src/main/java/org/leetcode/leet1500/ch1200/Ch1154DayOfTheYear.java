package org.leetcode.leet1500.ch1200;

/**
 * <p>一年中的第几天
 *
 * <p>给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。
 *
 * <p>通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：date = "2019-01-09"
 * <p>输出：9
 *
 * <p>示例 2：
 *
 * <p>输入：date = "2019-02-10"
 * <p>输出：41
 *
 * <p>示例 3：
 *
 * <p>输入：date = "2003-03-01"
 * <p>输出：60
 *
 * <p>示例 4：
 *
 * <p>输入：date = "2004-03-01"
 * <p>输出：61
 *
 *
 *
 * <p>提示：
 *
 * <p>    date.length == 10
 * <p>    date[4] == date[7] == '-'，其他的 date[i] 都是数字。
 * <p>    date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日。
 * https://leetcode-cn.com/problems/day-of-the-year/
 * <p>通过次数11,653
 * <p>提交次数21,058
 * <p>@author: wangrui
 * <p>@date: 2021/4/9
 */
public class Ch1154DayOfTheYear {

  public static int dayOfYear(String date) {

    int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 30, 31, 30, 31, 31, 30};

    int year = Integer.valueOf(date.substring(0, 4));
    int month = Integer
        .parseInt(date.substring(5, 7).charAt(0) == '0' ? date.substring(6, 7) : date.substring(5, 7));

    int day = Integer
        .parseInt(date.substring(8, 10).charAt(0) == '0' ? date.substring(9, 10) : date.substring(8, 10));
    int sum = 0;
    for (int i = 1; i < month; i++) {
      if (i == 2 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
        sum += 29;
      } else {
        sum += days[i];
      }
    }
    sum += day;
    return sum;
  }
}
