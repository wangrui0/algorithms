package org.leetcode.shunxu.leet1000.ch900;

/**
 * <p>896. 单调数列
 *
 * <p>如果数组是单调递增或单调递减的，那么它是单调的。
 *
 * <p>如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 *
 * <p>当给定的数组 A 是单调数组时返回 true，否则返回 false。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：[1,2,2,3]
 * <p>输出：true
 *
 * <p>示例 2：
 *
 * <p>输入：[6,5,4,4]
 * <p>输出：true
 *
 * <p>示例 3：
 *
 * <p>输入：[1,3,2]
 * <p>输出：false
 *
 * <p>示例 4：
 *
 * <p>输入：[1,2,4,5]
 * <p>输出：true
 *
 * <p>示例 5：
 *
 * <p>输入：[1,1,1]
 * <p>输出：true
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= A.length <= 50000
 * <p>    -100000 <= A[i] <= 100000
 *
 * <p>通过次数54,173
 * <p>提交次数92,282
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/monotonic-array/
 * <p>@author: wangrui
 * <p>@date: 2021/3/22
 */
public class Ch896MonotonicArray {

  public static void main(String[] args) {
    System.out.println(isMonotonic(new int[]{1, 3, 2}));
//    System.out.println(isMonotonic(new int[]{1, 1, 0}));
//    System.out.println(isMonotonic(new int[]{6, 5, 4, 4}));
  }

  /**
   * <p> 复杂度分析
   *
   * <p>     时间复杂度：O(n)，其中 n 是数组 A 的长度。
   *
   * <p>     空间复杂度：O(1)。
   *
   * @param A
   * @return
   */
  public static boolean isMonotonic(int[] A) {
    boolean inc = true, dec = true;
    int n = A.length;
    for (int i = 0; i < n - 1; ++i) {
      if (A[i] > A[i + 1]) {
        inc = false;
      }
      if (A[i] < A[i + 1]) {
        dec = false;
      }
    }
    return inc || dec;
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(n)，其中 n 是数组 A 的长度。
   *
   * <p>  空间复杂度：O(1)。
   *
   * @param A
   * @return
   */
  public boolean isMonotonic2(int[] A) {
    return isSorted(A, true) || isSorted(A, false);
  }

  public boolean isSorted(int[] A, boolean increasing) {
    int n = A.length;
    if (increasing) {
      for (int i = 0; i < n - 1; ++i) {
        if (A[i] > A[i + 1]) {
          return false;
        }
      }
    } else {
      for (int i = 0; i < n - 1; ++i) {
        if (A[i] < A[i + 1]) {
          return false;
        }
      }
    }
    return true;
  }
}