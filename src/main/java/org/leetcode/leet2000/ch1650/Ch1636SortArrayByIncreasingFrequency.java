package org.leetcode.leet2000.ch1650;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>1636. 按照频率将数组升序排序
 *
 * <p>给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 *
 * <p>请你返回排序后的数组。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [1,1,2,2,2,3]
 * <p>输出：[3,1,1,2,2,2]
 * <p>解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [2,3,1,3,2]
 * <p>输出：[1,3,3,2,2]
 * <p>解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [-1,1,-6,4,5,-6,1,4,1]
 * <p>输出：[5,-1,4,4,-6,-6,1,1,1]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length <= 100
 * <p>    -100 <= nums[i] <= 100
 *
 * <p>通过次数6,842
 * <p>提交次数9,635
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/sort-array-by-increasing-frequency/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 7:27 下午
 */
public class Ch1636SortArrayByIncreasingFrequency {

  public static int[] frequencySort(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);

    Arrays.sort(integers, (o1, o2) -> map.get(o1) - map.get(o2) == 0 ? o2 - o1 : map.get(o1) - map.get(o2));
    return Arrays.stream(integers).mapToInt(Integer::intValue).toArray();
  }

  public int[] frequencySort_2(int[] nums) {
    int[] cnts = new int[201];
    for (int n : nums) {
      cnts[n + 100]++;
    }

    for (int i = 0; i < nums.length; i++) {
      nums[i] = 10000 * cnts[nums[i] + 100] - nums[i] + 100;
    }
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      nums[i] = 100 - nums[i] % 10000;
    }

    return nums;
  }
}
