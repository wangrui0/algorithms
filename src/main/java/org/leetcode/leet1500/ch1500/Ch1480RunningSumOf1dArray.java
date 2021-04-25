package org.leetcode.leet1500.ch1500;

/**
 * <p>1480. 一维数组的动态和
 *
 * <p>给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 *
 * <p>请返回 nums 的动态和。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [1,2,3,4]
 * <p>输出：[1,3,6,10]
 * <p>解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [1,1,1,1,1]
 * <p>输出：[1,2,3,4,5]
 * <p>解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [3,1,2,10,1]
 * <p>输出：[3,4,6,16,17]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length <= 1000
 * <p>    -10^6 <= nums[i] <= 10^6
 *
 * <p>通过次数92,866
 * <p>提交次数108,880
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/running-sum-of-1d-array/
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1480RunningSumOf1dArray {

  public int[] runningSum(int[] nums) {
      for (int i = 1; i < nums.length; i++) {
        nums[i] += nums[i - 1];
      }
      return nums;
  }
}
