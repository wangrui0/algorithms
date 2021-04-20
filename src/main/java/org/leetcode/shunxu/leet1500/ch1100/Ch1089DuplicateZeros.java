package org.leetcode.shunxu.leet1500.ch1100;

/**
 * <p>1089. 复写零
 *
 * <p>给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 *
 * <p>注意：请不要在超过该数组长度的位置写入元素。
 *
 * <p>要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：[1,0,2,3,0,4,5,0]
 * <p>输出：null
 * <p>解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 *
 * <p>示例 2：
 *
 * <p>输入：[1,2,3]
 * <p>输出：null
 * <p>解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= arr.length <= 10000
 * <p>    0 <= arr[i] <= 9
 *
 * <p>通过次数16,443
 * <p>提交次数28,381
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/duplicate-zeros/
 * <p>@author: wangrui
 * <p>@date: 2021/4/5
 */
public class Ch1089DuplicateZeros {

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(N)，其中 N 是元素个数。遍历两次数组，第一次计算 possible_dups，第二次复制元素。最坏情况下，数组中的零非常少或者没有零，需要遍历整个数组。
   *
   * <p>   空间复杂度：O(1)，不使用额外空间。
   *
   * @param arr
   */
  public void duplicateZeros(int[] arr) {
    int possibleDups = 0;
    int length = arr.length - 1;

    // Find the number of zeros to be duplicated
    // Stopping when left points beyond the last element in the original array
    // which would be part of the modified array
    for (int left = 0; left <= length - possibleDups; left++) {

      // Count the zeros
      if (arr[left] == 0) {

        // Edge case: This zero can't be duplicated. We have no more space,
        // as left is pointing to the last element which could be included
        if (left == length - possibleDups) {
          // For this zero we just copy it without duplication.
          arr[length] = 0;
          length -= 1;
          break;
        }
        possibleDups++;
      }
    }

    // Start backwards from the last element which would be part of new array.
    int last = length - possibleDups;

    // Copy zero twice, and non zero once.
    for (int i = last; i >= 0; i--) {
      if (arr[i] == 0) {
        arr[i + possibleDups] = 0;
        possibleDups--;
        arr[i + possibleDups] = 0;
      } else {
        arr[i + possibleDups] = arr[i];
      }
    }
  }
}
