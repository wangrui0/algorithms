package org.leetcode.shunxu.leet1500.ch1400;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>1394. 找出数组中的幸运数
 *
 * <p>在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
 *
 * <p>给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 *
 * <p>    如果数组中存在多个幸运数，只需返回 最大 的那个。
 * <p>    如果数组中不含幸运数，则返回 -1 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：arr = [2,2,3,4]
 * <p>输出：2
 * <p>解释：数组中唯一的幸运数是 2 ，因为数值 2 的出现频次也是 2 。
 *
 * <p>示例 2：
 *
 * <p>输入：arr = [1,2,2,3,3,3]
 * <p>输出：3
 * <p>解释：1、2 以及 3 都是幸运数，只需要返回其中最大的 3 。
 *
 * <p>示例 3：
 *
 * <p>输入：arr = [2,2,2,3,3]
 * <p>输出：-1
 * <p>解释：数组中不存在幸运数。
 *
 * <p>示例 4：
 *
 * <p>输入：arr = [5]
 * <p>输出：-1
 *
 * <p>示例 5：
 *
 * <p>输入：arr = [7,7,7,7,7,7,7]
 * <p>输出：7
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= arr.length <= 500
 * <p>    1 <= arr[i] <= 500
 *
 * <p>通过次数14,654
 * <p>提交次数22,089
 * <p>https://leetcode-cn.com/problems/find-lucky-integer-in-an-array/
 * <p>@author: wangrui
 * <p>@date: 2021/4/18
 */
public class Ch1394FindLuckyIntegerInAnArray {

  /**
   * <p>复杂度分析
   *
   * <p>记数组中的的元素个数为 n，则哈希表中最多有 n 个键值对。
   *
   * <p>   时间复杂度：遍历数组的时间代价是 O(n)，遍历哈希表的时间代价也是 O(n)，故渐进时间复杂度 O(n)。
   *
   * <p>  空间复杂度：哈希表中最多有 n 个键值对，故渐进空间复杂度 O(n)。
   *
   * @param arr
   * @return
   */
  public int findLucky(int[] arr) {
    Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    for (int x : arr) {
      m.put(x, m.getOrDefault(x, 0) + 1);
    }
    int ans = -1;
    for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
      int key = entry.getKey(), value = entry.getValue();
      if (key == value) {
        ans = Math.max(ans, key);
      }
    }
    return ans;
  }

  public int findLucky_self(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int x : arr) {
      map.put(x, map.getOrDefault(x, 0) + 1);
    }
    int ans = -1;
    for (Integer key : map.keySet()) {
      if (key == map.get(key) && key > ans) {
        ans = key;
      }
    }
    return ans;
  }

}


