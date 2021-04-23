package org.leetcode.shunxu.leet2000.ch1550;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>1512. 好数对的数目
 *
 * <p>给你一个整数数组 nums 。
 *
 * <p>如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 *
 * <p>返回好数对的数目。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [1,2,3,1,1,3]
 * <p>输出：4
 * <p>解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [1,1,1,1]
 * <p>输出：6
 * <p>解释：数组中的每组数字都是好数对
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [1,2,3]
 * <p>输出：0
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length <= 100
 * <p>    1 <= nums[i] <= 100
 *
 * <p>通过次数51,749
 * <p>提交次数60,940
 * <p>https://leetcode-cn.com/problems/number-of-good-pairs/
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1512NumberOfGoodPairs {

  /**
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(n^2)。
   * <p> 空间复杂度：O(1)。
   *
   * @param nums
   * @return
   */
  public int numIdenticalPairs(int[] nums) {
    int ans = 0;
    for (int i = 0; i < nums.length; ++i) {
      for (int j = i + 1; j < nums.length; ++j) {
        if (nums[i] == nums[j]) {
          ++ans;
        }
      }
    }
    return ans;
  }

  /**
   * 思路与算法
   *
   *
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(n)。
   * <p>  空间复杂度：O(n)，即哈希表使用到的辅助空间的空间代价
   *
   * @param nums
   * @return
   */
  public int numIdenticalPairs_2(int[] nums) {
    Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    for (int num : nums) {
      m.put(num, m.getOrDefault(num, 0) + 1);
    }

    int ans = 0;
    for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
      int v = entry.getValue();
      ans += v * (v - 1) / 2;
    }

    return ans;
  }


}
