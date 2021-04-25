package org.leetcode.leet1000.ch1000;

import java.util.Arrays;

/**
 * <p>977. 有序数组的平方
 *
 * <p>给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [-4,-1,0,3,10]
 * <p>输出：[0,1,9,16,100]
 * <p>解释：平方后，数组变为 [16,1,0,9,100]
 * <p>排序后，数组变为 [0,1,9,16,100]
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [-7,-3,2,3,11]
 * <p>输出：[4,9,9,49,121]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length <= 104
 * <p>    -104 <= nums[i] <= 104
 * <p>    nums 已按 非递减顺序 排序
 *
 *
 *
 * <p>进阶：
 *
 * <p>    请你设计时间复杂度为 O(n) 的算法解决本问题
 *
 * <p>通过次数101,241
 * <p>提交次数138,404
 * <p>@author: wangrui
 * <p>@date: 2021/4/1
 */
public class Ch977SquaresOfASortedArray {

  public int[] sortedSquares(int[] nums) {
    int[] ans = new int[nums.length];
    int left = 0;
    int right = nums.length - 1;
    int n = nums.length - 1;
    while (left <= right) {
      if (nums[left] * nums[left] < nums[right] * nums[right]) {
        ans[n--] = nums[right] * nums[right];
        right--;
      } else {
        ans[n--] = nums[left] * nums[left];
        left++;
      }
    }
    return ans;
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(nlogn)，其中 n 是数组 nums 的长度。
   *
   * <p> 空间复杂度：O(logn)。除了存储答案的数组以外，我们需要 O(logn) 的栈空间进行排序。
   *
   * @param nums
   * @return
   */
  public int[] sortedSquares_1(int[] nums) {
    int[] ans = new int[nums.length];
    for (int i = 0; i < nums.length; ++i) {
      ans[i] = nums[i] * nums[i];
    }
    Arrays.sort(ans);
    return ans;
  }

  /**
   * <p> 复杂度分析
   *
   * <p>     时间复杂度：O(n)，其中 n 是数组 nums 的长度。
   *
   * <p>     空间复杂度：O(1)。除了存储答案的数组以外，我们只需要维护常量空间。
   *
   * @param nums
   * @return
   */
  public int[] sortedSquares_2(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
      if (nums[i] * nums[i] > nums[j] * nums[j]) {
        ans[pos] = nums[i] * nums[i];
        ++i;
      } else {
        ans[pos] = nums[j] * nums[j];
        --j;
      }
      --pos;
    }
    return ans;
  }


}
