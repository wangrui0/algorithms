package org.leetcode.leet1000.ch1000;

import java.util.Arrays;

/**
 * <p>976. 三角形的最大周长
 *
 * <p>给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 *
 * <p>如果不能形成任何面积不为零的三角形，返回 0。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：[2,1,2]
 * <p>输出：5
 *
 * <p>示例 2：
 *
 * <p>输入：[1,2,1]
 * <p>输出：0
 *
 * <p>示例 3：
 *
 * <p>输入：[3,2,3,4]
 * <p>输出：10
 *
 * <p>示例 4：
 *
 * <p>输入：[3,6,2,3]
 * <p>输出：8
 *
 *
 *
 * <p>提示：
 *
 * <p>    3 <= A.length <= 10000
 * <p>    1 <= A[i] <= 10^6
 *
 * <p>通过次数48,610
 * <p>提交次数81,358
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/4/2
 */
public class Ch976LargestPerimeterTriangle {

  public static int largestPerimeter(int[] nums) {
    Arrays.sort(nums);
    for (int i = nums.length - 1; i >= 2; i--) {
      if (nums[i] < nums[i - 1] + nums[i - 2]) {
        return nums[i] + nums[i - 1] + nums[i - 2];
      }
    }
    return -1;
  }

  /**
   * <p>复杂度分析
   *
   * <p> 时间复杂度：O(NlogN)，其中 N 是数组 A 的长度。
   *
   * <p> 空间复杂度：Ω(logN)
   *
   * @param A
   * @return
   */
  public int largestPerimeter_1(int[] A) {
    Arrays.sort(A);
    for (int i = A.length - 1; i >= 2; --i) {
      if (A[i - 2] + A[i - 1] > A[i]) {
        return A[i - 2] + A[i - 1] + A[i];
      }
    }
    return 0;
  }
}
