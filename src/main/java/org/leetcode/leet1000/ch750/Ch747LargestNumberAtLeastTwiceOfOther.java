package org.leetcode.leet1000.ch750;

/**
 * <p>747. 至少是其他数字两倍的最大数
 *
 * <p>在一个给定的数组nums中，总是存在一个最大元素 。
 *
 * <p>查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 *
 * <p>如果是，则返回最大元素的索引，否则返回-1。
 *
 * <p>示例 1:
 *
 * <p>输入: nums = [3, 6, 1, 0]
 * <p>输出: 1
 * <p>解释: 6是最大的整数, 对于数组中的其他整数,
 * <p>6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 *
 *
 *
 * <p>示例 2:
 *
 * <p>输入: nums = [1, 2, 3, 4]
 * <p>输出: -1
 * <p>解释: 4没有超过3的两倍大, 所以我们返回 -1.
 *
 *
 *
 * <p>提示:
 * <p>https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/
 * <p>    nums 的长度范围在[1, 50].
 * <p>    每个 nums[i] 的整数范围在 [0, 100].
 * <p>@author: wangrui
 * <p>@date: 2021/3/24
 */
public class Ch747LargestNumberAtLeastTwiceOfOther {

  public static void main(String[] args) {
    System.out.println(dominantIndex(new int[]{0, 0, 0, 1}));
  }

  public static int dominantIndex(int[] nums) {
    int maxIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      maxIndex = nums[i] > nums[maxIndex] ? i : maxIndex;
    }
    for (int i = 0; i < nums.length; i++) {
      if (i != maxIndex && 2 * nums[i] > nums[maxIndex]) {
        return -1;
      }
    }

    return maxIndex;
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(N)。N 指的是 nums 的大小
   * <p> 空间复杂度：O(1)，只用了常数空间。
   *
   * @param nums
   * @return
   */
  public int dominantIndex2(int[] nums) {
    int maxIndex = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] > nums[maxIndex]) {
        maxIndex = i;
      }
    }
    for (int i = 0; i < nums.length; ++i) {
      if (maxIndex != i && nums[maxIndex] < 2 * nums[i]) {
        return -1;
      }
    }
    return maxIndex;
  }

}
