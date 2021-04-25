package org.leetcode.leet1500.ch1450;

/**
 * <p>1413. 逐步求和得到正数的最小值
 *
 * <p>给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
 *
 * <p>你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
 *
 * <p>请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [-3,2,-3,4,2]
 * <p>输出：5
 * <p>解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
 * <p>                累加求和
 * <p>                startValue = 4 | startValue = 5 | nums
 * <p>                  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
 * <p>                  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
 * <p>                  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
 * <p>                  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
 * <p>                  (4 +2 ) = 6  | (5 +2 ) = 7    |   2
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [1,2]
 * <p>输出：1
 * <p>解释：最小的 startValue 需要是正数。
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [1,-2,-3]
 * <p>输出：5
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length <= 100
 * <p>    -100 <= nums[i] <= 100
 *
 * <p>通过次数8,930
 * <p>提交次数13,003
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/minimum-value-to-get-positive-step-by-step-sum/
 * <p>@author: wangrui
 * <p>@date: 2021/4/18
 */
public class Ch1413MinimumValueToGetPositiveStepByStepSum {

  public int minStartValue(int[] nums) {
    int min = Integer.MAX_VALUE;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      min = Math.min(sum, min);
    }
    if (min >= 1) {
      return 1;
    } else {
      return 1 - min;
    }
  }

  public int minStartValue_2(int[] nums) {
    int start = 0;
    int sum = 0;
    for (int i = 0; i < nums.length; ++i) {
      sum += nums[i];
      if (start + sum < 0) {
        start = -sum;
      }
    }
    return 1 + start;
  }

}
