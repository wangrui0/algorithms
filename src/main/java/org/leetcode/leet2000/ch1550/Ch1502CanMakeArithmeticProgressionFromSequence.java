package org.leetcode.leet2000.ch1550;

import java.util.Arrays;

/**
 * <p>1502. 判断能否形成等差数列
 *
 * <p>给你一个数字数组 arr 。
 *
 * <p>如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
 *
 * <p>如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：arr = [3,5,1]
 * <p>输出：true
 * <p>解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
 *
 * <p>示例 2：
 *
 * <p>输入：arr = [1,2,4]
 * <p>输出：false
 * <p>解释：无法通过重新排序得到等差数列。
 *
 *
 *
 * <p>提示：
 *
 * <p>    2 <= arr.length <= 1000
 * <p>    -10^6 <= arr[i] <= 10^6
 *
 * <p>通过次数21,942
 * <p>提交次数30,457
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence/
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1502CanMakeArithmeticProgressionFromSequence {

  /**
   * <p>  复杂度分析
   *
   * <p>    时间复杂度：O(nlogn)。排序的时间代价为 O(nlogn)。
   * <p>    空间复杂度：O(logn)。快速排序中使用的栈空间期望是 O(logn)。
   *
   * @param arr
   * @return
   */
  public boolean canMakeArithmeticProgression(int[] arr) {
    Arrays.sort(arr);
    for (int i = 1; i < arr.length - 1; i++) {
      if (arr[i] * 2 != arr[i + 1] + arr[i - 1]) {
        return false;
      }
    }
    return true;
  }

  public boolean canMakeArithmeticProgression_2(int[] arr) {
    Arrays.sort(arr);
    for (int i = 1; i < arr.length - 1; ++i) {
      if (arr[i] * 2 != arr[i - 1] + arr[i + 1]) {
        return false;
      }
    }
    return true;
  }


}
