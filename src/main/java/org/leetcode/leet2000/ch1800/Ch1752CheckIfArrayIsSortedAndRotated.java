package org.leetcode.leet2000.ch1800;

import java.util.Arrays;

/**
 * <p>1752. 检查数组是否经排序和轮转得到
 *
 * <p>给你一个数组 nums 。nums 的源数组中，所有元素与 nums 相同，但按非递减顺序排列。
 *
 * <p>如果 nums 能够由源数组轮转若干位置（包括 0 个位置）得到，则返回 true ；否则，返回 false 。
 *
 * <p>源数组中可能存在 重复项 。
 *
 * <p>注意：我们称数组 A 在轮转 x 个位置后得到长度相同的数组 B ，当它们满足 A[i] == B[(i+x) % A.length] ，其中 % 为取余运算。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [3,4,5,1,2]
 * <p>输出：true
 * <p>解释：[1,2,3,4,5] 为有序的源数组。
 * <p>可以轮转 x = 3 个位置，使新数组从值为 3 的元素开始：[3,4,5,1,2] 。
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [2,1,3,4]
 * <p>输出：false
 * <p>解释：源数组无法经轮转得到 nums 。
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [1,2,3]
 * <p>输出：true
 * <p>解释：[1,2,3] 为有序的源数组。
 * <p>可以轮转 x = 0 个位置（即不轮转）得到 nums 。
 *
 * <p>示例 4：
 *
 * <p>输入：nums = [1,1,1]
 * <p>输出：true
 * <p>解释：[1,1,1] 为有序的源数组。
 * <p>轮转任意个位置都可以得到 nums 。
 *
 * <p>示例 5：
 *
 * <p>输入：nums = [2,1]
 * <p>输出：true
 * <p>解释：[1,2] 为有序的源数组。
 * <p>可以轮转 x = 5 个位置，使新数组从值为 2 的元素开始：[2,1] 。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length <= 100
 * <p>    1 <= nums[i] <= 100
 *
 * <p>通过次数8,021
 * <p>提交次数11,230
 * <p>https://leetcode-cn.com/problems/check-if-array-is-sorted-and-rotated/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:05 下午
 */
public class Ch1752CheckIfArrayIsSortedAndRotated {

  /**
   * <p>感觉有点问题，但是leetcode 过了
   * <p>如果经过了轮转。数组起始一定大于结束，有且只有一次是非递增的。如 5 一定大于 2，起点在1变化。
   *
   * @param nums
   * @return
   */
  public boolean check(int[] nums) {
    int n = nums.length;
    //有经过轮转
    boolean isCount = nums[0] >= nums[n - 1];

    for (int i = 1; i < n; i++) {

      if (nums[i] < nums[i - 1]) {
        if (isCount) {
          isCount = false;
        } else {
          return false;
        }
      }

    }
    return true;
  }

  /*
        执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
        内存消耗：36.2 MB, 在所有 Java 提交中击败了100.00%的用户
    */
  public boolean check_2(int[] nums) {
    int i = 0;
    for (i = 1; i < nums.length; ) {
      if (nums[i] >= nums[i - 1]) {
        i++;
      } else {
        break;
      }
    }
    if (i == nums.length) {
      return true;
    }

    for (; i < nums.length - 1; ) {
      if (nums[i + 1] >= nums[i]) {
        i++;
      } else {
        break;
      }
    }
    if (i == nums.length - 1 && nums[nums.length - 1] <= nums[0]) {
      return true;
    }
    return false;
  }

  public boolean check_3(int[] nums) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < nums.length; i++) {
      sb.append((char) nums[i]);
    }
    Arrays.sort(nums);
    StringBuilder sb1 = new StringBuilder();
    for (int i = 0; i < nums.length; i++) {
      sb1.append((char) nums[i]);
    }
    return ("" + sb1 + sb1).contains(sb);
  }

}
