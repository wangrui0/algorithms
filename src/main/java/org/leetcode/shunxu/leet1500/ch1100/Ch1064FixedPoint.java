package org.leetcode.shunxu.leet1500.ch1100;

/**
 * <p>不动点
 * <p>1. 题目
 * <p>给定已经按升序排列、由不同整数组成的数组 A，返回满足 A[i] == i 的最小索引 i。
 * <p> 如果不存在这样的 i，返回 -1。
 *
 * <p>示例 1：
 * <p>输入：[-10,-5,0,3,7]
 * <p>输出：3
 * <p>解释：
 * <p>对于给定的数组，A[0] = -10，A[1] = -5，A[2] = 0，A[3] = 3，因此输出为 3 。
 *
 * <p>示例 2：
 * <p>输入：[0,2,5,8,17]
 * <p>输出：0
 * <p>示例：
 * <p>A[0] = 0，因此输出为 0 。
 *
 * <p>示例 3：
 * <p>输入：[-10,-5,3,4,7,9]
 * <p>输出：-1
 * <p>解释：
 * <p>不存在这样的 i 满足 A[i] = i，因此输出为 -1 。
 *
 * <p>提示：
 * <p>1 <= A.length < 10^4
 * <p>-10^9 <= A[i] <= 10^9
 * <p>https://leetcode-cn.com/problems/fixed-point/
 * <p>@author: wangrui
 * <p>@date: 2021/4/5
 */
public class Ch1064FixedPoint {

  /**
   * 暴力法
   *
   * @param A
   * @return
   */
  public static int fixedPoint_1(int[] A) {
    for (int i = 0; i < A.length; i++) {
      if (i == A[i]) {
        return i;
      }
    }
    return -1;
  }

  /**
   * 官方
   *
   * @param A
   * @return
   */
  public static int fixedPoint_2(int[] A) {
    int left = 0;
    int right = A.length - 1;
    int mid = 0;
    while (left < right) {
      mid = (left + right) / 2;
      if (A[mid] < mid) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return A[left] == left ? left : -1;
  }

  public static int fixedPoint_3(int[] A) {
    int left = 0;
    int right = A.length - 1;
    int mid = 0;
    while (left < right) {
      mid = (left + right) / 2;
      if (A[mid] < mid) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return A[right] == right ? right : -1;
  }


  public static int fixedPoint_self(int[] A) {
    int left = 0, right = A.length - 1;
    int mid;
    while (left < right) {
      mid = left + (right - left) / 2;
      if (A[mid] == mid) {
        return mid;
      } else if (A[mid] < mid) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}
