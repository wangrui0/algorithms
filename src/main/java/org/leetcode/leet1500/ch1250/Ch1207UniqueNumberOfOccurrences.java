package org.leetcode.leet1500.ch1250;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>1207. 独一无二的出现次数
 *
 * <p>给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * <p>如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：arr = [1,2,2,1,1,3]
 * <p>输出：true
 * <p>解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 *
 * <p>示例 2：
 *
 * <p>输入：arr = [1,2]
 * <p>输出：false
 *
 * <p>示例 3：
 *
 * <p>输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * <p>输出：true
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= arr.length <= 1000
 * <p>    -1000 <= arr[i] <= 1000
 * <p>https://leetcode-cn.com/problems/unique-number-of-occurrences/
 * <p>@author: wangrui
 * <p>@date: 2021/4/10
 */
public class Ch1207UniqueNumberOfOccurrences {

  public boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int x : arr) {
      map.put(x, map.getOrDefault(x, 0) + 1);
    }
    Set<Integer> set = new HashSet<>();
    set.addAll(map.values());
    return map.size() == set.size();
  }

  /**
   * 复杂度分析
   * <p>
   * 时间复杂度：O(N)O(N)O(N)，其中 NNN 为数组的长度。遍历原始数组需要 O(N)O(N)O(N) 时间，而遍历中间过程产生的哈希表又需要 O(N)O(N)O(N) 的时间。
   * <p>
   * 空间复杂度：O(N)O(N)O(N)。
   *
   * @param arr
   * @return
   */
  public boolean uniqueOccurrences_2(int[] arr) {
    Map<Integer, Integer> occur = new HashMap<Integer, Integer>();
    for (int x : arr) {
      occur.put(x, occur.getOrDefault(x, 0) + 1);
    }
    Set<Integer> times = new HashSet<Integer>();
    for (Map.Entry<Integer, Integer> x : occur.entrySet()) {
      times.add(x.getValue());
    }
    return times.size() == occur.size();
  }


}
