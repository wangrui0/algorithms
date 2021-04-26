package org.leetcode.leet2000.ch1650;

/**
 * <p>1646. 获取生成数组中的最大值
 *
 * <p>给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 *
 * <p>    nums[0] = 0
 * <p>    nums[1] = 1
 * <p>    当 2 <= 2 *<p>i <= n 时，nums[2 *<p>i] = nums[i]
 * <p>    当 2 <= 2 *<p>i + 1 <= n 时，nums[2 *<p>i + 1] = nums[i] + nums[i + 1]
 *
 * <p>返回生成数组 nums 中的 最大 值。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：n = 7
 * <p>输出：3
 * <p>解释：根据规则：
 * <p>  nums[0] = 0
 * <p>  nums[1] = 1
 * <p>  nums[(1 *<p>2) = 2] = nums[1] = 1
 * <p>  nums[(1 *<p>2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
 * <p>  nums[(2 *<p>2) = 4] = nums[2] = 1
 * <p>  nums[(2 *<p>2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
 * <p>  nums[(3 *<p>2) = 6] = nums[3] = 2
 * <p>  nums[(3 *<p>2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
 * <p>因此，nums = [0,1,1,2,1,3,2,3]，最大值 3
 *
 * <p>示例 2：
 *
 * <p>输入：n = 2
 * <p>输出：1
 * <p>解释：根据规则，nums[0]、nums[1] 和 nums[2] 之中的最大值是 1
 *
 * <p>示例 3：
 *
 * <p>输入：n = 3
 * <p>输出：2
 * <p>解释：根据规则，nums[0]、nums[1]、nums[2] 和 nums[3] 之中的最大值是 2
 *
 *
 *
 * <p>提示：
 *
 * <p>    0 <= n <= 100
 *
 * <p>通过次数6,187
 * <p>提交次数12,254
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/get-maximum-in-generated-array/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 7:28 下午
 */
public class Ch1646GetMaximumInGeneratedArray {

  public int getMaximumGenerated(int n) {
    if(n==0){
      return 0;
    }
    if(n==1){
      return 1;
    }
    int max = 0;
    int[] nums = new int[n + 1];
    nums[0] = 0;
    nums[1] = 1;
    for (int i = 2; i <= n; i++) {
      if ((i & 1) == 0) {
        nums[i] = nums[i / 2];
      } else {
        nums[i] = nums[i / 2] + nums[i / 2 + 1];
      }
      max = Math.max(max, nums[i]);
    }
    return max;
  }
}
