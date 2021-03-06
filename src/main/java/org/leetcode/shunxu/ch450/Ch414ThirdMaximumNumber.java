package org.leetcode.shunxu.ch450;

import java.util.Arrays;

/**
 * <p> 414. 第三大的数
 *
 * <p>给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 *
 *
 * <p> 示例 1：
 *
 * <p>输入：[3, 2, 1]
 * <p>输出：1
 * <p> 解释：第三大的数是 1 。
 *
 * <p>示例 2：
 *
 * <p> 输入：[1, 2]
 * <p> 输出：2
 * <p>解释：第三大的数不存在, 所以返回最大的数 2 。
 *
 * <p>示例 3：
 *
 * <p>输入：[2, 2, 3, 1]
 * <p>输出：1
 * <p>解释：注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * <p>存在两个值为2的数，它们都排第二。
 *
 *
 *
 * <p>提示：
 *
 * <p>   1 <= nums.length <= 104
 * <p>   -231 <= nums[i] <= 231 - 1
 *
 *
 *
 * <p>进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 * <p>https://leetcode-cn.com/problems/third-maximum-number/
 *
 * @author: wangrui
 * @date: 2021/3/4
 */
public class Ch414ThirdMaximumNumber {
  /**
   * <p>输入：[2, 2, 3, 1]
   * <p>输出：1
   * <p>解释：注意，要求返回第三大的数，是指第三大且唯一出现的数。
   * <p>存在两个值为2的数，它们都排第二。
   * <p>时间复杂度:0(n)
   * <p>空间复杂度:0(1)
   *
   * @param nums
   * @return
   */
  public int thirdMax(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return nums[0];
    }
    if (n == 2) {
      return Math.max(nums[0], nums[1]);
    }
    long firstMax = Long.MIN_VALUE;
    long secondMax = Long.MIN_VALUE;
    long thirdMax = Long.MIN_VALUE;
    for (int v : nums) {
      //   输入：[2, 2, 3, 1]
      //   输出：1
      if (firstMax == v || secondMax == v) {
        continue;
      }
      if (v > firstMax) {
        thirdMax = secondMax;
        secondMax = firstMax;
        firstMax = v;
      } else if (v > secondMax) {
        thirdMax = secondMax;
        secondMax = v;
      } else if (v > thirdMax) {
        thirdMax = v;
      }
    }
    return thirdMax == Long.MIN_VALUE ? (int) firstMax : (int) thirdMax;
  }

  /**
   * 不是O(n)时间复杂度，是O(log(n))，先从小到大排序，然后从后往前找第三大的数
   *
   * @param nums
   * @return
   */
  public int thirdMax2(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    int k = 1;
    for (int i = n - 2; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) {
        k++;
        if (k == 3) {
          return nums[i];
        }
      }
    }
    return k < 3 ? nums[n - 1] : -1;
  }
}
