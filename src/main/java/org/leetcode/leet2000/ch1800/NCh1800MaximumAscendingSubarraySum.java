package org.leetcode.leet2000.ch1800;

/**
 * <p>1800. 最大升序子数组和
 *
 * <p>给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 *
 * <p>子数组是数组中的一个连续数字序列。
 *
 * <p>已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1
 * 的子数组也视作 升序 子数组。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [10,20,30,5,10,50]
 * <p>输出：65
 * <p>解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [10,20,30,40,50]
 * <p>输出：150
 * <p>解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [12,17,15,13,10,11,12]
 * <p>输出：33
 * <p>解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。
 *
 * <p>示例 4：
 *
 * <p>输入：nums = [100,10,1]
 * <p>输出：100
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length <= 100
 * <p>    1 <= nums[i] <= 100
 *
 * <p>通过次数7,355
 * <p>提交次数10,730
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/maximum-ascending-subarray-sum/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:16 下午
 */
public class NCh1800MaximumAscendingSubarraySum {

  public int maxAscendingSum(int[] nums) {
    return -1;
  }
}
