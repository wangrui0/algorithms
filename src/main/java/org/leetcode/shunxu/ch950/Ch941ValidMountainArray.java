package org.leetcode.shunxu.ch950;

/**
 * <p>941. 有效的山脉数组
 *
 * <p>给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * <p>让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * <p>    arr.length >= 3
 * <p>    在 0 < i < arr.length - 1 条件下，存在 i 使得：
 * <p>        arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * <p>        arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 *
 *
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：arr = [2,1]
 * <p>输出：false
 *
 * <p>示例 2：
 *
 * <p>输入：arr = [3,5,5]
 * <p>输出：false
 *
 * <p>示例 3：
 *
 * <p>输入：arr = [0,3,2,1]
 * <p>输出：true
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= arr.length <= 104
 * <p>    0 <= arr[i] <= 104
 * <p>@author: wangrui
 * <p>@date: 2021/4/1
 */
public class Ch941ValidMountainArray {


  public static boolean validMountainArray(int[] arr) {
    if (arr.length == 0) {
      return false;
    }
    int i = 0;
    boolean asc = false;
    boolean desc = false;
    while (i < arr.length - 1 && arr[i] < arr[i + 1]) {
      i++;
      asc = true;
    }
    while (asc && i < arr.length - 1 && arr[i] > arr[i + 1]) {
      i++;
      desc = true;
    }
    return asc && desc && i == arr.length - 1;
  }
  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(N)，其中 N 是数组 arr 的长度。
   *
   * <p>   空间复杂度：O(1)。
   *
   * @param arr
   * @return
   */
  public boolean validMountainArray_1(int[] arr) {
    int N = arr.length;
    int i = 0;

    // 递增扫描
    while (i + 1 < N && arr[i] < arr[i + 1]) {
      i++;
    }

    // 最高点不能是数组的第一个位置或最后一个位置
    if (i == 0 || i == N - 1) {
      return false;
    }

    // 递减扫描
    while (i + 1 < N && arr[i] > arr[i + 1]) {
      i++;
    }

    return i == N - 1;
  }


}
