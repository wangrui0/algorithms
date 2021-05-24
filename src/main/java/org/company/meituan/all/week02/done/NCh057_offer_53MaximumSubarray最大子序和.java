package org.company.meituan.all.week02.done;

/**
 * <p>53. 最大子序和
 *
 * <p>给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * <p>输出：6
 * <p>解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [1]
 * <p>输出：1
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [0]
 * <p>输出：0
 *
 * <p>示例 4：
 *
 * <p>输入：nums = [-1]
 * <p>输出：-1
 *
 * <p>示例 5：
 *
 * <p>输入：nums = [-100000]
 * <p>输出：-100000
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length <= 3 *<p>104
 * <p>    -105 <= nums[i] <= 105
 *
 *
 *
 * <p>进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 * <p>通过次数516,802
 * <p>提交次数953,482
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/maximum-subarray/
 * <p>@author: wangrui
 * <p>@date: 2021/5/14
 */
public class NCh057_offer_53MaximumSubarray最大子序和 {

  /**
   * 方法一：动态规划 (以每个元素为结尾的子数组之最大值)
   *
   * @param nums
   * @return
   */
  public int maxSubArray(int[] nums) {
    int pre = 0, ans = nums[0];
    for (int i = 0; i < nums.length; i++) {
      pre = Math.max(pre + nums[i], nums[i]);
      ans = Math.max(pre, ans);
    }
    return ans;
  }
}
