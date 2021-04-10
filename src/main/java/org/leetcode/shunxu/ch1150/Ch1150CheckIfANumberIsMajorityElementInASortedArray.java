package org.leetcode.shunxu.ch1150;

/**
 * <p>1150. 检查一个数是否在数组中占绝大多数（二分查找）
 * <p>1. 题目
 * <p>给出一个按 非递减 顺序排列的数组 nums，和一个目标数值 target。
 * <p> 假如数组 nums 中绝大多数元素的数值都等于 target，则返回 True，否则请返回 False。
 *
 * <p>所谓占绝大多数，是指在长度为 N 的数组中出现必须 超过 N/2 次。
 *
 * <p>示例 1：
 * <p>输入：nums = [2,4,5,5,5,5,5,6,6], target = 5
 * <p>输出：true
 * <p>解释：
 * <p>数字 5 出现了 5 次，而数组的长度为 9。
 * <p>所以，5 在数组中占绝大多数，因为 5 次 > 9/2。
 *
 * <p>示例 2：
 * <p>输入：nums = [10,100,101,101], target = 101
 * <p>输出：false
 * <p>解释：
 * <p>数字 101 出现了 2 次，而数组的长度是 4。
 * <p>所以，101 不是 数组占绝大多数的元素，因为 2 次 = 4/2。
 *
 * <p>提示：
 * <p>1 <= nums.length <= 1000
 * <p>1 <= nums[i] <= 10^9
 * <p>1 <= target <= 10^9
 * https://leetcode-cn.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
 * <p>@author: wangrui
 * <p>@date: 2021/4/9
 */
public class Ch1150CheckIfANumberIsMajorityElementInASortedArray {

  public static void main(String[] args) {
    System.out.println(isMajorityElement(new int[]{10, 100, 101, 101}, 101));
  }

  public static boolean isMajorityElement(int[] nums, int target) {
    if (target != nums[(nums.length - 1) / 2]) {
      return false;
    }
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        ans++;
      }
      if (ans > nums.length / 2) {
        return true;
      }
    }
    return false;
  }

  /**
   * 这个比上面的好，仔细想想
   *
   * @param nums
   * @param target
   * @return
   */
  public boolean isMajorityElement_2(int[] nums, int target) {
    if (target != nums[(nums.length - 1) / 2]) {
      return false;
    }
    int count = 0;
    for (int n : nums) {
      if (target == n) {
        count++;
        continue;
      }
      if (target < n) {
        break;
      }
    }
    return count > (nums.length - 1) / 2;
  }
}
