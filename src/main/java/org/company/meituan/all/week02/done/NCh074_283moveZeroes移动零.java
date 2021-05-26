package org.company.meituan.all.week02.done;

/**
 * <p>283. 移动零
 * <p>给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * <p>示例:
 *
 * <p>输入: [0,1,0,3,12]
 * <p>输出: [1,3,12,0,0]
 * <p>说明:
 *
 * <p>必须在原数组上操作，不能拷贝额外的数组。
 * <p>尽量减少操作次数。
 * <p>通过次数370,346提交次数580,926
 * <p>https://leetcode-cn.com/problems/move-zeroes/
 * <p>@Author: shenpei
 * <p>@Date: 2021/5/17 6:52 下午
 */
public class NCh074_283moveZeroes移动零 {

  public static void moveZeroes(int[] nums) {
    int zeroNum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        zeroNum++;
      } else if (zeroNum > 0) {
        nums[i - zeroNum] = nums[i];
        nums[i] = 0;
      }
    }
  }

  /**
   * 方法一：双指针 复杂度分析
   * <p>
   * 时间复杂度：O(n)，其中 nnn 为序列长度。每个位置至多被遍历两次。
   * <p>
   * 空间复杂度：O(1)。只需要常数的空间存放若干变量。
   *
   * @param nums
   */
  public void moveZeroes_2(int[] nums) {
    int n = nums.length, left = 0, right = 0;
    while (right < n) {
      if (nums[right] != 0) {
        swap(nums, left, right);
        left++;
      }
      right++;
    }
  }

  public void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }

}
