package org.leetcode.leet1000.ch750;

import java.util.Arrays;

/**
 * <p>724. 寻找数组的中心下标
 *
 * <p>给你一个整数数组 nums，请编写一个能够返回数组 “中心下标” 的方法。
 *
 * <p>数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * <p>如果数组不存在中心下标，返回 -1 。如果数组有多个中心下标，应该返回最靠近左边的那一个。
 *
 * <p>注意：中心下标可能出现在数组的两端。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [1, 7, 3, 6, 5, 6]
 * <p>输出：3
 * <p>解释：
 * <p>中心下标是 3 。
 * <p>左侧数之和 (1 + 7 + 3 = 11)，
 * <p>右侧数之和 (5 + 6 = 11) ，二者相等。
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [1, 2, 3]
 * <p>输出：-1
 * <p>解释：
 * <p>数组中不存在满足此条件的中心下标。
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [2, 1, -1]
 * <p>输出：0
 * <p>解释：
 * <p>中心下标是 0 。
 * <p>下标 0 左侧不存在元素，视作和为 0 ；
 * <p>右侧数之和为 1 + (-1) = 0 ，二者相等。
 *
 *
 *
 * <p>提示：
 *
 * <p>    nums 的长度范围为 [0, 10000]。
 * <p>    任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 * <p> https://leetcode-cn.com/problems/find-pivot-index/
 * <p>通过次数109,061
 * <p>提交次数249,984
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/23
 */
public class Ch724FindPivotIndex {

  public int pivotIndex(int[] nums) {
    int total = Arrays.stream(nums).sum();
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (2 * sum + num == total) {
        return i;
      }
      sum += num;
    }
    return -1;
  }

  /**
   * <p>复杂度分析
   *
   * <p> 时间复杂度：O(n)，其中 n 为数组的长度。
   *
   * <p>空间复杂度：O(1)。
   *
   * @param nums
   * @return
   */
  public int pivotIndex2(int[] nums) {
    int total = Arrays.stream(nums).sum();
    int sum = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (2 * sum + nums[i] == total) {
        return i;
      }
      sum += nums[i];
    }
    return -1;
  }

}
