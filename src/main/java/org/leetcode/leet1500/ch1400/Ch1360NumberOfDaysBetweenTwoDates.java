package org.leetcode.leet1500.ch1400;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * <p>1360. 日期之间隔几天
 *
 * <p>请你编写一个程序来计算两个日期之间隔了多少天。
 *
 * <p>日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：date1 = "2019-06-29", date2 = "2019-06-30"
 * <p>输出：1
 *
 * <p>示例 2：
 *
 * <p>输入：date1 = "2020-01-15", date2 = "2019-12-31"
 * <p>输出：15
 *
 *
 *
 * <p>提示：
 *
 * <p>    给定的日期是 1971 年到 2100 年之间的有效日期。
 *
 * <p>通过次数7,320
 * <p>提交次数14,744
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/number-of-days-between-two-dates/
 */
public class Ch1360NumberOfDaysBetweenTwoDates {

  private static final int[] MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  private static boolean isLeapYear(int year) {
    return (year % 100 != 0 && year % 4 == 0) || year % 400 == 0;
  }

  // 计算Y-M-D距离1970-1-1日（星期一）相差了多少天
  private int calculate(String y, String m, String d) {

    int year = Integer.parseInt(y);
    int month = Integer.parseInt(m);

    int days = 0;
    for (int i = 1970; i < year; ++i) {
      MONTHS[1] = isLeapYear(i) ? 29 : 28;
      for (int j = 0; j < 12; ++j) {
        days += MONTHS[j];
      }
    }

    MONTHS[1] = isLeapYear(year) ? 29 : 28;
    for (int i = 0; i < month - 1; ++i) {
      days += MONTHS[i];
    }

    return days + Integer.parseInt(d);
  }

  // 算法思想：
  // Idea1:  先计算出两个日期距离1970-1-1（星期一）相差了多少天，然后再计算这两个天数差的绝对值.
  public int daysBetweenDates(String date1, String date2) {

    String[] splits = date1.split("-");
    int days1 = calculate(splits[0], splits[1], splits[2]);

    splits = date2.split("-");
    int days2 = calculate(splits[0], splits[1], splits[2]);

    return Math.abs(days1 - days2);
  }

  // API思想:
  // Idea2: 利用 JAVA 8 DATE/Time API -- 线程安全的
  public int daysBetweenDatesII(String date1, String date2) {
    LocalDate d1 = LocalDate.parse(date1);
    LocalDate d2 = LocalDate.parse(date2);
    return Math.abs((int) ChronoUnit.DAYS.between(d1, d2));
  }


  public int toDay(String dateStr) {
    String[] temp = dateStr.split("-");
    int year = Integer.valueOf(temp[0]);
    int month = Integer.valueOf(temp[1]);
    int day = Integer.valueOf(temp[2]);

    if (month <= 2) {
      year--;
      month += 10;
    } else {
      month -= 2;
    }
    return 365 * year + year / 4 - year / 100 + year / 400 + 30 * month + (3 * month - 1) / 5 + day /*- 584418*/;
  }

  public int daysBetweenDates_3(String date1, String date2) {
    return Math.abs(toDay(date1) - toDay(date2));
  }

}
