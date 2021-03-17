package org.leetcode.shunxu.ch600;

/**
 * <p>551. 学生出勤记录 I
 * <p>给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 *
 * <p>'A' : Absent，缺勤
 * <p>'L' : Late，迟到
 * <p>'P' : Present，到场
 * <p>如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 *
 * <p>你需要根据这个学生的出勤记录判断他是否会被奖赏。
 *
 * <p>示例 1:
 *
 *
 *
 * <p>输入: "PPALLP"
 * <p>输出: True
 * <p>示例 2:
 *
 * <p>输入: "PPALLL"
 * <p>输出: False
 * <p>通过次数24,588提交次数46,849
 * <p>https://leetcode-cn.com/problems/student-attendance-record-i/
 *
 * @Author: shenpei
 * @Date: 2021/3/15 8:08 下午
 */
public class Ch551StudentAttendanceRecordI {

  public boolean checkRecord(String s) {
    int count = 0;
    for (int i = 0; i < s.length() && count < 2; i++) {
      if (s.charAt(i) == 'A') {
        count++;
      }
    }
    return count < 2 && s.indexOf("LLL") < 0;

  }

  public boolean checkRecord2(String s) {
    int count = 0;
    for (int i = 0; i < s.length() && count < 2; i++) {
      if (s.charAt(i) == 'A') {
        count++;
      } else if (i + 2 < s.length() && s.charAt(i) == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
        return false;
      }
    }
    return count < 2;

  }

  /**
   * <p>官方：
   * <p>复杂度分析
   *
   * <p>  时间复杂度： O(n)。遍历字符串一次和 indexOf 方法需要花费 O(n) 的时间。
   * <p>  空间复杂度： O(1)。只使用了常数的空间。
   *
   * @param s
   * @return
   */
  public boolean checkRecord3(String s) {
    int count = 0;
    for (int i = 0; i < s.length() && count < 2; i++) {
      if (s.charAt(i) == 'A') {
        count++;
      }
    }
    return count < 2 && s.indexOf("LLL") < 0;
  }

  /**
   * <p>复杂度分析
   * <p>
   * <p>时间复杂度： O(n)。单遍循环的上限是字符串的长度。
   * <p>
   * <p>空间复杂度： O(1)。只使用了常数级别的空间。
   *
   * @param s
   * @return
   */
  public boolean checkRecord4(String s) {
    int countA = 0;
    for (int i = 0; i < s.length() && countA < 2; i++) {
      if (s.charAt(i) == 'A') {
        countA++;
      }
      if (i <= s.length() - 3 && s.charAt(i) == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
        return false;
      }
    }
    return countA < 2;
  }


}
