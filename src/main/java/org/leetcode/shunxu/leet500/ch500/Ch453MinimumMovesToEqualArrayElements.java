package org.leetcode.shunxu.leet500.ch500;

import java.util.Arrays;

/**
 * <p>453. 最小操作次数使数组元素相等
 *
 * <p>给定一个长度为 n 的 非空 整数数组，每次操作将会使 n - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。
 *
 *
 *
 * <p>示例：
 * <p>
 * 输入：
 * <p> [1,2,3]
 * <p> 输出：
 * <p> 3
 * <p>解释：
 * <p>只需要3次操作（注意每次操作会增加两个元素的值）：
 * <p>[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 * <p>https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
 *
 * @author: wangrui
 * @date: 2021/3/4
 */
public class Ch453MinimumMovesToEqualArrayElements {

  /**
   * <p>复杂度分析(可能会超时)
   *
   * <p>   时间复杂度：O(n^2)。每次迭代中两个元素是相等的。
   * <p>  空间复杂度：O(1)。不需要额外空间。
   *
   * <p>作者：LeetCode
   * <p>链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/solution/zui-xiao-yi-dong-ci-shu-shi-shu-zu-yuan-su-xiang-d/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public int minMoves(int[] nums) {
    int min = 0, max = nums.length - 1, count = 0;
    while (true) {
      for (int i = 0; i < nums.length; i++) {
        if (nums[max] < nums[i]) {
          max = i;
        }
        if (nums[min] > nums[i]) {
          min = i;
        }
      }
      int diff = nums[max] - nums[min];
      if (diff == 0) {
        break;
      }
      count += diff;
      for (int i = 0; i < nums.length; i++) {
        if (i != max) {
          nums[i] = nums[i] + diff;
        }
      }
    }
    return count;
  }

  /**
   * <p>复杂度分析
   * <p>时间复杂度：O(nlog(n))。 排序需要 O(nlog(n)) 的时间。
   * <p>空间复杂度：O(1)。不需要额外空间。
   *
   * @param nums
   * @return
   */
  public int minMoves2(int[] nums) {
    Arrays.sort(nums);
    int count = 0;
    for (int i = nums.length - 1; i > 0; i--) {
      count += nums[i] - nums[0];
    }
    return count;
  }

  /**
   * <p>复杂度分析
   * <p>时间复杂度：O(n)。一次遍历寻找最小值，一次遍历计算次数。
   * <p>空间复杂度：O(1)。不需要额外空间。
   *
   * @param nums
   * @return
   */
  public int minMoves3(int[] nums) {
    int moves = 0, min = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      min = Math.min(min, nums[i]);
    }
    for (int i = 0; i < nums.length; i++) {
      moves += nums[i] - min;
    }
    return moves;
  }


}
