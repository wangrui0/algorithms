package org.leetcode.shunxu.leet1500.ch1350;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>1346. 检查整数及其两倍数是否存在
 *
 * <p>给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 *<p>M）。
 *
 * <p>更正式地，检查是否存在两个下标 i 和 j 满足：
 *
 * <p>    i != j
 * <p>    0 <= i, j < arr.length
 * <p>    arr[i] == 2 *<p>arr[j]
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：arr = [10,2,5,3]
 * <p>输出：true
 * <p>解释：N = 10 是 M = 5 的两倍，即 10 = 2 *<p>5 。
 *
 * <p>示例 2：
 *
 * <p>输入：arr = [7,1,14,11]
 * <p>输出：true
 * <p>解释：N = 14 是 M = 7 的两倍，即 14 = 2 *<p>7 。
 *
 * <p>示例 3：
 *
 * <p>输入：arr = [3,1,7,11]
 * <p>输出：false
 * <p>解释：在该情况下不存在 N 和 M 满足 N = 2 *<p>M 。
 *
 *
 *
 * <p>提示：
 *
 * <p>    2 <= arr.length <= 500
 * <p>    -10^3 <= arr[i] <= 10^3
 *
 * <p>通过次数13,048
 * <p>提交次数29,858
 * <p>请问您在哪类招聘中遇到此题？
 * <p>@author: wangrui
 * <p>@date: 2021/4/18
 */
public class Ch1346CheckIfNAndItsDoubleExist {

  /**
   * 方法一:排序+双指针
   *
   * @param arr
   * @return
   */
  public boolean checkIfExist(int[] arr) {
    Arrays.sort(arr);
    int q = 0;
    for (int p = 0; p < arr.length; p++) {
      while (q < arr.length && arr[p] * 2 > arr[q]) {
        q++;
      }
      if (q != arr.length && p != q && arr[p] * 2 == arr[q]) {
        return true;
      }
    }
    return false;
  }

  /**
   * hashset
   *
   * @param arr
   * @return
   */
  public boolean checkIfExist_2(int[] arr) {
    Set<Integer> set = new HashSet<>();
    for (int x : arr) {
      if (set.contains(x * 2) || (x % 2 == 0 && set.contains(x / 2))) {
        return true;
      }
      set.add(x);
    }
    return false;
  }

}
