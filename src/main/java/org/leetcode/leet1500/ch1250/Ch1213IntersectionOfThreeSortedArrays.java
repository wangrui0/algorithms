package org.leetcode.leet1500.ch1250;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>LeetCode 1213. 三个有序数组的交集（哈希set）
 * <p>2020-07-13阅读 1170
 * <p>文章目录
 * <p>1. 题目
 * <p>2. 解题
 * <p>1. 题目
 * <p>给出三个均为 严格递增排列 的整数数组 arr1，arr2 和 arr3。
 *
 * <p>返回一个由 仅 在这三个数组中 同时出现 的整数所构成的有序数组。
 *
 * <p>示例：
 * <p>输入: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * <p>输出: [1,5]
 * <p>解释: 只有 1 和 5 同时在这三个数组中出现.
 *
 * <p>提示：
 * <p>1 <= arr1.length, arr2.length, arr3.length <= 1000
 * <p>1 <= arr1[i], arr2[i], arr3[i] <= 2000
 * <p>https://leetcode-cn.com/problems/intersection-of-three-sorted-arrays/
 * <p>@author: wangrui
 * <p>@date: 2021/4/10
 */
public class Ch1213IntersectionOfThreeSortedArrays {

  public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
    List<Integer> list = new ArrayList<>();
    int i = 0, j = 0, k = 0;
    int min;
    while (i < arr1.length && j < arr2.length && k < arr3.length) {
      if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
        list.add(arr1[i]);
        i++;
        j++;
        k++;
      } else {
        min = Math.min(Math.min(arr1[i], arr2[j]), arr3[k]);
        if (min == arr1[i]) {
          i++;
        }
        if (min == arr2[j]) {
          j++;
        }
        if (min == arr3[k]) {
          k++;
        }
      }
    }
    return list;
  }
}
