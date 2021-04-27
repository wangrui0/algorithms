package org.leetcode.leet2000.ch1800;

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
public class NCh1752CheckIfArrayIsSortedAndRotated {

  public boolean check(int[] nums) {
    return true;
  }
}
