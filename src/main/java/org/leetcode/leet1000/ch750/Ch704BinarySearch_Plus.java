package org.leetcode.leet1000.ch750;

/**
 * <p>704. 二分查找
 *
 * <p>给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 * <p>示例 1:
 *
 * <p>输入: nums = [-1,0,3,5,9,12], target = 9
 * <p>输出: 4
 * <p>解释: 9 出现在 nums 中并且下标为 4
 *
 * <p>示例 2:
 *
 * <p>输入: nums = [-1,0,3,5,9,12], target = 2
 * <p>输出: -1
 * <p>解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * <p>
 * (如果有重复的，返回第一个重复的)
 * <p>提示：
 *
 * <p>    你可以假设 nums 中的所有元素是不重复的。
 * <p>    n 将在 [1, 10000]之间。
 * <p>    nums 的每个元素都将在 [-9999, 9999]之间。
 * https://leetcode-cn.com/problems/binary-search/
 * <p>通过次数104,107
 * <p>提交次数185,991
 * <p>在真实的面试中遇到过这道题？
 * <p>贡献者
 * <p>@author: wangrui
 * <p>@date: 2021/3/23
 */
public class Ch704BinarySearch_Plus {

  /**
   * 可能包含重复的
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(search(new int[]{1, 2, 2, 3, 4, 4, 4, 4, 5, 5, 6}, 100));
  }

  public static int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] >= target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left <= nums.length - 1 ? left : -1;
  }

}
