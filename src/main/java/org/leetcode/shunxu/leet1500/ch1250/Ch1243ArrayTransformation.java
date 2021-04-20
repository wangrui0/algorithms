package org.leetcode.shunxu.leet1500.ch1250;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>LeetCode 1243. 数组变换
 * <p>2020-07-13阅读 850
 * <p>1. 题目
 * <p>首先，给你一个初始数组 arr。然后，每天你都要根据前一天的数组生成一个新的数组。
 *
 * <p>第 i 天所生成的数组，是由你对第 i-1 天的数组进行如下操作所得的：
 *
 * <p>假如一个元素小于它的左右邻居，那么该元素自增 1。
 * <p>假如一个元素大于它的左右邻居，那么该元素自减 1。
 * <p>首、尾元素 永不 改变。
 * <p>过些时日，你会发现数组将会不再发生变化，请返回最终所得到的数组。
 *
 * <p>示例 1：
 * <p>输入：[6,2,3,4]
 * <p>输出：[6,3,3,4]
 * <p>解释：
 * <p>第一天，数组从 [6,2,3,4] 变为 [6,3,3,4]。
 * <p>无法再对该数组进行更多操作。
 *
 * <p>示例 2：
 * <p>输入：[1,6,3,4,3,5]
 * <p>输出：[1,4,4,4,4,5]
 * <p>解释：
 * <p>第一天，数组从 [1,6,3,4,3,5] 变为 [1,5,4,3,4,5]。
 * <p>第二天，数组从 [1,5,4,3,4,5] 变为 [1,4,4,4,4,5]。
 * <p>无法再对该数组进行更多操作。
 *
 * <p>提示：
 * <p>1 <= arr.length <= 100
 * <p>1 <= arr[i] <= 100
 * <p>https://leetcode-cn.com/problems/array-transformation/
 * <p>@author: wangrui
 * <p>@date: 2021/4/12
 */
public class Ch1243ArrayTransformation {

  public List<Integer> transformArray(int[] arr) {
    int length = arr.length;
    if (length <= 2) {  // 装载 list 直接返回
      List<Integer> list = new ArrayList<>();
      for (int n : arr) {
        list.add(n);
      }
      return list;
    }
    boolean isChange = true;
    int[] lastArr;
    while (isChange) {
      isChange = false;
      lastArr = Arrays.copyOf(arr, length);
      for (int i = 1; i < length - 1; i++) {
        if (lastArr[i] > lastArr[i - 1] && lastArr[i] > lastArr[i + 1]) {
          arr[i]--;
          isChange = true;
        }
        if (lastArr[i] < lastArr[i - 1] && lastArr[i] < lastArr[i + 1]) {
          arr[i]++;
          isChange = true;
        }
      }
    }
    // 此时的 arr 已经没法再变了
    List<Integer> list = new ArrayList<>();
    for (int n : arr) {
      list.add(n);
    }
    return list;
  }
}
