package org.company.meituan.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>128. 最长连续序列
 *
 * <p>给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 *
 *
 * <p>进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [100,4,200,1,3,2]
 * <p>输出：4
 * <p>解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * <p>输出：9
 *
 *
 *
 * <p>提示：
 *
 * <p>    0 <= nums.length <= 104
 * <p>    -109 <= nums[i] <= 109
 *
 * <p>通过次数113,747
 * <p>提交次数212,927
 * <p>请问您在哪类招聘中遇到此题？
 * <p>|128. 最长连续序列|2|https://leetcode-cn.com/problems/longest-consecutive-sequence|
 * <p>@author: wangrui
 * <p>@date: 2021/4/30
 */
public class Ch003LongestConsecutiveSequence最长连续子序列 {

  /**
   * <p>那么怎么判断是否跳过呢？由于我们要枚举的数 x 一定是在数组中不存在前驱数 x−1 的，不然按照上面的分析我们会从 x−1 开始尝试匹配，因此我们每次在哈希表中检查是否存在 x−1 即能判断是否需要跳过了。
   * 复杂度分析
   *
   * <p> 时间复杂度：O(n)，其中 n 为数组的长度。具体分析已在上面正文中给出。
   *
   * <p>  空间复杂度：O(n)。哈希表存储数组中所有的数需要 O(n) 的空间。
   *
   * @param nums
   * @return
   */
  public int longestConsecutive(int[] nums) {
    Set<Integer> num_set = new HashSet<Integer>();
    for (int num : nums) {
      num_set.add(num);
    }

    int longestStreak = 0;

    for (int num : num_set) {
      if (!num_set.contains(num - 1)) {
        int currentNum = num;
        int currentStreak = 1;

        while (num_set.contains(currentNum + 1)) {
          currentNum += 1;
          currentStreak += 1;
        }

        longestStreak = Math.max(longestStreak, currentStreak);
      }
    }

    return longestStreak;
  }
}
