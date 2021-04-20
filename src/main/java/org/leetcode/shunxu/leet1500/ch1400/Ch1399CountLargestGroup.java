package org.leetcode.shunxu.leet1500.ch1400;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>1399. 统计最大组的数目
 *
 * <p>给你一个整数 n 。请你先求出从 1 到 n 的每个整数 10 进制表示下的数位和（每一位上的数字相加），然后把数位和相等的数字放到同一个组中。
 *
 * <p>请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：n = 13
 * <p>输出：4
 * <p>解释：总共有 9 个组，将 1 到 13 按数位求和后这些组分别是：
 * <p>[1,10]，[2,11]，[3,12]，[4,13]，[5]，[6]，[7]，[8]，[9]。总共有 4 个组拥有的数字并列最多。
 *
 * <p>示例 2：
 *
 * <p>输入：n = 2
 * <p>输出：2
 * <p>解释：总共有 2 个大小为 1 的组 [1]，[2]。
 *
 * <p>示例 3：
 *
 * <p>输入：n = 15
 * <p>输出：6
 *
 * <p>示例 4：
 *
 * <p>输入：n = 24
 * <p>输出：5
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= n <= 10^4
 *
 * <p>通过次数7,879
 * <p>提交次数11,901
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/count-largest-group/
 * <p>@author: wangrui
 * <p>@date: 2021/4/18
 */
public class Ch1399CountLargestGroup {

  /**
   * <p> 复杂度分析
   *
   * <p>   时间复杂度：对数 x 求数位和的时间为 O(log⁡10x)=O(log⁡x)O(\log_{10} x) = O(\log x)O(log10​x)=O(logx)，因此总时间代价为 O(nlog⁡n)O(n
   * \log n)O(nlogn)，选出最大元素和遍历哈希表的时间代价均为 O(n)O(n)O(n)，故渐渐时间复杂度 O(nlog⁡n)+O(n)=O(nlog⁡n)O(n \log n) + O(n) = O(n \log
   * n)O(nlogn)+O(n)=O(nlogn)。
   *
   * <p>   空间复杂度：使用哈希表作为辅助空间，nnn 的数位个数为 O(log⁡10n)=O(log⁡n)O(\log_{10} n) = O(\log n)O(log10​n)=O(logn)，每一个数位都在
   * [0,9][0,
   * 9][0,9] 之间，故哈希表最多包含的键的个数为 O(10log⁡n)=O(log⁡n)O(10 \log n) = O(\log n)O(10logn)=O(logn)，渐进空间复杂度为 O(log⁡n)O(\log
   * n)O(logn)。
   *
   * @param n
   * @return
   */
  public int countLargestGroup(int n) {
    Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    int maxValue = 0;
    for (int i = 1; i <= n; ++i) {
      int key = 0, i0 = i;
      while (i0 != 0) {
        key += i0 % 10;
        i0 /= 10;
      }
      hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
      maxValue = Math.max(maxValue, hashMap.get(key));
    }
    int count = 0;
    for (Map.Entry<Integer, Integer> kvpair : hashMap.entrySet()) {
      if (kvpair.getValue() == maxValue) {
        ++count;
      }
    }
    return count;
  }

  public static int countLargestGroup_self(int n) {
    Map<Integer, Integer> map = new HashMap<>();
    int maxValue = 0;
    for (int i = 1; i <= n; i++) {
      int sum = 0;
      int temp = i;
      while (temp > 0) {
        sum += (temp % 10);
        temp /= 10;
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
      maxValue = Math.max(maxValue, map.get(sum));
    }
    int ans = 0;
    for (int key : map.keySet()) {
      if (map.get(key) == maxValue) {
        ans++;
      }
    }
    return ans;
  }


}
