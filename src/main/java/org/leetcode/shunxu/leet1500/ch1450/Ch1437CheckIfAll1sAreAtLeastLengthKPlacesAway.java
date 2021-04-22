package org.leetcode.shunxu.leet1500.ch1450;

/**
 * <p>1437. 是否所有 1 都至少相隔 k 个元素
 *
 * <p>给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [1,0,0,0,1,0,0,1], k = 2
 * <p>输出：true
 * <p>解释：每个 1 都至少相隔 2 个元素。
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [1,0,0,1,0,1], k = 2
 * <p>输出：false
 * <p>解释：第二个 1 和第三个 1 之间只隔了 1 个元素。
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [1,1,1,1,1], k = 0
 * <p>输出：true
 *
 * <p>示例 4：
 *
 * <p>输入：nums = [0,1,0,1], k = 1
 * <p>输出：true
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length <= 10^5
 * <p>    0 <= k <= nums.length
 * <p>    nums[i] 的值为 0 或 1
 *
 * <p>通过次数8,522
 * <p>提交次数14,259
 * <p>请问您在哪类招聘中遇到此题？
 * <p>@author: wangrui
 * <p>@date: 2021/4/20
 */
public class Ch1437CheckIfAll1sAreAtLeastLengthKPlacesAway {

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(N)，其中 N 是数组 nums 的长度。
   *
   * <p>  空间复杂度：O(1)。
   *
   * @param nums
   * @param k
   * @return
   */
  public boolean kLengthApart(int[] nums, int k) {
    int n = nums.length;
    int prev = -1;
    for (int i = 0; i < n; ++i) {
      if (nums[i] == 1) {
        if (prev != -1 && i - prev - 1 < k) {
          return false;
        }
        prev = i;
      }
    }
    return true;
  }

  public static boolean kLengthApart_2(int[] nums, int k) {
    int pre = -1;
    for (int i = 0; i < nums.length; i++) {
      if (pre == -1 && nums[i] == 1) {
        pre = i;
      } else if (nums[i] == 1 && i - pre - 1 < k) {
        return false;
      } else if (nums[i] == 1 && i - pre - 1 >= k) {
        pre = i;
      }
    }
    return true;
  }
}

