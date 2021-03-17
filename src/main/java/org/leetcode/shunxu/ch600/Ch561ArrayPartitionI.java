package org.leetcode.shunxu.ch600;

import java.util.Arrays;

/**
 * <p>561. 数组拆分 I
 * <p>给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
 *
 * <p>返回该 最大总和 。
 *
 *
 *
 * <p> 示例 1：
 *
 * <p>输入：nums = [1,4,3,2]
 * <p>输出：4
 * <p>解释：所有可能的分法（忽略元素顺序）为：
 * <p>1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * <p>2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * <p>3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * <p>所以最大总和为 4
 * <p>示例 2：
 *
 * <p>输入：nums = [6,2,6,5,1,2]
 * <p>输出：9
 * <p>解释：最优的分法为 (2, 1), (2, 5), (6, 6).
 * <p>min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9
 *
 *
 * <p>提示：
 *
 * <p>1 <= n <= 104
 * <p>nums.length == 2 * n
 * <p>-104 <= nums[i] <= 104
 * <p>通过次数77,264提交次数100,577
 * <p>https://leetcode-cn.com/problems/array-partition-i/
 *
 * @Author: shenpei
 * @Date: 2021/3/15 8:07 下午
 */
public class Ch561ArrayPartitionI {

  public int arrayPairSum(int[] nums) {
    Arrays.sort(nums);
    int sum = 0;
    for (int i = 0; i < nums.length; i += 2) {
      sum += nums[i];
    }
    return sum;
  }

  /**
   * 复杂度分析
   *
   *     时间复杂度：O(nlogn)，即为对数组 nums 进行排序的时间复杂度。
   *
   *     空间复杂度：O(logn)，即为排序需要使用的栈空间。
   *
   * @param nums
   * @return
   */
  public int arrayPairSum3(int[] nums) {
    Arrays.sort(nums);
    int ans = 0;
    for (int i = 0; i < nums.length; i += 2) {
      ans += nums[i];
    }
    return ans;
  }

}
