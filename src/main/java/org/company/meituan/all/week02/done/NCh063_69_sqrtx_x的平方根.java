package org.company.meituan.all.week02.done;

import java.util.List;

/**
 * 69. x 的平方根 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4 输出: 2 示例 2:
 * <p>
 * 输入: 8 输出: 2 说明: 8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。 通过次数309,388提交次数788,468 请问您在哪类招聘中遇到此题？ 贡献者 LeetCode
 * https://leetcode-cn.com/problems/sqrtx/
 *
 * @Author: shenpei
 * @Date: 2021/5/17 6:23 下午
 */
public class NCh063_69_sqrtx_x的平方根 {

  public static void main(String[] args) {
    System.out.println(mySqrt_self(2147395599));
  }

  public static int mySqrt_self(int x) {
    if (x == 1) {
      return 1;
    }
    return binarySearch(1, x / 2, x);
  }

  public static int binarySearch(long left, long right, long target) {
    while (left <= right) {
      long mid = left + (right - left) / 2;
      if (mid * mid == target) {
        return Integer.valueOf(String.valueOf(mid));
      } else if (mid * mid < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return Integer.valueOf(String.valueOf(left - 1));
  }

  public int mySqrt(int x) {
    int l = 0, r = x, ans = -1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if ((long) mid * mid <= x) {
        ans = mid;
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return ans;
  }


}
