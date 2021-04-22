package org.leetcode.shunxu.leet1500.ch1500;

import java.util.Arrays;

/**
 * <p>1464. 数组中两元素的最大乘积
 *
 * <p>给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 *
 * <p>请你计算并返回该式的最大值。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [3,4,5,2]
 * <p>输出：12
 * <p>解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [1,5,4,5]
 * <p>输出：16
 * <p>解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [3,7]
 * <p>输出：12
 *
 *
 *
 * <p>提示：
 *
 * <p>    2 <= nums.length <= 500
 * <p>    1 <= nums[i] <= 10^3
 *
 * <p>通过次数22,324
 * <p>提交次数29,088
 * <p>请问您在哪类招聘中遇到此题？
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1464MaximumProductOfTwoElementsInAnArray {

  public int maxProduct(int[] nums) {
    Arrays.sort(nums);
    return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
  }

  public int maxProduct_2(int[] nums) {
    int max1 = 0, max2 = 0; //max1为最大值,max2为次大值
    for (int num : nums) {
      if (num > max1) {    //若num大于之前的最大值,则现在最大值是num,次大值是max1
        max2 = max1;
        max1 = num;
      } else if (num > max2) {
        max2 = num;
      }
    }
    return (max1 - 1) * (max2 - 1);
  }

  public static int maxProduct_3(int[] nums) {
    int maxValue = 0, secondMaxValue = 0;
    for (int x : nums) {
      if (x > maxValue) {
        secondMaxValue = maxValue;
        maxValue = x;
      } else if (x > secondMaxValue) {
        secondMaxValue = x;
      }
    }
    return (maxValue - 1) * (secondMaxValue - 1);
  }


}
