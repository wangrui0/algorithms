package org.leetcode.shunxu.leet1500.ch1300;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <p>1287. 有序数组中出现次数超过25%的元素
 *
 * <p>给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 *
 * <p>请你找到并返回这个整数
 *
 *
 *
 * <p>示例：
 *
 * <p>输入：arr = [1,2,2,6,6,6,6,7,10]
 * <p>输出：6
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= arr.length <= 10^4
 * <p>    0 <= arr[i] <= 10^5
 *
 * <p>通过次数13,021
 * <p>提交次数21,344
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array/
 * <p>@author: wangrui
 * <p>@date: 2021/4/12
 */
public class Ch1287ElementAppearingMoreThan25InSortedArray {

  public int findSpecialInteger(int[] arr) {
    // 1.循环遍历数组arr，统计每个数的出现次数并存放在HashMap中
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : arr) {
      if (map.containsKey(i)) {
        Integer val = map.get(i);
        val++;
        map.put(i, val);
      } else {
        map.put(i, 1);
      }
    }
    // 2.判断那个数的出现次数大于25%并返回
    Set<Integer> set = map.keySet();
    double limit = arr.length / 4;
    for (Integer key : set) {
      if (map.get(key) > limit) {
        return key;
      }
    }
    return -1;
  }


  public int findSpecialInteger_2(int[] arr) {
    int limit = arr.length / 4;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == arr[i + limit]) {
        return arr[i];
      }
    }
    return -1;
  }


  public int findSpecialInteger_3(int[] arr) {
    int limit = arr.length / 4;
    int slow = 0, fast = 0;
    int count;// 计数器，记录每个数的出现次数
    while (fast < arr.length) {
      if (arr[slow] != arr[fast]) {
        count = fast - slow;
        if (count > limit) {
          return arr[slow];
        }
        // 统计新数的出现次数，需要重置slow和count
        slow = fast;
      } else {
        fast++;
      }
    }
    if (fast == arr.length) {// 处理特殊边界情况：[1,2,3,3]
      return arr[slow];
    }
    return -1;
  }
}
