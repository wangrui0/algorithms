package org.leetcode.leet1500.ch1150;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>1133. 最大唯一数
 * <p>1. 题目
 * <p>给你一个整数数组 A，请找出并返回在该数组中仅出现一次的最大整数。
 *
 * <p>如果不存在这个只出现一次的整数，则返回 -1。
 *
 * <p>示例 1：
 * <p>输入：[5,7,3,9,4,9,8,3,1]
 * <p>输出：8
 * <p>解释：
 * <p>数组中最大的整数是 9，但它在数组中重复出现了。
 * <p>而第二大的整数是 8，它只出现了一次，所以答案是 8。
 *
 * <p>示例 2：
 * <p>输入：[9,9,8,8]
 * <p>输出：-1
 * <p>解释：
 * <p>数组中不存在仅出现一次的整数。
 *
 * <p>提示：
 * <p>1 <= A.length <= 2000
 * <p>0 <= A[i] <= 1000
 * <p>https://leetcode-cn.com/problems/largest-unique-number/
 * <p>@author: wangrui
 * <p>@date: 2021/4/9
 */
public class Ch1133LargestUniqueNumber {

  /*  解法一：排序+倒叙遍历
      1、把数组进行从小到大排序；

      2、从数组的最尾端元素开始遍历，如果遍历到的元素前面和后面都和它不一样，则它就算仅出现一次的最大整数‘

      3、如果遍历完都找不到一个和前后都不一样的元素，则返回 -1；

      解法二：哈希表

        1、把数组中元素和出现次数统计并保存到 HashMap 中；

      2、遍历 map，从次数为 1 的元素中选择最大的返回；*/
  public static int largestUniqueNumber(int[] A) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int x : A) {
      map.put(x, map.getOrDefault(x, 0) + 1);
    }
    int ans = -1;
    for (Integer key : map.keySet()) {
      Integer num = map.get(key);
      if (num == 1 && key > ans) {
        ans = key;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(largestUniqueNumber(new int[]{5, 5,6,6}));
  }
}
